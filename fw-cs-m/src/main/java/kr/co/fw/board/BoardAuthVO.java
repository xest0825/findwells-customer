package kr.co.fw.board;


import kr.co.fw.base.BaseVO;

public class BoardAuthVO extends BaseVO{
		
	private String BD_NO;			/* 게시판번호			NUMBER */
	private String AUTH_GRP_CD;		/* 권한그룹코드			VARCHAR2(20) */
	private String AUTH_GRP_NM;		/* 메뉴권한 코드명 		VARCHAR2(30) */
	private String AUTH_GRP_DESC;	/* 메뉴권한 코드설명    		VARCHAR2(100) */
	private String BD_AUTH_GRP_CD;	/* 게시판 권한 코드		VARCHAR2(5) */
	private String DATA_DCD;		/* 데이터 구분 코드		VARCHAR2(1) */
	
	private String AUTH_WRITE;
	private String AUTH_UPDATE;
    private String AUTH_READ;
    private String AUTH_DELETE;
    
    
	public String getAUTH_WRITE() {
		return AUTH_WRITE;
	}
	public void setAUTH_WRITE(String aUTH_WRITE) {
		AUTH_WRITE = aUTH_WRITE;
	}
	public String getAUTH_UPDATE() {
		return AUTH_UPDATE;
	}
	public void setAUTH_UPDATE(String aUTH_UPDATE) {
		AUTH_UPDATE = aUTH_UPDATE;
	}
	public String getAUTH_READ() {
		return AUTH_READ;
	}
	public void setAUTH_READ(String aUTH_READ) {
		AUTH_READ = aUTH_READ;
	}
	public String getAUTH_DELETE() {
		return AUTH_DELETE;
	}
	public void setAUTH_DELETE(String aUTH_DELETE) {
		AUTH_DELETE = aUTH_DELETE;
	}
	public String getBD_NO() {
		return BD_NO;
	}
	public void setBD_NO(String bULBD_NO) {
		BD_NO = bULBD_NO;
	}
	public String getAUTH_GRP_CD() {
		return AUTH_GRP_CD;
	}
	public void setAUTH_GRP_CD(String aUTR_GRP_CD) {
		AUTH_GRP_CD = aUTR_GRP_CD;
	}
	public String getAUTH_GRP_NM() {
		return AUTH_GRP_NM;
	}
	public void setAUTH_GRP_NM(String aUTR_GRP_NM) {
		AUTH_GRP_NM = aUTR_GRP_NM;
	}
	public String getAUTH_GRP_DESC() {
		return AUTH_GRP_DESC;
	}
	public void setAUTH_GRP_DESC(String aUTR_GRP_DESC) {
		AUTH_GRP_DESC = aUTR_GRP_DESC;
	}
	public String getBD_AUTH_GRP_CD() {
		return BD_AUTH_GRP_CD;
	}
	public void setBD_AUTH_GRP_CD(String bULBD_AUTR_CD) {
		BD_AUTH_GRP_CD = bULBD_AUTR_CD;
	}
	public String getDATA_DCD() {
		return DATA_DCD;
	}
	public void setDATA_DCD(String dATA_DCD) {
		DATA_DCD = dATA_DCD;
	}
	
	


}
