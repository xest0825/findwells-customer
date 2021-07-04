package kr.co.fw.system.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import kr.co.fw.config.SecurityConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	

	
	/*
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginVO loginVO){
		
		String username = loginVO.getUsername();
		String password = loginVO.getPassword();
		String mb_id	= loginVO.getMb_id();
		log.info("username : " + username + ", password : " + password + ", mb_id : " + mb_id.toUpperCase());
		List<String> roleList = new ArrayList<String>();
		roleList.add("ROLE_USER");
		
//		String token = username + "_" + roleList;
		
		// 등록 클레임을 사용한 jwt작성
		byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();
		
		
		String token = Jwts.builder()
				.signWith(Keys.hmacShaKeyFor(signingkey), SignatureAlgorithm.HS512)
				.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
				.setIssuer(SecurityConstants.TOKEN_ISSUER)
				.setAudience(SecurityConstants.TOKEN_AUDIENCE)
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + 864000000))
				.claim("rol", roleList)
				.compact();
		
		String token = Jwts.builder()
				.signWith(Keys.hmacShaKeyFor(signingkey), SignatureAlgorithm.HS512)
				.setHeaderParam("typ", SecurityConstants.TOKEN_TYPE)
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + 864000000))
				.claim("uid", username)
				.claim("mid", mb_id.toUpperCase())
				.claim("rol", roleList)
				.compact();
		
		log.info("token : " + token);
		
		
		
		ResponseEntity<String> entity = new ResponseEntity<String>(token, HttpStatus.OK);
		
		return entity;
	}
	*/
	
	@GetMapping("/userInfo")
	public ResponseEntity<String> getUserInfo(@RequestHeader(name="Authorization") String header) {
		log.info("header : " + header);
		String token = header.substring(6);
		
		log.info("token : " + token);
		
		byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();
		Jws<Claims> parsedToken = Jwts.parser()
				.setSigningKey(signingkey)
				.parseClaimsJws(token);
		
		log.info("parsedToken : " + parsedToken);
		
		String username = parsedToken.getBody().getSubject();
		log.info("username : " + username);
		
		Claims claims = parsedToken.getBody();
		Object roleList = claims.get("rol");
		log.info("roleList  :" + roleList);
		
		return new ResponseEntity<String>(parsedToken.toString(), HttpStatus.OK);
	}
	
}
