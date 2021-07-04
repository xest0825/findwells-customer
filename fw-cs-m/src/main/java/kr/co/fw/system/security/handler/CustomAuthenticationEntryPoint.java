package kr.co.fw.system.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.fw.system.exception.ApiErrorInfo;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.setContentType("application/json; charset=UTF-8");

		ApiErrorInfo apiErrorInfo = new ApiErrorInfo();
		if (InsufficientAuthenticationException.class == authException.getClass()) {
			apiErrorInfo.setMessage("Not Logined");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());

		} else {
			apiErrorInfo.setMessage("Bad Request");

		}

		String jsonString = objectMapper.writeValueAsString(apiErrorInfo);
		response.getWriter().write(jsonString);
	}

}
