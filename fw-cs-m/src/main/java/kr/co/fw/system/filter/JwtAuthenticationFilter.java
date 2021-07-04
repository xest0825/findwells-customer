package kr.co.fw.system.filter;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import kr.co.fw.config.SecurityConstants;
import kr.co.fw.system.security.model.CustomUser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private final AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mb_id = request.getParameter("mb_id");
		log.info("attempAuthentication : username : " + username + ", password: " + password + ", mb_id : " + mb_id);
		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
	public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain, Authentication authentication) {
		log.info("successfulAuthentication authentication : " + authentication);
		log.info("successfulAuthentication authentication.getPrincipal()" + authentication.getPrincipal());

		CustomUser user = (CustomUser) authentication.getPrincipal();
		String username = user.getUsername();
//		String password = user.getPassword();
		List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());
		String mb_id = user.getMb_id();

		log.info("username : " + username + ", roles : " + roles);
//		String token = username + "_" + roles;
		String token = createToken(username, roles, mb_id);
		log.info("token : " + token);

		response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
	}

	private String createToken(String username, List<String> roles, String mb_id) {
		byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();

		String token = Jwts.builder().signWith(Keys.hmacShaKeyFor(signingkey), SignatureAlgorithm.HS512)
				.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + 864000000))
				.claim("uid", username)
				.claim("mid", mb_id)
				.claim("rol", roles)
				.compact();

		log.info("token : " + token);

		return token;

	}
}
