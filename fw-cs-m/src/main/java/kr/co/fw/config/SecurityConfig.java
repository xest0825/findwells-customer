package kr.co.fw.config;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import kr.co.fw.system.filter.JwtAuthenticationFilter;
import kr.co.fw.system.filter.JwtRequestFilter;
import kr.co.fw.system.security.CustomAuthenticationProvider;
import kr.co.fw.system.security.handler.CustomAccessDeniedHandler;
import kr.co.fw.system.security.handler.CustomAuthenticationEntryPoint;

/**
 * 스프링 보안 설정
 * 
 * <pre>
 * 
 * &#64;EnableGlobalMethodSecurity(securedEnabled=true) 를 지정하면 메서드 보안을 사용할 수 있다. 
 * 보안을 걸고자 하는 클래스에 적용하여 클래스내 전체 메서드에 적용하거나 개별 메서드 위에 @Secured("ROLE_SUPER") 등과 같이 지정한다.
 * </pre>
 * 
 * @author yoonsik
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/js/**", "/img/**", "/css/**", "/lib/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 폼 로그인 기능과 베이직 인증 비활성화
		http.formLogin().disable().httpBasic().disable();

		// csrf 방지 지원 기능 비활성화
		http.csrf().disable();

		// 세션 정책 설정 (STATELESS 로 설정하면 쿠키에 세션키를 저장하지 않는다.)
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// 필터 추가
		http.addFilterAt(new JwtAuthenticationFilter(authenticationManager()),
				UsernamePasswordAuthenticationFilter.class)
				.addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

		http.authorizeRequests().requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				.antMatchers("/").permitAll()
				.antMatchers("/userInfo").permitAll()
				.antMatchers("/swagger-ui*").permitAll()
				.antMatchers("/swagger-resources*").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/swagger-ui/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/mrpm/**").permitAll()
				.antMatchers("**/*.go").permitAll()
				.antMatchers("/files/**").permitAll()
				.antMatchers("/system/**").hasRole("SUPER")
				.antMatchers("/login").permitAll()
				.antMatchers("/boards/**").access("request.method == 'GET' ? permitAll : hasRole('USER')")
				.antMatchers("/items/**").access("request.method == 'GET' ? permitAll : hasRole('USER')")
				.anyRequest().authenticated();

		// 접근 거부 처리자 등록
		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 사용자 지정 인증 엔트리 포인트 객체 지정
				.accessDeniedHandler(accessDeniedHandler());

		// cors지원기능 활성화
		// http.cors();
		/*
		 * 원하는 메서드나 클래스에 @CrossOrigin(origins={"http://localhost:8081"}) 등과 같애 기재하여 사용
		 * 
		 * @CrossOrigin 어노테이션을 사용한다는 의미는 해당 Origin을 허용하겠다는 의미이다.
		 */
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		return new CustomAuthenticationProvider();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://**");
		config.addAllowedHeader("*");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		config.setExposedHeaders(Arrays.asList("Authorization", "Content-Disposition"));

		source.registerCorsConfiguration("/**", config);
		return source;
	}

}
