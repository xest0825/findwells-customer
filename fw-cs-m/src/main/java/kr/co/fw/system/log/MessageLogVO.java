package kr.co.fw.system.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageLogVO {
	
	private String msg_seq;		/* BIGINT PK AI		'메시지 일련번호' 					*/
	private String msg_typ; 	/* VARCHAR(10) 		'메시지 유형(SMS/EMAIL/PUSH/KAKAO)' */
	private String reciever; 	/* VARCHAR(100) 	'수신자'							*/
	private String sender; 		/* VARCHAR(100) 	'발신자'							*/
	private String cc; 			/* VARCHAR(1000) 	'참조' 								*/
	private String title; 		/* VARCHAR(100) 	'제목' 								*/
	private String content; 	/* TEXT 			'내용' 								*/
	private String send_sts; 	/* VARCHAR(10) 		'전송상태' 							*/
	private String ref_id;		/* VARCHAR(22) 		'참조 ID (cont_seq)' 				*/
	private String reg_id;
	private String mod_id;

}
