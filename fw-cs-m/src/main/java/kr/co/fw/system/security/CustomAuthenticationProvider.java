package kr.co.fw.system.security;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import kr.co.fw.common.util.CommUtil;
import kr.co.fw.common.util.CryptoUtil;
import kr.co.fw.system.login.LoginService;
import kr.co.fw.system.security.model.CustomUser;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private LoginService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		User user = new User();
		User retuser = new User();
		// Map<String, String> map = new HashMap<String, String>();
		String login_id = authentication.getName();// 로그인아이디
		String login_pw = (String) authentication.getCredentials();// 로그인패스워드
		log.info("login_id : " + login_id);
		log.info("login_pw : " + login_pw);

		user.setLogin_id(login_id);
		retuser = userService.getUser(user);
		if (CommUtil.isEmpty(retuser)) {
			log.info("계정정보가 업습니다. 0");
			throw new BadCredentialsException("계정정보가 업거나 비빌번호가 일치하지 않습니다.");
		} else {
			log.info("user : " + retuser.toString());			
		}

		List<String> roleList = new ArrayList<String>();
		roleList = userService.getRoleList(retuser);
		log.info("roleList.size : " + roleList.size());
		retuser.setAuthorities(roleList);
		log.info("user : " + retuser.toString());
		try {
			if (CommUtil.isNotEmpty(retuser.getPassword())) {
				if (!login_pw.equals(CryptoUtil.decrypt(retuser.getPassword()))) {
					log.info("계정정보가 업거나 비빌번호가 일치하지 않습니다. 1");
					throw new BadCredentialsException("계정정보가 업거나 비빌번호가 일치하지 않습니다.");
				}
			} else {
				log.info("계정정보가 업거나 비빌번호가 일치하지 않습니다. 2");
				throw new BadCredentialsException("계정정보가 업거나 비빌번호가 일치하지 않습니다.");
			}
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			log.info("에러발생 3");
			e.printStackTrace();
			throw new BadCredentialsException("계정정보가 업거나 비빌번호가 일치하지 않습니다.");
		}
		log.info("queried user : " + retuser.toString());

		return new UsernamePasswordAuthenticationToken(new CustomUser(retuser), roleList);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
