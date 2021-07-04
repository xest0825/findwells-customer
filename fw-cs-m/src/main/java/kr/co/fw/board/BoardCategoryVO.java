package kr.co.fw.board;

import kr.co.fw.base.BaseVO;

public class BoardCategoryVO extends BaseVO{
	
	private String BD_NO;
	private String CATEGORY_NM;
	private String CATEGRORY_CD;
	private String SORT_NO;
	
	public String getBD_NO() {
		return BD_NO;
	}
	public void setBD_NO(String bULBD_NO) {
		BD_NO = bULBD_NO;
	}
	public String getCATEGORY_NM() {
		return CATEGORY_NM;
	}
	public void setCATEGORY_NM(String cATEGORY_NM) {
		CATEGORY_NM = cATEGORY_NM;
	}
	public String getCATEGRORY_CD() {
		return CATEGRORY_CD;
	}
	public void setCATEGRORY_CD(String cATEGRORY_CD) {
		CATEGRORY_CD = cATEGRORY_CD;
	}
	public String getSORT_NO() {
		return SORT_NO;
	}
	public void setSORT_NO(String sORT_NO) {
		SORT_NO = sORT_NO;
	}
}
