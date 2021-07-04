package kr.co.fw.insa.orgMng;

import java.util.HashMap;
import java.util.List;

import kr.co.fw.base.BaseVO;

/**
 *  조직관리 (TBIN_SCD)
 */
public class OrgVO extends BaseVO {

	private String COM_YM;			// 업적월
    private List<HashMap<String,String>> COM_YM_ARR = null;
	private String SCD;				// 조직코드
	private String SNM;				// 조직명
	private String PSCD;			// 상위조직코드
	private String ORG_UNIT_GBN;	// 조직단위구분 : TBCM_COMMON_CODE = ORG_UNIT_GBN
	private String ORG_UNIT_GBN_NM;	// 조직단위구분명
	private String BIZ_YN;			// 영업조직여부 : TBCM_COMMON_CODE = ORG_MNG_GBN
	private String ORG_STRT_YMD;	// 조직생성년월일
	private String ORG_END_YMD;		// 조직폐쇄년월일
	private String SCD_HEAD;		//	조직장
	private String EMP_CD;			//	조직담당자 : e.g) 총무
	private String TELNO;			//	조직전화번호
	private String FAXNO;			//	조직팩스번호
	private String ZIPCD;			//	우편번호
	private String ADDR1;			//	주소1
	private String ADDR2;			//	주소2
	private String MEMO;			//	비고
	
	private String SNM2;			// 조직명칭2
	private String SNMPATH;			// 소속경로
	private String SNMPATH2;		// 소속경로2
	private String SCD_HEADNM;		// 조직장명
	private String SCD_HEADNM2;		// 조직장명2
	private String EMP_NM;			// 조직담당자명

	private String SCDNMPATH1;		// 소속 경로1
	private String SCDNMPATH2;		// 소속 경로2
	private String SCDNMPATH3;		// 소속 경로3
	private String SCDNMPATH4;		// 소속 경로4
	private String SCDNMPATH5;		// 소속 경로5

	private String EMPCNT;			// 해당 조직 인원 : 하위 인원 포함
	private String SCDCNT;			// 해당 조직 인원
	private String LEVEL;
	private String SCD_HEAD_SNM;	// 조직장 조직명
	private String STAFF_SNM;		// 스텝 조직명
	private String PSNM;			// 상위조직명
	private String ORG_OPEN_GBN_NM;	// 운영구분명
	private String ORG_MNG_GBN_NM;	// 영업조직여부명
	
	private String SRCH_ORG_VALUE;		// 조직코드/조직명/조직장
	private String SRCH_ORG_OPEN_GBN;	// 운영구분(사용유무) : TBCM_COMMON_CODE = ORG_OPEN_GBN
	private String SRCH_ORG_UNIT_GBN;	// 조직단위구분 : TBCM_COMMON_CODE = ORG_UNIT_GBN
	private String SRCH_ORG_SCD;		// 트리뷰 조직
	private String SRCH_SCD;			// 해당조직
	
	private String queryStr;		//조직엑셀다운로드를 할때 동적으로 컬럼을 만들기 위해
	
	
	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}
	public String getCOM_YM() {
		return COM_YM;
	}
	public void setCOM_YM(String cOM_YM) {
		COM_YM = cOM_YM;
	}
	public List<HashMap<String, String>> getCOM_YM_ARR() {
		return COM_YM_ARR;
	}
	public void setCOM_YM_ARR(List<HashMap<String, String>> cOM_YM_ARR) {
		COM_YM_ARR = cOM_YM_ARR;
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
	public void setSNM(String sNM) {
		SNM = sNM;
	}
	public String getPSCD() {
		return PSCD;
	}
	public void setPSCD(String pSCD) {
		PSCD = pSCD;
	}
	public String getORG_UNIT_GBN() {
		return ORG_UNIT_GBN;
	}
	public void setORG_UNIT_GBN(String oRG_UNIT_GBN) {
		ORG_UNIT_GBN = oRG_UNIT_GBN;
	}
	public String getBIZ_YN() {
		return BIZ_YN;
	}
	public void setBIZ_YN(String bIZ_YN) {
		BIZ_YN = bIZ_YN;
	}
	public String getORG_STRT_YMD() {
		return ORG_STRT_YMD;
	}
	public void setORG_STRT_YMD(String oRG_STRT_YMD) {
		ORG_STRT_YMD = oRG_STRT_YMD;
	}
	public String getORG_END_YMD() {
		return ORG_END_YMD;
	}
	public void setORG_END_YMD(String oRG_END_YMD) {
		ORG_END_YMD = oRG_END_YMD;
	}
	public String getSCD_HEAD() {
		return SCD_HEAD;
	}
	public void setSCD_HEAD(String sCD_HEAD) {
		SCD_HEAD = sCD_HEAD;
	}
	public String getEMP_CD() {
		return EMP_CD;
	}
	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}
	public String getTELNO() {
		return TELNO;
	}
	public void setTELNO(String tELNO) {
		TELNO = tELNO;
	}
	public String getFAXNO() {
		return FAXNO;
	}
	public void setFAXNO(String fAXNO) {
		FAXNO = fAXNO;
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
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
	public String getSNM2() {
		return SNM2;
	}
	public void setSNM2(String sNM2) {
		SNM2 = sNM2;
	}
	public String getSNMPATH() {
		return SNMPATH;
	}
	public void setSNMPATH(String sNMPATH) {
		SNMPATH = sNMPATH;
	}
	public String getSCD_HEADNM() {
		return SCD_HEADNM;
	}
	public void setSCD_HEADNM(String sCD_HEADNM) {
		SCD_HEADNM = sCD_HEADNM;
	}
	public String getEMP_NM() {
		return EMP_NM;
	}
	public void setEMP_NM(String eMP_NM) {
		EMP_NM = eMP_NM;
	}
	public String getSCDNMPATH1() {
		return SCDNMPATH1;
	}
	public void setSCDNMPATH1(String sCDNMPATH1) {
		SCDNMPATH1 = sCDNMPATH1;
	}
	public String getSCDNMPATH2() {
		return SCDNMPATH2;
	}
	public void setSCDNMPATH2(String sCDNMPATH2) {
		SCDNMPATH2 = sCDNMPATH2;
	}
	public String getSCDNMPATH3() {
		return SCDNMPATH3;
	}
	public void setSCDNMPATH3(String sCDNMPATH3) {
		SCDNMPATH3 = sCDNMPATH3;
	}
	public String getSCDNMPATH4() {
		return SCDNMPATH4;
	}
	public void setSCDNMPATH4(String sCDNMPATH4) {
		SCDNMPATH4 = sCDNMPATH4;
	}
	public String getSCDNMPATH5() {
		return SCDNMPATH5;
	}
	public void setSCDNMPATH5(String sCDNMPATH5) {
		SCDNMPATH5 = sCDNMPATH5;
	}
	public String getORG_UNIT_GBN_NM() {
		return ORG_UNIT_GBN_NM;
	}
	public void setORG_UNIT_GBN_NM(String oRG_UNIT_GBN_NM) {
		ORG_UNIT_GBN_NM = oRG_UNIT_GBN_NM;
	}
	public String getEMPCNT() {
		return EMPCNT;
	}
	public void setEMPCNT(String eMPCNT) {
		EMPCNT = eMPCNT;
	}
	public String getSCDCNT() {
		return SCDCNT;
	}
	public void setSCDCNT(String sCDCNT) {
		SCDCNT = sCDCNT;
	}
	public String getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}
	public String getSRCH_ORG_VALUE() {
		return SRCH_ORG_VALUE;
	}
	public void setSRCH_ORG_VALUE(String sRCH_ORG_VALUE) {
		SRCH_ORG_VALUE = sRCH_ORG_VALUE;
	}
	public String getSRCH_ORG_OPEN_GBN() {
		return SRCH_ORG_OPEN_GBN;
	}
	public void setSRCH_ORG_OPEN_GBN(String sRCH_ORG_OPEN_GBN) {
		SRCH_ORG_OPEN_GBN = sRCH_ORG_OPEN_GBN;
	}
	public String getSRCH_ORG_UNIT_GBN() {
		return SRCH_ORG_UNIT_GBN;
	}
	public void setSRCH_ORG_UNIT_GBN(String sRCH_ORG_UNIT_GBN) {
		SRCH_ORG_UNIT_GBN = sRCH_ORG_UNIT_GBN;
	}
	public String getSRCH_ORG_SCD() {
		return SRCH_ORG_SCD;
	}
	public void setSRCH_ORG_SCD(String sRCH_ORG_SCD) {
		SRCH_ORG_SCD = sRCH_ORG_SCD;
	}
	public String getSRCH_SCD() {
		return SRCH_SCD;
	}
	public void setSRCH_SCD(String sRCH_SCD) {
		SRCH_SCD = sRCH_SCD;
	}
	public String getSCD_HEAD_SNM() {
		return SCD_HEAD_SNM;
	}
	public void setSCD_HEAD_SNM(String sCD_HEAD_SNM) {
		SCD_HEAD_SNM = sCD_HEAD_SNM;
	}
	public String getSTAFF_SNM() {
		return STAFF_SNM;
	}
	public void setSTAFF_SNM(String sTAFF_SNM) {
		STAFF_SNM = sTAFF_SNM;
	}
	public String getPSNM() {
		return PSNM;
	}
	public void setPSNM(String pSNM) {
		PSNM = pSNM;
	}
	public String getORG_OPEN_GBN_NM() {
		return ORG_OPEN_GBN_NM;
	}
	public void setORG_OPEN_GBN_NM(String oRG_OPEN_GBN_NM) {
		ORG_OPEN_GBN_NM = oRG_OPEN_GBN_NM;
	}
	public String getORG_MNG_GBN_NM() {
		return ORG_MNG_GBN_NM;
	}
	public void setORG_MNG_GBN_NM(String oRG_MNG_GBN_NM) {
		ORG_MNG_GBN_NM = oRG_MNG_GBN_NM;
	}
	public String getSCD_HEADNM2() {
		return SCD_HEADNM2;
	}
	public void setSCD_HEADNM2(String sCD_HEADNM2) {
		SCD_HEADNM2 = sCD_HEADNM2;
	}
	public String getSNMPATH2() {
		return SNMPATH2;
	}
	public void setSNMPATH2(String sNMPATH2) {
		SNMPATH2 = sNMPATH2;
	}
}
