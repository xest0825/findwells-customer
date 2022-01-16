package kr.co.fw.common.sms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SmsVO {

	private String sms_contents;	/* 메시지 내용 */
	private String mms_subject;		/* 메시지 제목 */
	private String reg_id;			/* 등록자 */
	private String msg_type; 		/* 단문4, 장문6 */
	private String hp_no;			/* 수신자 휴대폰 번호 */
	private String cont_seq;		/* 일련번호 */
	private String call_to;			/* 발신자 */
	private String receiver_nm;

}
