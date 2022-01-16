package kr.co.fw.system.security.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	
	private String username;
	private String password;
	
	private String user_id;
	private String user_nm;
	
	private String login_id;
	private String login_pw;
	private String devc_id;
	private String expr_dt;
	private String accnt_sts;
	
	private String mb_id;
	
	private int enabled;
	
	private List<String> authorities;
	
	private String search_word;
	private boolean pagination;
	private String srch_login_id;
	
}
