package kr.co.fw.system.log;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApiLogVO {
	
	private String api_seq;
	private String api_ctg; 		/* VARCHAR(10)  'API 뷴류' 		*/
	private String api_url; 		/* VARCHAR(100) 'API URL'		*/
	private String receiver;		/* VARCHAR(100) '수신자'		*/
	private String sender;			/* VARCHAR(100) '발신자'		*/
	private String req_data; 		/* TEXT 		'요청 데이터'	*/
	private String res_data;		/* TEXT			'결과 데이터'	*/
	private String res_cd;			/* VARCHAR(10)	'결과 코드'		*/
	private String req_dtm; 		/* DATETIME		'요청 일시' 	*/
	private String res_dtm;			/* DATETIME 	'결과수신 일시'	*/

}
