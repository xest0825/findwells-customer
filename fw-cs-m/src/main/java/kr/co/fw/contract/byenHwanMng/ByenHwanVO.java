package kr.co.fw.contract.byenHwanMng;

import java.io.Serializable;

import kr.co.fw.base.BaseVO;

/**
 * 변환율관리 (TBCN_BYENHWAN_RATE)
 */
public class ByenHwanVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 267391723459675219L;

	private String SEQ             ; /* 일련번호(TBCN_BYENHWAN_RATE_SEQ) NUMBER(22)   */
    private String COM_YM          ; /* 마감년월                         VARCHAR2(20) */
    private String INSCO_CD        ; /* 원수사코드                       VARCHAR2(3)  */
    private String PROD_KIND2      ; /* 상품구분2                        VARCHAR2(30) */
    private String BYENHWAN_RATE   ; /* 변환율                           VARCHAR2(20) */
    private String HWANSAN_COUNT   ; /* 환산회차                         VARCHAR2(20) */
    
    private String INSCO_NM;		/* 원수사명 */
    
    private String SRCH_INSCO_CD;
    private String SRCH_USE_YN;
    
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getCOM_YM() {
		return COM_YM;
	}
	public void setCOM_YM(String cOM_YM) {
		COM_YM = cOM_YM;
	}
	public String getINSCO_CD() {
		return INSCO_CD;
	}
	public void setINSCO_CD(String iNSCO_CD) {
		INSCO_CD = iNSCO_CD;
	}
	public String getPROD_KIND2() {
		return PROD_KIND2;
	}
	public void setPROD_KIND2(String pROD_KIND2) {
		PROD_KIND2 = pROD_KIND2;
	}
	public String getBYENHWAN_RATE() {
		return BYENHWAN_RATE;
	}
	public void setBYENHWAN_RATE(String bYENHWAN_RATE) {
		BYENHWAN_RATE = bYENHWAN_RATE;
	}
	public String getHWANSAN_COUNT() {
		return HWANSAN_COUNT;
	}
	public void setHWANSAN_COUNT(String hWANSAN_COUNT) {
		HWANSAN_COUNT = hWANSAN_COUNT;
	}
	public String getINSCO_NM() {
		return INSCO_NM;
	}
	public void setINSCO_NM(String iNSCO_NM) {
		INSCO_NM = iNSCO_NM;
	}
	public String getSRCH_INSCO_CD() {
		return SRCH_INSCO_CD;
	}
	public void setSRCH_INSCO_CD(String sRCH_INSCO_CD) {
		SRCH_INSCO_CD = sRCH_INSCO_CD;
	}
	public String getSRCH_USE_YN() {
		return SRCH_USE_YN;
	}
	public void setSRCH_USE_YN(String sRCH_USE_YN) {
		SRCH_USE_YN = sRCH_USE_YN;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
