package kr.co.fw.system.orgReadRole;

import kr.co.fw.base.BaseVO;
import java.io.Serializable;
/*
 * Copyright GENEXON (c) 2014.
 */


/**
 * 조직 조회 권한 
 */
public class OrgReadRoleVO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = -6463171709930224806L;
    
    private String EMP_CD = ""; // 사원코드
    private String EMP_NM = ""; // 사원명
    private String RE_EMP_CD = ""; // 소개자 사번
    private String RE_EMP_NM = ""; // 소개자 이름
    private String MG_EMP_CD = ""; // 관리자 사번
    private String MG_EMP_NM = ""; // 관리자 이름
    private String PERNO = ""; // 주민번호
    private String SCD = ""; // 조직코드
    private String ENTYMD = ""; // 입사일
    private String PAYGBN = ""; // 급여구분(근로자/사업자) 
    private String JIKGUB = ""; // 직급
    private String JIKCHK = ""; // 직책
    private String FILENAME = ""; // 파일명
    private String EMPSTA = ""; // 재직구분
    private String ENDYMD = ""; // 퇴사일
    private String BANK = ""; // 은행
    private String BKID = ""; // 계좌번호
    private String OWNER = ""; // 예금주
    private String ZIPCD = ""; // 우편번호
    private String ADDR1 = ""; 
    private String ADDR2 = "";
    private String TELNO = "";
    private String HPNO = "";
    private String EMAIL = "";
    private String GENTYMD = "";
    private String RENTYMD = "";
    private String OUTYMD = "";
    private String BIRTHYMD = "";
    private String LUNARYN = "";
    private String WEDYMD = "";
    private String MHEIGHT = "";
    private String MWEIGHT = "";
    private String RELIGION = "";
    private String BLTYPE = "";
    private String EMPNME = "";
    private String WEDYN = "";
    private String JOINGUBUN = "";
    private String HOBBY = "";
    private String ROLE_CD = "";
    private String CND_EMPCD = "";
    private String RSIGHT = "";
    private String LSIGHT = "";
    private String SUDANG_JIKGUB = "";
    private String SELF_INTRODUCTION = "";
    private String CHKPERNO = "";

    private String SNM = "";
    private String PSCD = "";
    private String ORG_STRT_DATE = "";
    private String ORG_END_DATE = "";
    private String TEL_NO = "";
    private String ORG_ZIPCD = "";
    private String ORG_ADDR1 = "";
    private String USE_YN = "";
    private String BIZ_YN = "";
    private String RMK = "";
    private String ORG_UNIT_GBN = ""; // 조직단위구분
    private String LV  = ""; // 레벨	 	
	private String ISLEAF  =""; // 자식이 있으면 0 없으면 1
	
    private String VIEW_YN  =""; 
    private String DELETE_YN = "";
    
    private String USER_ID = "";
    private String ROLE_ID = "";
    private String ROLE_NAME = "";
    
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

	public String getRE_EMP_CD() {
		return RE_EMP_CD;
	}

	public void setRE_EMP_CD(String rE_EMP_CD) {
		RE_EMP_CD = rE_EMP_CD;
	}

	public String getRE_EMP_NM() {
		return RE_EMP_NM;
	}

	public void setRE_EMP_NM(String rE_EMP_NM) {
		RE_EMP_NM = rE_EMP_NM;
	}

	public String getPERNO() {
		return PERNO;
	}

	public void setPERNO(String pERNO) {
		PERNO = pERNO;
	}

	public String getSCD() {
		return SCD;
	}

	public void setSCD(String sCD) {
		SCD = sCD;
	}

	public String getENTYMD() {
		return ENTYMD;
	}

	public void setENTYMD(String eNTYMD) {
		ENTYMD = eNTYMD;
	}

	public String getPAYGBN() {
		return PAYGBN;
	}

	public void setPAYGBN(String pAYGBN) {
		PAYGBN = pAYGBN;
	}

	public String getJIKGUB() {
		return JIKGUB;
	}

	public void setJIKGUB(String jIKGUB) {
		JIKGUB = jIKGUB;
	}

	public String getJIKCHK() {
		return JIKCHK;
	}

	public void setJIKCHK(String jIKCHK) {
		JIKCHK = jIKCHK;
	}

	public String getFILENAME() {
		return FILENAME;
	}

	public void setFILENAME(String fILENAME) {
		FILENAME = fILENAME;
	}

	public String getEMPSTA() {
		return EMPSTA;
	}

	public void setEMPSTA(String eMPSTA) {
		EMPSTA = eMPSTA;
	}

	public String getENDYMD() {
		return ENDYMD;
	}

	public void setENDYMD(String eNDYMD) {
		ENDYMD = eNDYMD;
	}

	public String getBANK() {
		return BANK;
	}

	public void setBANK(String bANK) {
		BANK = bANK;
	}

	public String getBKID() {
		return BKID;
	}

	public void setBKID(String bKID) {
		BKID = bKID;
	}

	public String getOWNER() {
		return OWNER;
	}

	public void setOWNER(String oWNER) {
		OWNER = oWNER;
	}

	public String getZIPCD() {
		return ZIPCD;
	}

	public void setZIPCD(String zIPCD) {
		ZIPCD = zIPCD;
	}

	public String getADDR1() {
		return ADDR1;
	}

	public void setADDR1(String aDDR1) {
		ADDR1 = aDDR1;
	}

	public String getADDR2() {
		return ADDR2;
	}

	public void setADDR2(String aDDR2) {
		ADDR2 = aDDR2;
	}

	public String getTELNO() {
		return TELNO;
	}

	public void setTELNO(String tELNO) {
		TELNO = tELNO;
	}

	public String getHPNO() {
		return HPNO;
	}

	public void setHPNO(String hPNO) {
		HPNO = hPNO;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getGENTYMD() {
		return GENTYMD;
	}

	public void setGENTYMD(String gENTYMD) {
		GENTYMD = gENTYMD;
	}

	public String getRENTYMD() {
		return RENTYMD;
	}

	public void setRENTYMD(String rENTYMD) {
		RENTYMD = rENTYMD;
	}

	public String getOUTYMD() {
		return OUTYMD;
	}

	public void setOUTYMD(String oUTYMD) {
		OUTYMD = oUTYMD;
	}

	public String getBIRTHYMD() {
		return BIRTHYMD;
	}

	public void setBIRTHYMD(String bIRTHYMD) {
		BIRTHYMD = bIRTHYMD;
	}

	public String getLUNARYN() {
		return LUNARYN;
	}

	public void setLUNARYN(String lUNARYN) {
		LUNARYN = lUNARYN;
	}

	public String getWEDYMD() {
		return WEDYMD;
	}

	public void setWEDYMD(String wEDYMD) {
		WEDYMD = wEDYMD;
	}

	public String getMHEIGHT() {
		return MHEIGHT;
	}

	public void setMHEIGHT(String mHEIGHT) {
		MHEIGHT = mHEIGHT;
	}

	public String getMWEIGHT() {
		return MWEIGHT;
	}

	public void setMWEIGHT(String mWEIGHT) {
		MWEIGHT = mWEIGHT;
	}

	public String getRELIGION() {
		return RELIGION;
	}

	public void setRELIGION(String rELIGION) {
		RELIGION = rELIGION;
	}

	public String getBLTYPE() {
		return BLTYPE;
	}

	public void setBLTYPE(String bLTYPE) {
		BLTYPE = bLTYPE;
	}

	public String getEMPNME() {
		return EMPNME;
	}

	public void setEMPNME(String eMPNME) {
		EMPNME = eMPNME;
	}

	public String getWEDYN() {
		return WEDYN;
	}

	public void setWEDYN(String wEDYN) {
		WEDYN = wEDYN;
	}

	public String getJOINGUBUN() {
		return JOINGUBUN;
	}

	public void setJOINGUBUN(String jOINGUBUN) {
		JOINGUBUN = jOINGUBUN;
	}

	public String getHOBBY() {
		return HOBBY;
	}

	public void setHOBBY(String hOBBY) {
		HOBBY = hOBBY;
	}

	public String getROLE_CD() {
		return ROLE_CD;
	}

	public void setROLE_CD(String rOLE_CD) {
		ROLE_CD = rOLE_CD;
	}

	public String getCND_EMPCD() {
		return CND_EMPCD;
	}

	public void setCND_EMPCD(String cND_EMPCD) {
		CND_EMPCD = cND_EMPCD;
	}

	public String getRSIGHT() {
		return RSIGHT;
	}

	public void setRSIGHT(String rSIGHT) {
		RSIGHT = rSIGHT;
	}

	public String getLSIGHT() {
		return LSIGHT;
	}

	public void setLSIGHT(String lSIGHT) {
		LSIGHT = lSIGHT;
	}

	public String getSUDANG_JIKGUB() {
		return SUDANG_JIKGUB;
	}

	public void setSUDANG_JIKGUB(String sUDANG_JIKGUB) {
		SUDANG_JIKGUB = sUDANG_JIKGUB;
	}

	public String getSELF_INTRODUCTION() {
		return SELF_INTRODUCTION;
	}

	public void setSELF_INTRODUCTION(String sELF_INTRODUCTION) {
		SELF_INTRODUCTION = sELF_INTRODUCTION;
	}

	public String getCHKPERNO() {
		return CHKPERNO;
	}

	public void setCHKPERNO(String cHKPERNO) {
		CHKPERNO = cHKPERNO;
	}

	public String getSNM() {
		return SNM;
	}

	public void setSNM(String sNM) {
		SNM = sNM;
	}

	public String getPSCD() {
		return PSCD;
	}

	public void setPSCD(String pSCD) {
		PSCD = pSCD;
	}

	public String getORG_STRT_DATE() {
		return ORG_STRT_DATE;
	}

	public void setORG_STRT_DATE(String oRG_STRT_DATE) {
		ORG_STRT_DATE = oRG_STRT_DATE;
	}

	public String getORG_END_DATE() {
		return ORG_END_DATE;
	}

	public void setORG_END_DATE(String oRG_END_DATE) {
		ORG_END_DATE = oRG_END_DATE;
	}

	public String getTEL_NO() {
		return TEL_NO;
	}

	public void setTEL_NO(String tEL_NO) {
		TEL_NO = tEL_NO;
	}

	public String getORG_ZIPCD() {
		return ORG_ZIPCD;
	}

	public void setORG_ZIPCD(String oRG_ZIPCD) {
		ORG_ZIPCD = oRG_ZIPCD;
	}

	public String getORG_ADDR1() {
		return ORG_ADDR1;
	}

	public void setORG_ADDR1(String oRG_ADDR1) {
		ORG_ADDR1 = oRG_ADDR1;
	}

	public String getUSE_YN() {
		return USE_YN;
	}

	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}

	public String getBIZ_YN() {
		return BIZ_YN;
	}

	public void setBIZ_YN(String bIZ_YN) {
		BIZ_YN = bIZ_YN;
	}

	public String getRMK() {
		return RMK;
	}

	public void setRMK(String rMK) {
		RMK = rMK;
	}

	public String getORG_UNIT_GBN() {
		return ORG_UNIT_GBN;
	}

	public void setORG_UNIT_GBN(String oRG_UNIT_GBN) {
		ORG_UNIT_GBN = oRG_UNIT_GBN;
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

	public String getVIEW_YN() {
		return VIEW_YN;
	}

	public void setVIEW_YN(String vIEW_YN) {
		VIEW_YN = vIEW_YN;
	}

	public String getDELETE_YN() {
		return DELETE_YN;
	}

	public void setDELETE_YN(String dELETE_YN) {
		DELETE_YN = dELETE_YN;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
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

	public String getMG_EMP_CD() {
		return MG_EMP_CD;
	}

	public void setMG_EMP_CD(String mG_EMP_CD) {
		MG_EMP_CD = mG_EMP_CD;
	}

	public String getMG_EMP_NM() {
		return MG_EMP_NM;
	}

	public void setMG_EMP_NM(String mG_EMP_NM) {
		MG_EMP_NM = mG_EMP_NM;
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
	
    public boolean getchecked() {
    	if("1".equals(this.VIEW_YN)) 
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
    
	@Override
	public String toString() {
		return "ScdReadRoleVO [EMPCD=" + EMP_CD 
				+ ", EMPNM=" + EMP_NM
				+ ", REEMPCD=" + RE_EMP_CD 
				+ ", REEMPNM=" + RE_EMP_NM 
				+ ", PERNO="+ PERNO 
				+ ", SCD=" + SCD 
				+ ", ENTYMD=" + ENTYMD 
				+ ", PAYGBN="+ PAYGBN 
				+ ", JIKGUB=" + JIKGUB + ", JIKCHK=" + JIKCHK
				+ ", FILENAME=" + FILENAME + ", EMPSTA=" + EMPSTA 
				+ ", ENDYMD=" + ENDYMD 
				+ ", BANK=" + BANK + ", BKID=" + BKID + ", OWNER="+ OWNER 
				+ ", ZIPCD=" + ZIPCD + ", ADDR1=" + ADDR1
				+ ", ADDR1=" + ADDR2 + ", TELNO=" + TELNO + ", HPNO=" + HPNO
				+ ", EMAIL=" + EMAIL + ", GENTYMD=" + GENTYMD 
				+ ", RENTYMD="+ RENTYMD + ", OUTYMD=" + OUTYMD 
				+ ", BIRTHYMD=" + BIRTHYMD+ ", LUNARYN=" + LUNARYN + ", WEDYMD=" + WEDYMD 
				+ ", MHEIGHT="+ MHEIGHT + ", MWEIGHT=" + MWEIGHT + ", RELIGION=" + RELIGION
				+ ", BLTYPE=" + BLTYPE + ", EMPNME=" + EMPNME + ", WEDYN=" + WEDYN 
				+ ", JOINGUBUN=" + JOINGUBUN + ", HOBBY=" + HOBBY + ", ADDR2=" + ADDR2 
				+ ", ROLECD=" + ROLE_CD + ", CND_EMPCD=" + CND_EMPCD 
				+ ", RSIGHT=" + RSIGHT + ", LSIGHT=" + LSIGHT 
				+ ", SUDANG_JIKGUB=" + SUDANG_JIKGUB
				+ ", SELF_INTRODUCTION=" + SELF_INTRODUCTION 
				+ ", CHKPERNO=" + CHKPERNO 
				+ ", SNM=" + SNM + ", PSCD=" + PSCD 
				+ ", ORG_STRT_DATE=" + ORG_STRT_DATE 
				+ ", ORG_END_DATE="+ ORG_END_DATE 
				+ ", TEL_NO=" + TEL_NO 
				+ ", ZIPCD=" + ZIPCD
				+ ", ADDR1=" + ADDR1 
				+ ", BIZ_YN=" + BIZ_YN 
				+ ", RMK=" + RMK 
				+ ", ORG_UNIT_GBN=" + ORG_UNIT_GBN 
				+ ", LV=" + LV 
				+ ", ISLEAF="+ ISLEAF 
				+ ", VIEW_YN=" + VIEW_YN 
				+ ", DELETEYN=" + DELETE_YN
				+ ", USER_ID=" + USER_ID 
				+ ", ROLE_ID=" + ROLE_ID
				+ ", ROLE_NAME=" + ROLE_NAME + "]";
	}


	
}
