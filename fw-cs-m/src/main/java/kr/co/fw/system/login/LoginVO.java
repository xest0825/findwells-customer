package kr.co.fw.system.login;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginVO {
	
	private String username;
	private String password;
	private String mb_id;
	
	private String login_id;
	private String login_pw;
	private String simpl_pw;
	private String devc_id;
	private String expr_dt;
	private String accnt_sts;
	private String data_dcd;
	
}
