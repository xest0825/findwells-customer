package kr.co.fw.customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerVO {
	
	private String cust_id;			/* VARCHAR(32)  PK 	'고객 ID' */
	private String cust_nm;			/* VARCHAR(100) NN	'고객 명' */
	private String cust_nm_en;		/* VARCHAR(100)		'영문 고객 명'*/
	private String email;			/* VARCHAR(256) 	'이메일' */
	private String contact_no;		/* VARCHAR(256) 	'연락처' */
	private String job;				/* VARCHAR(20)		'직업'*/
	private String resi_reg_no;		/* VARCHAR(256)		'주민등록번호' */
	private String birth_dt;		/* VARCHAR(8)		'생년월일'*/
	private String gender;			/* VARCHAR(1)		'성별' */
	private String foreigner_yn;	/* VARCHAR(1)		'외국인 여부' */
	private String nationality;		/* VARCHAR(20)		'국적' */
	private String resi_nation;		/* VARCHAR(20)		'거주국' */
	private String driver_typ;		/* VARCHAR(20)		'운전차종' */
	
	private String fc_id;			/* VARCHAR(32)		'설계사 ID' */

}
