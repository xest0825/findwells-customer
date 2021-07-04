package kr.co.fw.system.menu;

import kr.co.fw.base.BaseVO;
import java.io.Serializable;



/**
 * 메뉴 자원 VO
 */
public class ResourcesVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = -3419206325501178166L;

    private String LV  = ""; // 레벨
	private String ISLEAF  ="";  // 자식이 있으면 0 없으면 1  
	private String CURRENT_MENU  =""; // 현재메뉴
    private String ROLE_ID = ""; // 롤코드
    private String ROLE_NAME = ""; // 롤이름
	private String MENU_PATH= ""; // 메뉴 경로
	private String CLS_RESOURCE_NM= ""; // 마감단계명
	private String MENU_GBN_NM= ""; // 메뉴구분명
	private String RESOURCE_ID        ; /* 리소스ID           VARCHAR2(20)  */
	private String RESOURCE_NAME      ; /* 리소스명           VARCHAR2(50)  */
	private String RESOURCE_URL       ; /* 리소스URL          VARCHAR2(100) */
	private String RESOURCE_PATTERN   ; /* 리소스패턴         VARCHAR2(100) */
	private String RESOURCE_TYPE      ; /* 리소스타입         VARCHAR2(10)  */
	private String PRNT_RESOURCE_ID   ; /* 부모리소스ID       VARCHAR2(20)  */
	private String CLS_RESOURCE_ID    ; /* 마감 리소스 아이디 VARCHAR2(20)  */
	private String MENU_ICON          ; /* 메뉴 아이콘        VARCHAR2(200) */
	private String MENU_GBN_CD        ; /* 메뉴 구분코드      VARCHAR2(4)   */
	private String USE_YN             ; /* 사용여부           VARCHAR2(1)   */
	private String INSCO_CD 			; /* 원수사코드 VARCHAR2(3) */
	private String INSCO_NM 			; /* 원수사종류 VARCHAR2(20) */
	private String CI_URL 				; /* CI URL VARCHAR2(100) */
	private String HOME_URL 			; /* 홈페이지 URL VARCHAR2(100) */
	private String PRTN_START_YMD 		; /* 제휴시작일   VARCHAR2(10)   */
	private String PRTN_END_YMD 		; /* 제휴종료일   VARCHAR2(10)   */
	
    public String getRESOURCE_ID() {
		return RESOURCE_ID;
	}

	public void setRESOURCE_ID(String rESOURCE_ID) {
		RESOURCE_ID = rESOURCE_ID;
	}

	public String getRESOURCE_NAME() {
		return RESOURCE_NAME;
	}

	public void setRESOURCE_NAME(String rESOURCE_NAME) {
		RESOURCE_NAME = rESOURCE_NAME;
	}

	public String getRESOURCE_URL() {
		return RESOURCE_URL;
	}

	public void setRESOURCE_URL(String rESOURCE_URL) {
		RESOURCE_URL = rESOURCE_URL;
	}

	public String getRESOURCE_PATTERN() {
		return RESOURCE_PATTERN;
	}

	public void setRESOURCE_PATTERN(String rESOURCE_PATTERN) {
		RESOURCE_PATTERN = rESOURCE_PATTERN;
	}

	public String getRESOURCE_TYPE() {
		return RESOURCE_TYPE;
	}

	public void setRESOURCE_TYPE(String rESOURCE_TYPE) {
		RESOURCE_TYPE = rESOURCE_TYPE;
	}

	public String getPRNT_RESOURCE_ID() {
		return PRNT_RESOURCE_ID;
	}

	public void setPRNT_RESOURCE_ID(String pRNT_RESOURCE_ID) {
		PRNT_RESOURCE_ID = pRNT_RESOURCE_ID;
	}

	public String getUSE_YN() {
		return USE_YN;
	}

	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}

	public String getLV() {
		return LV;
	}

	public void setLV(String lV) {
		LV = lV;
	}

	public String getISLEAF() {
		return ISLEAF;
	}

	public void setISLEAF(String iSLEAF) {
		ISLEAF = iSLEAF;
	}

	public String getCURRENT_MENU() {
		return CURRENT_MENU;
	}

	public void setCURRENT_MENU(String cURRENT_MENU) {
		CURRENT_MENU = cURRENT_MENU;
	}

	public String getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public String getROLE_NAME() {
		return ROLE_NAME;
	}

	public void setROLE_NAME(String rOLE_NAME) {
		ROLE_NAME = rOLE_NAME;
	}

	public String getMENU_PATH() {
		return MENU_PATH;
	}

	public void setMENU_PATH(String mENU_PATH) {
		MENU_PATH = mENU_PATH;
	}

	public String getCLS_RESOURCE_ID() {
		return CLS_RESOURCE_ID;
	}

	public void setCLS_RESOURCE_ID(String cLS_RESOURCE_ID) {
		CLS_RESOURCE_ID = cLS_RESOURCE_ID;
	}

	public String getCLS_RESOURCE_NM() {
		return CLS_RESOURCE_NM;
	}

	public void setCLS_RESOURCE_NM(String cLS_RESOURCE_NM) {
		CLS_RESOURCE_NM = cLS_RESOURCE_NM;
	}

	public String getMENU_GBN_CD() {
		return MENU_GBN_CD;
	}

	public void setMENU_GBN_CD(String mENU_GBN_CD) {
		MENU_GBN_CD = mENU_GBN_CD;
	}

	public String getMENU_GBN_NM() {
		return MENU_GBN_NM;
	}

	public void setMENU_GBN_NM(String mENU_GBN_NM) {
		MENU_GBN_NM = mENU_GBN_NM;
	}

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

	public String getCI_URL() {
		return CI_URL;
	}

	public void setCI_URL(String cI_URL) {
		CI_URL = cI_URL;
	}

	public String getHOME_URL() {
		return HOME_URL;
	}

	public void setHOME_URL(String hOME_URL) {
		HOME_URL = hOME_URL;
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

	/**
     * 사용여부-VARCHAR2
     * @param _USE_YN
     */
    public boolean getUSE_YN_OUT() {
    	if("Y".equals(this.USE_YN)) 
    		return true;
    	else
    		return false;
	}
    
	public void setUSE_YN_OUT(boolean uSE_YN_OUT) {
		
		if(uSE_YN_OUT)
			this.USE_YN = "Y";
		else
			this.USE_YN = "N";
	}

    /**
     * 자식 존제여부 반환
     * @param _USE_YN
     */
    public boolean getISLEAF_OUT() {
    	if("0".equals(this.ISLEAF)) 
    		return true;
    	else
    		return false;
	}
    
    /**
     * 확장 설정
     * @param _USE_YN
     */
    public boolean getexpanded() {
    		return true;
    }
    
	public String getMENU_ICON() {
		return MENU_ICON;
	}

	public void setMENU_ICON(String mENU_ICON) {
		MENU_ICON = mENU_ICON;
	}

	@Override
	public String toString() {
		return "ResourcesVO [LV=" + LV + ", ISLEAF=" + ISLEAF + ", CURRENT_MENU=" + CURRENT_MENU + ", ROLE_ID="
				+ ROLE_ID + ", ROLE_NAME=" + ROLE_NAME + ", MENU_PATH=" + MENU_PATH + ", CLS_RESOURCE_NM="
				+ CLS_RESOURCE_NM + ", MENU_GBN_NM=" + MENU_GBN_NM + ", RESOURCE_ID=" + RESOURCE_ID + ", RESOURCE_NAME="
				+ RESOURCE_NAME + ", RESOURCE_URL=" + RESOURCE_URL + ", RESOURCE_PATTERN=" + RESOURCE_PATTERN
				+ ", RESOURCE_TYPE=" + RESOURCE_TYPE + ", PRNT_RESOURCE_ID=" + PRNT_RESOURCE_ID + ", CLS_RESOURCE_ID="
				+ CLS_RESOURCE_ID + ", MENU_ICON=" + MENU_ICON + ", MENU_GBN_CD=" + MENU_GBN_CD + ", USE_YN=" + USE_YN
				+ "]";
	}
	
}
