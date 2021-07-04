package kr.co.fw.consultant;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ConsultantVO extends BaseVO{
	
	private String fc_id; /* VARCHAR(32) PK 'FC ID' */
	private String fc_login_id; /* VARCHAR(100) '로그인 ID' */
	private String fc_nm; /* VARCHAR(100) 'FC 명' */
	private String fc_reg_no; /* VARCHAR(100) '설계사 등록 번호(생손보협회)' */
	private String contact_no; /* VARCHAR(256) '연락처' */
	private String org_id; /* VARCHAR(10) '조직 ID' */
	private String org_nm; /* VARCHAR(10) '조직 명' */
	private String org_id_path; /* VARCHAR(1000) '조직 ID 경로 (구분자 > )' */
	private String org_nm_path; /* VARCHAR(1000) '조직 명 경로 (구분자 > )' */
	
	private String insco_cd; 		/* VARCHAR(3) 	NN	'보험사 코드' */
	private String extr_auth_typ; 	/* VARCHAR(10)		'추가인증 유형' */
	
	private String cust_id;

}
