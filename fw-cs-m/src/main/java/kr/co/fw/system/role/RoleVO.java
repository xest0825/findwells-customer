package kr.co.fw.system.role;

import java.io.Serializable;

import kr.co.fw.base.BaseVO;
/*
 * Copyright GENEXON (c) 2013.
 */


/**
 * 권한 자원 VO
 *
 */
public class RoleVO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = -7719742254847516121L;
	
    private String ROLE_ID = ""; // 롤코드
    private String ROLE_NAME = ""; // 롤명
    private String PRNT_ROLE_ID = ""; // 부모롤아이디
    private String CHLD_ROLE_ID = ""; // 자식롤아이디
    private String PARENT_ROLE_NAME = ""; // 부모롤명
    private String CHILD_ROLE_NAME = ""; // 자식롤명
    private String RESOURCE_ID = ""; //리소스아이디
    private String RESOURCE_NAME = ""; //리소스명
	private String ISLEAF  =""; // 자식이 있으면0 없으면1
	private String LV  = "";	// 레벨		 	
	private String RESOURCE_URL = ""; // 리소스URL
	private String RESOURCE_PATTERN = ""; // 리소스패턴
    private String RESOURCE_TYPE = ""; // 리소스타입
    private String PARENT_RESOURCE_ID = ""; // 부모리소스아이디
    private String USE_YN = "";
	private String CURRENT_MENU  =""; // 현재 메뉴
    private String EMP_CD = "";
    private String SCD = ""; // 조직코드
    private String SEARCH_WORD;
    
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

	public String getPARENT_ROLE_NAME() {
		return PARENT_ROLE_NAME;
	}

	public void setPARENT_ROLE_NAME(String pARENT_ROLE_NAME) {
		PARENT_ROLE_NAME = pARENT_ROLE_NAME;
	}

	public String getCHILD_ROLE_NAME() {
		return CHILD_ROLE_NAME;
	}

	public void setCHILD_ROLE_NAME(String cHILD_ROLE_NAME) {
		CHILD_ROLE_NAME = cHILD_ROLE_NAME;
	}

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

	public String getISLEAF() {
		return ISLEAF;
	}

	public void setISLEAF(String iSLEAF) {
		ISLEAF = iSLEAF;
	}

	public String getLV() {
		return LV;
	}

	public void setLV(String lV) {
		LV = lV;
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

	public String getPARENT_RESOURCE_ID() {
		return PARENT_RESOURCE_ID;
	}

	public void setPARENT_RESOURCE_ID(String pARENT_RESOURCE_ID) {
		PARENT_RESOURCE_ID = pARENT_RESOURCE_ID;
	}

	public String getUSE_YN() {
		return USE_YN;
	}

	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}

	public String getCURRENT_MENU() {
		return CURRENT_MENU;
	}

	public void setCURRENT_MENU(String cURRENT_MENU) {
		CURRENT_MENU = cURRENT_MENU;
	}

	public String getEMP_CD() {
		return EMP_CD;
	}

	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}

	public String getSCD() {
		return SCD;
	}

	public void setSCD(String sCD) {
		SCD = sCD;
	}
	
	public String getPRNT_ROLE_ID() {
		return PRNT_ROLE_ID;
	}

	public void setPRNT_ROLE_ID(String pRNT_ROLE_ID) {
		PRNT_ROLE_ID = pRNT_ROLE_ID;
	}

	public String getCHLD_ROLE_ID() {
		return CHLD_ROLE_ID;
	}

	public void setCHLD_ROLE_ID(String cHLD_ROLE_ID) {
		CHLD_ROLE_ID = cHLD_ROLE_ID;
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
     * 확장 설정
     * @param _USE_YN
     */
    public boolean getexpanded() {
    		return true;
    }
    
 	
	public String getSEARCH_WORD() {
		return SEARCH_WORD;
	}

	public void setSEARCH_WORD(String sEARCH_WORD) {
		SEARCH_WORD = sEARCH_WORD;
	}

	@Override
	public String toString() {
		return "RoleVO [ROLE_ID=" + ROLE_ID + ", ROLE_NAME=" + ROLE_NAME
				+ ", PARENT_ROLE_ID=" + PRNT_ROLE_ID + ", CHILD_ROLE_ID="
				+ CHLD_ROLE_ID + ", PARENT_ROLE_NAME=" + PARENT_ROLE_NAME
				+ ", CHILD_ROLE_NAME=" + CHILD_ROLE_NAME + ", RESOURCE_ID="
				+ RESOURCE_ID + ", RESOURCE_NAME=" + RESOURCE_NAME
				+ ", ISLEAF=" + ISLEAF + ", LV=" + LV + ", RESOURCE_URL="
				+ RESOURCE_URL + ", RESOURCE_PATTERN=" + RESOURCE_PATTERN
				+ ", RESOURCE_TYPE=" + RESOURCE_TYPE + ", PARENT_RESOURCE_ID="
				+ PARENT_RESOURCE_ID 
				+ ", USE_YN=" + USE_YN + ", CURRENT_MENU=" + CURRENT_MENU
				+ ", EMPCD=" + EMP_CD + ", SCD=" + SCD + "]";
	}


}
