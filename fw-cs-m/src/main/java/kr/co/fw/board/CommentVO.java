package kr.co.fw.board;

import kr.co.fw.base.BaseVO;

public class CommentVO extends BaseVO {
	
	/**
	 * CommentVO 덧글
	 */
	
	private String BD_NO;		// 게시판번호
	private String ITEM_NO;     // 게시글번호
	private String COMMENT_NO;  // 덧글번호
	private String CONT;        // 내용
	private String COMMENTOR;   // 입력자이름
	private String DATA_DCD;    // 데이터구분코드
	
	public String getBD_NO() {
		return BD_NO;
	}
	public void setBD_NO(String bD_NO) {
		BD_NO = bD_NO;
	}
	public String getITEM_NO() {
		return ITEM_NO;
	}
	public void setITEM_NO(String iTEM_NO) {
		ITEM_NO = iTEM_NO;
	}
	public String getCOMMENT_NO() {
		return COMMENT_NO;
	}
	public void setCOMMENT_NO(String cOMMENT_NO) {
		COMMENT_NO = cOMMENT_NO;
	}
	public String getCONT() {
		return CONT;
	}
	public void setCONT(String cONT) {
		if(cONT != null) {			
			CONT = cONT.replaceAll("\r\n", "<br>"); // 주의 : 세팅할때와 DB에서 가져와 파싱할때 '\' 사용이 다름.
		}else {
			CONT = "";
		}
	}
	public String getDATA_DCD() {
		return DATA_DCD;
	}
	public void setDATA_DCD(String dATA_DCD) {
		DATA_DCD = dATA_DCD;
	}
	public String getCOMMENTOR() {
		return COMMENTOR;
	}
	public void setCOMMENTOR(String cOMMENTOR) {
		COMMENTOR = cOMMENTOR;
	}
	
}
