package kr.co.fw.board;

import kr.co.fw.base.BaseVO;

public class BoardOpenVO extends BaseVO {
	
	private String BD_NO;
	private String SCD;
	private String SNM;
	
	public String getBD_NO() {
		return BD_NO;
	}
	public void setBD_NO(String bULBD_NO) {
		BD_NO = bULBD_NO;
	}
	public String getSCD() {
		return SCD;
	}
	public void setSCD(String sCD) {
		SCD = sCD;
	}
	public String getSNM() {
		return SNM;
	}
	public void setSNM(String sCDNM) {
		SNM = sCDNM;
	}
	
}
