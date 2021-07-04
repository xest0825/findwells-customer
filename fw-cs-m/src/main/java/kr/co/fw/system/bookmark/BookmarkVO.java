package kr.co.fw.system.bookmark;

import kr.co.fw.base.BaseVO;
import java.io.Serializable;
/*
 * Copyright GENEXON (c) 2013.
 */

/**
 * 즐겨찾기 VO
 */
public class BookmarkVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -3419206325501178166L;

	/* TBCM_SECURED_RESOURCES[[ICOM][보안]보안리소스마스터(메뉴)] VO AUTO Generate */
	private String RESOURCE_NAME = ""; // 리소스명-VARCHAR2
	private String RESOURCE_URL = ""; // 리소스URL-VARCHAR2
	private String RESOURCE_PATTERN = ""; // 리소스패턴-VARCHAR2
	private String RESOURCE_TYPE = ""; // 리소스타입-VARCHAR2
	private String PRNT_RESOURCE_ID = ""; // 부모리소스ID-VARCHAR2
	private String USE_YN = ""; // 사용여부-VARCHAR2
	private String LV = ""; // 레벨
	private String ISLEAF = ""; // 자식이 있으면 0 없으면 1
	
	/* TBCM_SECURED_RESOURCES_ROLE[[ICOM][보안]리소스-롤 맵핑] VO AUTO Generate */
	private String ROLE_ID = ""; // 롤코드-VARCHAR2
	private String MENU_PATH = "";
	private String CLS_RESOURCE_ID = "";
	private String CLS_RESOURCE_NM = "";
	private String MENU_GBN_CD = ""; // 메뉴구분
	private String MENU_GBN_NM = ""; // 메뉴구분명
	private String RESOURCE_ID = ""; // 리소스ID-VARCHAR2
	private String SYSTEM_GUBUN = ""; // 시스템 구분
	private String EMP_CD = ""; // 사용자코드

	public void setRESOURCE_ID(String _RESOURCE_ID) {
		RESOURCE_ID = _RESOURCE_ID;
	}

	public String getRESOURCE_ID() {
		return RESOURCE_ID;
	}

	public void setRESOURCE_NAME(String _RESOURCE_NAME) {
		RESOURCE_NAME = _RESOURCE_NAME;
	}

	public String getRESOURCE_NAME() {
		return RESOURCE_NAME;
	}

	public void setRESOURCE_URL(String _RESOURCE_URL) {
		RESOURCE_URL = _RESOURCE_URL;
	}

	public String getRESOURCE_URL() {
		return RESOURCE_URL;
	}

	public void setRESOURCE_PATTERN(String _RESOURCE_PATTERN) {
		RESOURCE_PATTERN = _RESOURCE_PATTERN;
	}

	public String getRESOURCE_PATTERN() {
		return RESOURCE_PATTERN;
	}

	public void setRESOURCE_TYPE(String _RESOURCE_TYPE) {
		RESOURCE_TYPE = _RESOURCE_TYPE;
	}

	public String getRESOURCE_TYPE() {
		return RESOURCE_TYPE;
	}



	public void setUSE_YN(String _USE_YN) {
		USE_YN = _USE_YN;
	}

	public String getUSE_YN() {
		return USE_YN;
	}

	public boolean getUSE_YN_OUT() {
		if ("Y".equals(this.USE_YN))
			return true;
		else
			return false;
	}

	public void setUSE_YN_OUT(boolean uSE_YN_OUT) {

		if (uSE_YN_OUT)
			this.USE_YN = "Y";
		else
			this.USE_YN = "N";
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

	public boolean getISLEAF_OUT() {
		if ("0".equals(this.ISLEAF))
			return true;
		else
			return false;
	}

	public boolean getexpanded() {
		return true;
	}

	private String CURRENT_MENU = ""; // 현재 메뉴

	public String getCURRENT_MENU() {
		return CURRENT_MENU;
	}

	public void setCURRENT_MENU(String cURRENT_MENU) {
		CURRENT_MENU = cURRENT_MENU;
	}

	public void setROLE_ID(String _ROLE_ID) {
		ROLE_ID = _ROLE_ID;
	}

	public String getROLE_ID() {
		return ROLE_ID;
	}

	/* TBCM_ROLES_MST[[ICOM][보안]롤마스터] VO AUTO Generate */
	private String ROLE_NAME = ""; // 롤명-VARCHAR2

	public void setROLE_NAME(String _ROLE_NAME) {
		ROLE_NAME = _ROLE_NAME;
	}

	public String getROLE_NAME() {
		return ROLE_NAME;
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

	public String getSYSTEM_GUBUN() {
		return SYSTEM_GUBUN;
	}

	public void setSYSTEM_GUBUN(String sYSTEM_GUBUN) {
		SYSTEM_GUBUN = sYSTEM_GUBUN;
	}

	public String getEMP_CD() {
		return EMP_CD;
	}

	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}
	
	public String getPRNT_RESOURCE_ID() {
		return PRNT_RESOURCE_ID;
	}

	public void setPRNT_RESOURCE_ID(String pRNT_RESOURCE_ID) {
		PRNT_RESOURCE_ID = pRNT_RESOURCE_ID;
	}

	@Override
	public String toString() {
		return "BookmarkVO [RESOURCE_NAME=" + RESOURCE_NAME + ", RESOURCE_URL=" + RESOURCE_URL 
				+ ", RESOURCE_PATTERN="	+ RESOURCE_PATTERN + ", RESOURCE_TYPE=" + RESOURCE_TYPE 
				+ ", PRNT_RESOURCE_ID=" + PRNT_RESOURCE_ID
				+ ", SORT_NO=" + this.getSort_no()  
				+ ", USE_YN=" + USE_YN + ", LV=" + LV + ", ISLEAF=" + ISLEAF + ", ROLE_ID="
				+ ROLE_ID + ", MENU_PATH=" + MENU_PATH + ", CLS_RESOURCE_ID=" + CLS_RESOURCE_ID + ", CLS_RESOURCE_NM="
				+ CLS_RESOURCE_NM + ", MENU_GBN_CD=" + MENU_GBN_CD + ", MENU_GBN_NM=" + MENU_GBN_NM + ", RESOURCE_ID="
				+ RESOURCE_ID + ", SYSTEM_GUBUN=" + SYSTEM_GUBUN + ", EMP_CD=" + EMP_CD + ", CURRENT_MENU="
				+ CURRENT_MENU + ", ROLE_NAME=" + ROLE_NAME + "]";
	}

	
}
