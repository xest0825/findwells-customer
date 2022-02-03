package kr.co.fw.customer;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerVO extends BaseVO{
	
	private String cust_id;			/* VARCHAR(32)  PK 	'고객 ID' */
	private String user_id;
	private String cust_nm;			/* VARCHAR(100) NN	'고객 명' */
	private String cust_nm_en;		/* VARCHAR(100)		'영문 고객 명'*/
	private String email;			/* VARCHAR(256) 	'이메일' */
	private String cust_cell;
	private String job;				/* VARCHAR(20)		'직업'*/
	private String ssn;
	private String birth_dt;		/* VARCHAR(8)		'생년월일'*/
	private String gndr_cd;			/* VARCHAR(1)		'성별' */
	private String foreign_yn;		/* VARCHAR(1)		'외국인 여부' */
	
	private String mo_cd;
	private String login_id;
	private String login_pw;
	private String simpl_pw;
	private String devc_id;
	private String expr_dt;
	private String accnt_sts;
	private String data_dcd;
	private String approved_yn;
	
	private String cont_seq;

}
