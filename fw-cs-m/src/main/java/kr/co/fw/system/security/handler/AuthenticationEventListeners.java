package kr.co.fw.system.security.handler;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationEventListeners {

	@EventListener
	public void handleAuthenticationEvent(AbstractAuthenticationEvent event) {
		log.info("handleAuthenticationEvent : " + event);
	}

	@EventListener
	public void handleBadCredentials(AuthenticationFailureBadCredentialsEvent event) {
		log.info("handleBadCredentialsEvent : " + event);
	}

	@EventListener
	public void handleAuthenticationSuccess(AuthenticationSuccessEvent event) {
		log.info("handleSuccessEvent : " + event);
	}

}
