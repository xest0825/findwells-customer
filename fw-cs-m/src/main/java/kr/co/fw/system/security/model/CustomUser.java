package kr.co.fw.system.security.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomUser extends org.springframework.security.core.userdetails.User{

	public CustomUser(User user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getLogin_id(), user.getLogin_pw(), authorities);
		this.user = user;
	}
	public CustomUser(User user) {
		super(user.getLogin_id(), user.getLogin_pw(), user.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList()));
		this.user = user;
	}

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public String getUser_id() {
		return user.getUser_id();
	}
	
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getPassword() {
		return user.getPassword();
	}
	
	public String getLogin_id() {
		return user.getLogin_id();
	}
	
	public String getLogin_pw() {
		return user.getLogin_pw();
	}
	
	public String getUser_nm() {
		return user.getUser_nm();
	}
	
	public String getMb_id() {
		return user.getMb_id();
	}
	
	public Collection<? extends GrantedAuthority> getAuthorites(){
		return user.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth)).collect(Collectors.toList());
	}
	

}
