package kr.co.fw.system.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import kr.co.fw.config.SecurityConstants;
import kr.co.fw.system.security.model.CustomUser;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {

	public JwtRequestFilter() {
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader(SecurityConstants.TOKEN_HEADER);

		if (isEmpty(header) || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			filterChain.doFilter(request, response);
			return;
		}

		Authentication authentication = this.getAuthentication(header);
		log.info("authentication : " + authentication);
		log.info("authentication.getPrincipal() : " + authentication.getPrincipal());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		filterChain.doFilter(request, response);

	}

	@SuppressWarnings("unchecked")
	private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
		if (isNotEmpty(tokenHeader)) {
			try {
				byte[] signingkey = SecurityConstants.JWT_SECRET.getBytes();

				Jws<Claims> parsedToken = Jwts.parser().setSigningKey(signingkey)
						.parseClaimsJws(tokenHeader.replace("Bearer", ""));

				Claims claims = parsedToken.getBody();
				String userId = (String) claims.get("uid");
				String mb_id = (String) claims.get("mid");
				List<SimpleGrantedAuthority> authorities = ((List<?>) claims.get("rol")).stream()
						.map(authority -> new SimpleGrantedAuthority((String) authority)).collect(Collectors.toList());

				if (isNotEmpty(userId)) {
					User user = new User();
					user.setUsername(userId);
					user.setLogin_id(userId);
					user.setAuthorities((List<String>) claims.get("rol"));
					user.setMb_id(mb_id);
					CustomUser userDetails = new CustomUser(user);
					return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
				}

			} catch (ExpiredJwtException exception) {
				log.warn("Request to parse expired JWT : {} failed : {}", tokenHeader, exception.getMessage());

			} catch (UnsupportedJwtException exception) {
				log.warn("Request to parse unsupported JWT : {} failed : {}", tokenHeader, exception.getMessage());

			} catch (MalformedJwtException exception) {
				log.warn("Request to parse invalid JWT : {} failed : {}", tokenHeader, exception.getMessage());

			} catch (IllegalArgumentException exception) {
				log.warn("Request to parse empty or null JWT : {} failed : {}", tokenHeader, exception.getMessage());

			}

		}
		return null;

	}

	private boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	private boolean isNotEmpty(final CharSequence cs) {
		return !isEmpty(cs);
	}

} ///
