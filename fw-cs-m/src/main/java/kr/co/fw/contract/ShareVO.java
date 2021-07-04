package kr.co.fw.contract;

import java.io.Serializable;

import kr.co.fw.base.BaseVO;

/**
 * 쉐어관리 (TBCN_CONTRACT_SHARE)
 */
public class ShareVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1692301849874376828L;
	
	private String SEQ          ; /* 일련번호(TBCN_CONTRACT_SHARE_SEQ)   NUMBER(22)    */
	private String SHARE_CD     ; /* 쉐어구분코드(GRP_CMM_CD = SHARE_CD) VARCHAR2(1)   */
	private String INSPOL_NO    ; /* 증권번호                            VARCHAR2(40)  */
	private String INSCO_CD     ; /* 원수사코드                          VARCHAR2(3)   */
	private String SCD          ; /* 조직코드                            VARCHAR2(10)  */
	private String EMP_CD       ; /* 사원번호                            VARCHAR2(20)  */
	private String RET_RATIO    ; /* 성적(유지율)쉐어비율                NUMBER(22)    */
	private String FEES_RATIO   ; /* 수수료쉐어비율                      NUMBER(22)    */
	private String REF_SEQ      ; /* 계약 일련번호                       NUMBER(22)    */
	private String BIGO         ; /* 비고                                VARCHAR2(100) */

	private String EMP_NM;	/* 사원명 */
	private String JIKCHK;	/* 직책 */
	private String HPNO;	/* 휴대전화 */
	private String SNM;		/* 조직명 */
	private String SNMPATH;	/* 소속경로 */

	public String getSEQ() {
		return SEQ;
	}

	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}

	public String getSHARE_CD() {
		return SHARE_CD;
	}

	public void setSHARE_CD(String sHARE_CD) {
		SHARE_CD = sHARE_CD;
	}

	public String getINSPOL_NO() {
		return INSPOL_NO;
	}

	public void setINSPOL_NO(String iNSPOL_NO) {
		INSPOL_NO = iNSPOL_NO;
	}

	public String getINSCO_CD() {
		return INSCO_CD;
	}

	public void setINSCO_CD(String iNSCO_CD) {
		INSCO_CD = iNSCO_CD;
	}

	public String getSCD() {
		return SCD;
	}

	public void setSCD(String sCD) {
		SCD = sCD;
	}

	public String getEMP_CD() {
		return EMP_CD;
	}

	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}

	public String getRET_RATIO() {
		return RET_RATIO;
	}

	public void setRET_RATIO(String rET_RATIO) {
		RET_RATIO = rET_RATIO;
	}

	public String getFEES_RATIO() {
		return FEES_RATIO;
	}

	public void setFEES_RATIO(String fEES_RATIO) {
		FEES_RATIO = fEES_RATIO;
	}

	public String getREF_SEQ() {
		return REF_SEQ;
	}

	public void setREF_SEQ(String rEF_SEQ) {
		REF_SEQ = rEF_SEQ;
	}

	public String getBIGO() {
		return BIGO;
	}

	public void setBIGO(String bIGO) {
		BIGO = bIGO;
	}

	public String getEMP_NM() {
		return EMP_NM;
	}

	public void setEMP_NM(String eMP_NM) {
		EMP_NM = eMP_NM;
	}

	public String getSNM() {
		return SNM;
	}

	public void setSNM(String sNM) {
		SNM = sNM;
	}

	public String getJIKCHK() {
		return JIKCHK;
	}

	public void setJIKCHK(String jIKCHK) {
		JIKCHK = jIKCHK;
	}

	public String getHPNO() {
		return HPNO;
	}

	public void setHPNO(String hPNO) {
		HPNO = hPNO;
	}

	public String getSNMPATH() {
		return SNMPATH;
	}

	public void setSNMPATH(String sNMPATH) {
		SNMPATH = sNMPATH;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
