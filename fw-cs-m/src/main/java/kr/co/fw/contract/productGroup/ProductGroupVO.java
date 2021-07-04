package kr.co.fw.contract.productGroup;

import java.io.Serializable;

import kr.co.fw.base.BaseVO;

/**
 * 상품군관리 (TBCN_PRODUCT_GROUP)
 */
public class ProductGroupVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 7173861351297614042L;
	
	private String SEQ          ; /* 일련번호(TBCN_PRODUCT_GROUP_SEQ)     NUMBER(22)   */
	private String PROD_KIND1   ; /* 상품구분1(GRP_CMM_CD = PROD_KIND1) VARCHAR2(30) */
	private String PROD_KIND2   ; /* 상품구분2                          VARCHAR2(30) */
	
	private String SRCH_PROD_WORD;
	private String SRCH_USE_YN;
	
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getPROD_KIND1() {
		return PROD_KIND1;
	}
	public void setPROD_KIND1(String pROD_KIND1) {
		PROD_KIND1 = pROD_KIND1;
	}
	public String getPROD_KIND2() {
		return PROD_KIND2;
	}
	public void setPROD_KIND2(String pROD_KIND2) {
		PROD_KIND2 = pROD_KIND2;
	}
	public String getSRCH_PROD_WORD() {
		return SRCH_PROD_WORD;
	}
	public void setSRCH_PROD_WORD(String sRCH_PROD_WORD) {
		SRCH_PROD_WORD = sRCH_PROD_WORD;
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
