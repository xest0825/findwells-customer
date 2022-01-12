package kr.co.fw.system.user;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO extends BaseVO {
	
	private String user_id;
	private String login_id;
	private String app_login_id;
	private String user_nm;
	private String login_pw;
	private String smp_pw;
	private String mb_id;
	private String user_typ;
	private String cp_no;
	private String is_foreigner;
	private String gender;
	private String email;
	private String birth_dt;
	private String devc_id;
	
	private String srch_reg_dtm;
	private String srch_user_nm;
	private String srch_mb_id;
	private String srch_login_id;

}
