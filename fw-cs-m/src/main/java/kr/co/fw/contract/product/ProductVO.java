package kr.co.fw.contract.product;

import java.io.Serializable;

import kr.co.fw.base.BaseVO;

/**
 * 상품관리 (TBCN_PRODUCT)
 */
public class ProductVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 4807508376259944879L;

    private String SEQ            ;  /* 일련번호(TBCN_PRODUCT_SEQ) NUMBER(22)    */
    private String INSCO_TYPE     ;  /* 생손보구분                 VARCHAR2(1)   */
    private String INSCO_CD       ;  /* 원수사코드                 VARCHAR2(3)   */
    private String PROD_NM        ;  /* 상품명                     VARCHAR2(100) */
    private String PROD_FULL_NM   ;  /* 상품설명(Full Name)        VARCHAR2(100) */
    private String PROD_STRT_YMD  ;  /* 판매시작일                 VARCHAR2(10)  */
    private String PROD_END_YMD   ;  /* 판매종료일                 VARCHAR2(10)  */
    private String GUN_SEQ        ;  /* 상품군 일련번호            NUMBER(22)    */
    private String PROD_KIND2     ;  /* 상품구분2                  VARCHAR2(20)  */
    private String BYENHWAN_RATE  ;  /* 변환율                     VARCHAR2(20)  */
    private String HWANSAN_COUNT  ;  /* 환산회차                   VARCHAR2(20)  */
	
    private String INSCO_TYPENM;	/* 생손부구분명 */
    private String INSCO_NM;		/* 원수사명 */
    
    private String SRCH_INSCO_TYPE;
    private String SRCH_INSCO_CD;
    private String SRCH_PROD_WORD;
    private String SRCH_PROD_STRT_YMD;
    private String SRCH_PROD_END_YMD;
    private String SRCH_PROD_END_YMD2;
    private String SRCH_USE_YN;
    
    private String SRCH_CONT_DATE;	/* 계약등록-> 계약일에 따른 상품조회 */
    
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getINSCO_TYPE() {
		return INSCO_TYPE;
	}
	public void setINSCO_TYPE(String iNSCO_TYPE) {
		INSCO_TYPE = iNSCO_TYPE;
	}
	public String getINSCO_CD() {
		return INSCO_CD;
	}
	public void setINSCO_CD(String iNSCO_CD) {
		INSCO_CD = iNSCO_CD;
	}
	public String getPROD_NM() {
		return PROD_NM;
	}
	public void setPROD_NM(String pROD_NM) {
		PROD_NM = pROD_NM;
	}
	public String getPROD_FULL_NM() {
		return PROD_FULL_NM;
	}
	public void setPROD_FULL_NM(String pROD_FULL_NM) {
		PROD_FULL_NM = pROD_FULL_NM;
	}
	public String getPROD_STRT_YMD() {
		return PROD_STRT_YMD;
	}
	public void setPROD_STRT_YMD(String pROD_STRT_YMD) {
		PROD_STRT_YMD = pROD_STRT_YMD;
	}
	public String getPROD_END_YMD() {
		return PROD_END_YMD;
	}
	public void setPROD_END_YMD(String pROD_END_YMD) {
		PROD_END_YMD = pROD_END_YMD;
	}
	public String getGUN_SEQ() {
		return GUN_SEQ;
	}
	public void setGUN_SEQ(String gUN_SEQ) {
		GUN_SEQ = gUN_SEQ;
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
	public String getINSCO_TYPENM() {
		return INSCO_TYPENM;
	}
	public void setINSCO_TYPENM(String iNSCO_TYPENM) {
		INSCO_TYPENM = iNSCO_TYPENM;
	}
	public String getINSCO_NM() {
		return INSCO_NM;
	}
	public void setINSCO_NM(String iNSCO_NM) {
		INSCO_NM = iNSCO_NM;
	}
	public String getSRCH_INSCO_TYPE() {
		return SRCH_INSCO_TYPE;
	}
	public void setSRCH_INSCO_TYPE(String sRCH_INSCO_TYPE) {
		SRCH_INSCO_TYPE = sRCH_INSCO_TYPE;
	}
	public String getSRCH_INSCO_CD() {
		return SRCH_INSCO_CD;
	}
	public void setSRCH_INSCO_CD(String sRCH_INSCO_CD) {
		SRCH_INSCO_CD = sRCH_INSCO_CD;
	}
	public String getSRCH_PROD_WORD() {
		return SRCH_PROD_WORD;
	}
	public void setSRCH_PROD_WORD(String sRCH_PROD_WORD) {
		SRCH_PROD_WORD = sRCH_PROD_WORD;
	}
	public String getSRCH_PROD_STRT_YMD() {
		return SRCH_PROD_STRT_YMD;
	}
	public void setSRCH_PROD_STRT_YMD(String sRCH_PROD_STRT_YMD) {
		SRCH_PROD_STRT_YMD = sRCH_PROD_STRT_YMD;
	}
	public String getSRCH_PROD_END_YMD() {
		return SRCH_PROD_END_YMD;
	}
	public void setSRCH_PROD_END_YMD(String sRCH_PROD_END_YMD) {
		SRCH_PROD_END_YMD = sRCH_PROD_END_YMD;
	}
	public String getSRCH_PROD_END_YMD2() {
		return SRCH_PROD_END_YMD2;
	}
	public void setSRCH_PROD_END_YMD2(String sRCH_PROD_END_YMD2) {
		SRCH_PROD_END_YMD2 = sRCH_PROD_END_YMD2;
	}
	public String getSRCH_USE_YN() {
		return SRCH_USE_YN;
	}
	public void setSRCH_USE_YN(String sRCH_USE_YN) {
		SRCH_USE_YN = sRCH_USE_YN;
	}
	public String getSRCH_CONT_DATE() {
		return SRCH_CONT_DATE;
	}
	public void setSRCH_CONT_DATE(String sRCH_CONT_DATE) {
		SRCH_CONT_DATE = sRCH_CONT_DATE;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
