package kr.co.fw.system.auth;

import kr.co.fw.base.BaseVO;
/*
 * Copyright GENEXON (c) 2013.
 */
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthVO extends BaseVO  {
	
	private String seq; 				 /* NUMBER PK 일련번호 */
	private String receiver; 		 /* VARCHAR2(20) 수신자 ID */
	private String receiver_nm; 		 /* VARCHAR2(60) 수신자 이름 */
	private String sender;			 /* VARCHAR2(20) 발신자 ID */
	private String auth_no; 			 /* VARCHAR2(10) 인증번호 */
	private String match_yn; 		 /* VARCHAR2(1) 증번호 일치여부(인증여부) */
	private String reg_dtm; 			 /* TIMESTAMP DEF SYSDATE 등록 일시 */
	private String confirm_dtm; 		 /* TIMESTAMP 인증 일시 */
	private String srch_receiver;
	
}
