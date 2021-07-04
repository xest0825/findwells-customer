package kr.co.fw.board;

import kr.co.fw.base.BaseVO;

public class AuthorityGroupVO extends BaseVO{
	
    private String AUTH_GRP_CD; // 권한그룹 코드
    private String AUTH_GRP_NM; // 권한그룹명
    private String AUTH_GRP_DESC; // 권한그룹설명
    private String EMP_CD;
    private String EMP_NM;
    private String EMPSTA;
    private String JIKCHK;
    private String JIKGUB;
    
	public String getAUTH_GRP_CD() {
		return AUTH_GRP_CD;
	}
	public void setAUTH_GRP_CD(String aUTH_GRP_CD) {
		AUTH_GRP_CD = aUTH_GRP_CD;
	}
	public String getAUTH_GRP_NM() {
		return AUTH_GRP_NM;
	}
	public void setAUTH_GRP_NM(String aUTH_GRP_NM) {
		AUTH_GRP_NM = aUTH_GRP_NM;
	}
	public String getAUTH_GRP_DESC() {
		return AUTH_GRP_DESC;
	}
	public void setAUTH_GRP_DESC(String aUTH_GRP_DESC) {
		AUTH_GRP_DESC = aUTH_GRP_DESC;
	}
	public String getEMP_CD() {
		return EMP_CD;
	}
	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}
	public String getEMP_NM() {
		return EMP_NM;
	}
	public void setEMP_NM(String eMP_NM) {
		EMP_NM = eMP_NM;
	}
	public String getEMPSTA() {
		return EMPSTA;
	}
	public void setEMPSTA(String eMPSTA) {
		EMPSTA = eMPSTA;
	}
	public String getJIKCHK() {
		return JIKCHK;
	}
	public void setJIKCHK(String jIKCHK) {
		JIKCHK = jIKCHK;
	}
	public String getJIKGUB() {
		return JIKGUB;
	}
	public void setJIKGUB(String jIKGUB) {
		JIKGUB = jIKGUB;
	}
    
}
