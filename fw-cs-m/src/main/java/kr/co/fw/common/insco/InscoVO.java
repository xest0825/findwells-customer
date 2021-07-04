package kr.co.fw.common.insco;


import kr.co.fw.base.BaseVO;


/**
 * 원수사 VO [TBCM_INSCO]
 */
public class InscoVO extends BaseVO {

	private String INSCO_CD 			; /* 원수사코드 VARCHAR2(3) */
	private String INSCO_NM 			; /* 원수사종류 VARCHAR2(20) */
	private String INSCO_TYPE			; /* 보험타입VARCHAR2(1) */
	private String INSCO_TYPE_NM 		; /* 보험타입문자열 */
	private String CI_URL 				; /* CI URL VARCHAR2(100) */
	private String PRENO 				; /* 대표연락처 VARCHAR2(20) */
	private String FAXNO 				; /* FAX번호 VARCHAR2(20) */
	private String HELPNO 				; /* 헬프데스크 VARCHAR2(20) */
	private String ITNO 				; /* IT데스크 VARCHAR2(20) */
	private String PLAN_URL 			; /* 가입설계 URL VARCHAR2(100) */
	private String HOME_URL 			; /* 홈페이지 URL VARCHAR2(100) */
	private String MEMO 				; /* 메모 VARCHAR2(100) */
	private String PRTN_START_YMD 		; /* 제휴시작일   VARCHAR2(10)   */
	private String PRTN_END_YMD 		; /* 제휴종료일   VARCHAR2(10)   */
	
	public String getINSCO_CD() {
		return INSCO_CD;
	}
	public void setINSCO_CD(String iNSCO_CD) {
		INSCO_CD = iNSCO_CD;
	}
	public String getINSCO_NM() {
		return INSCO_NM;
	}
	public void setINSCO_NM(String iNSCO_NM) {
		INSCO_NM = iNSCO_NM;
	}
	public String getINSCO_TYPE() {
		return INSCO_TYPE;
	}
	public void setINSCO_TYPE(String iNSCO_TYPE) {
		INSCO_TYPE = iNSCO_TYPE;
	}
	public String getINSCO_TYPE_NM() {
		return INSCO_TYPE_NM;
	}
	public void setINSCO_TYPE_NM(String iNSCO_TYPE_NM) {
		INSCO_TYPE_NM = iNSCO_TYPE_NM;
	}
	public String getCI_URL() {
		return CI_URL;
	}
	public void setCI_URL(String cI_URL) {
		CI_URL = cI_URL;
	}
	public String getPRENO() {
		return PRENO;
	}
	public void setPRENO(String pRENO) {
		PRENO = pRENO;
	}
	public String getFAXNO() {
		return FAXNO;
	}
	public void setFAXNO(String fAXNO) {
		FAXNO = fAXNO;
	}
	public String getHELPNO() {
		return HELPNO;
	}
	public void setHELPNO(String hELPNO) {
		HELPNO = hELPNO;
	}
	public String getITNO() {
		return ITNO;
	}
	public void setITNO(String iTNO) {
		ITNO = iTNO;
	}
	public String getPLAN_URL() {
		return PLAN_URL;
	}
	public void setPLAN_URL(String pLAN_URL) {
		PLAN_URL = pLAN_URL;
	}
	public String getHOME_URL() {
		return HOME_URL;
	}
	public void setHOME_URL(String hOME_URL) {
		HOME_URL = hOME_URL;
	}
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
	public String getPRTN_START_YMD() {
		return PRTN_START_YMD;
	}
	public void setPRTN_START_YMD(String pRTN_START_YMD) {
		PRTN_START_YMD = pRTN_START_YMD;
	}
	public String getPRTN_END_YMD() {
		return PRTN_END_YMD;
	}
	public void setPRTN_END_YMD(String pRTN_END_YMD) {
		PRTN_END_YMD = pRTN_END_YMD;
	}
	
}