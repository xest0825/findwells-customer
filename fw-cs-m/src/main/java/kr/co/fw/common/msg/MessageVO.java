package kr.co.fw.common.msg;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageVO extends BaseVO {
	
	private String msg_seq;		/* BIGINT PK AI		'메시지 일련번호' 					*/
	private String msg_typ; 	/* VARCHAR(10) 		'메시지 유형(SMS/EMAIL/PUSH/KAKAO)' */
	private String receiver; 	/* VARCHAR(100) 	'수신자'							*/
	private String sender; 		/* VARCHAR(100) 	'발신자'							*/
	private String cc; 			/* VARCHAR(1000) 	'참조' 								*/
	private String title; 		/* VARCHAR(100) 	'제목' 								*/
	private String content; 	/* TEXT 			'내용' 								*/
	private String send_sts; 	/* VARCHAR(10) 		'전송상태' 							*/
	private String ref_id;		/* VARCHAR(22) 		'참조 ID (cont_seq)' 				*/
	private String ref_typ;
	
	private int limit_cnt;

}
