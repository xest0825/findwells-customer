package kr.co.fw.contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kr.co.fw.base.BaseVO;
import kr.co.fw.common.file.FileVO;

/**
 * 계약관리 (TBCN_CONTRACT_FSB)
 */
public class ContractVO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 5649991744376556354L;

    private String SEQ              ; /* 일련번호(TBCN_CONTRACT_SEQ)                                                    NUMBER(22)     */
    private String INSPOL_NO        ; /* 증권번호                                                                       VARCHAR2(40)   */
    private String INSCO_CD         ; /* 원수사코드                                                                     VARCHAR2(3)    */
    private String PROD_SEQ         ; /* 상품 일련번호                                                                  NUMBER(22)     */
    private String PROD_NM          ; /* 상품명                                                                         VARCHAR2(100)  */
    private String PROD_KIND2       ; /* 상품구분2                                                                      VARCHAR2(20)   */
    private String CONT_DATE        ; /* 계약일자                                                                       VARCHAR2(10)   */
    private String CONT_STATUS      ; /* 계약상태(GRP_CMM_CD = CONT_STATUS)                                             VARCHAR2(4)    */
    private String NAPCNT           ; /* 납입회차                                                                        NUMBER    */
    private String SUGUM_STATUS     ; /* 수금상태                                                                       VARCHAR2(20)    */
    private String NAP_MONTH        ; /* 납입월                                                                         VARCHAR2(10)    */
    private String NAP_DATE         ; /* 납입일자                                                                       VARCHAR2(10)    */
    private String STATUS_DATE      ; /* 상태변경일                                                                      VARCHAR2(10)    */
    private String GIJUN_DATE       ; /* 데이터기준일                                                                     VARCHAR2(10)    */
    private String NAPMETHOD        ; /* 납입방법(GRP_CMM_CD = NAPMETHOD)                                               VARCHAR2(20)   */
    private String NAPGI            ; /* 납입기간                                                                       VARCHAR2(10)   */
    private String NAPGI_GBN        ; /* 납입기간구분(GRP_CMM_CD = NAPGI_GBN)                                           VARCHAR2(10)   */
    private String PREM_AMT         ; /* 보험료                                                                         NUMBER(22)     */
    private String MON_PREM_AMT     ; /* 월납보험료                                                                     NUMBER(22)     */
    private String DSNT_AMT         ; /* 할인보험료                                                                     NUMBER(22)     */
    private String DISCOUNT_YN      ; /* 할인여부                                                                       VARCHAR2(1)    */
    private String INSU_STRT_DATE   ; /* 보험시작일                                                                     VARCHAR2(10)   */
    private String INSU_END_DATE    ; /* 보험종료일                                                                     VARCHAR2(10)   */
    private String ACCOUNT_END_DATE	; /* 초기계좌만기일                                                                VARCHAR2(10)   */
    private String LIFE_YN          ; /* 종신보험여부                                                                   VARCHAR2(1)    */
    private String INSCO_HWAN       ; /* 원수사성적                                                                     NUMBER(22)     */
    private String HWAN_RATE        ; /* 변환율                                                                         NUMBER(22)     */
    private String HWAN             ; /* GA성적                                                                         NUMBER(22)     */
    private String MO_CD            ; /* 모집인코드                                                                     VARCHAR2(20)   */
    private String YU_CD            ; /* 유지FP코드                                                                     VARCHAR2(20)   */
    private String FAMILY_CONT      ; /* 본인/가족계약                                                                  VARCHAR2(80)   */
    private String DB_CONT          ; /* DB계약                                                                         VARCHAR2(80)   */
    private String BUNGUB_CONT      ; /* 분급대상계약                                                                   VARCHAR2(80)   */
    private String CAREFUL_CONT     ; /* 유의계약                                                                       VARCHAR2(80)   */
    private String ISSUE            ; /* 이슈사항                                                                       VARCHAR2(1000) */
    private String MEMO             ; /* 메모                                                                           VARCHAR2(4000) */
    private String GCUST_ID			; /* 계약자 ID(고객 테이블 CUST_ID 참조)  */
    private String GEAJA            ; /* 계약자                                                                         VARCHAR2(100)  */
    private String GEAJA_NM;	/* 계약자명 */
    private String GPERNO           ; /* 계약자주민번호                                                                 VARCHAR2(4000) */
    private String GCORP_YN         ; /* 계약자법인여부                                                                 VARCHAR2(1)    */
    private String GFOREIGN_YN      ; /* 계약자외국인여부                                                               VARCHAR2(1)    */
    private String GHPNO            ; /* 계약자핸드폰번호                                                               VARCHAR2(20)   */
    private String GTELNO           ; /* 계약자전화번호                                                                 VARCHAR2(20)   */
    private String GFAXNO           ; /* 계약자팩스번호                                                                 VARCHAR2(14)   */
    private String GEMAIL           ; /* 계약자이메일                                                                   VARCHAR2(50)   */
    private String GZIPCD           ; /* 계약자우편번호                                                                 VARCHAR2(7)    */
    private String GADDR1           ; /* 계약자주소                                                                     VARCHAR2(200)  */
    private String GADDR2           ; /* 계약자주소상세                                                                 VARCHAR2(200)  */
    private String SAME_YN          ; /* 계약자피보험자동일여부                                                         VARCHAR2(1)    */
    private String PCUST_ID			; /* 피보험자 ID(고객 테이블 CUST_ID 참조)  */
    private String PIABO            ; /* 피보험자                                                                       VARCHAR2(100)  */
	private String PIABO_NM;	/* 피보험자명*/
    private String PPERNO           ; /* 피보험자주민번호                                                               VARCHAR2(4000) */
    private String PCORP_YN         ; /* 피보험자법인여부                                                               VARCHAR2(1)    */
    private String PFOREIGN_YN      ; /* 피보험자외국인여부                                                             VARCHAR2(1)    */
    private String PHPNO            ; /* 피보험자핸드폰번호                                                             VARCHAR2(20)   */
    private String PTELNO           ; /* 피보험자전화번호                                                               VARCHAR2(20)   */
    private String PFAXNO           ; /* 피보험자팩스번호                                                               VARCHAR2(14)   */
    private String PEMAIL           ; /* 피보험자이메일                                                                 VARCHAR2(50)   */
    private String PZIPCD           ; /* 피보험자우편번호                                                               VARCHAR2(7)    */
    private String PADDR1           ; /* 피보험자주소                                                                   VARCHAR2(200)  */
    private String PADDR2           ; /* 피보험자주소상세                                                               VARCHAR2(200)  */
    private String INS_CONT_TYPE    ; /* 계약구분: 1=생손보(장기) 2=자동차 3=일반 (GRP_CMM_CD = INS_CONT_TYPE) VARCHAR2(4)    */
    private String SUBJECT          ; /* 대상(물건)                                                                     VARCHAR2(100)  */
    private String PLACE            ; /* 장소(주소)                                                                     VARCHAR2(100)  */
    private String ETC_COLLATERAL   ; /* 기타담보사항                                                                   VARCHAR2(100)  */
    private String USG_GBN          ; /* 용도구분(GRP_CMM_CD = USG_GBN)                                                 VARCHAR2(4)    */
    private String CARNUM           ; /* 차량번호                                                                       VARCHAR2(20)   */
    private String CARINFO          ; /* 차량정보(제조사/모델명/연식)                                                   VARCHAR2(100)  */
    private String CAROPTION        ; /* 기타옵션                                                                       VARCHAR2(100)  */
    private String BIGO             ; /* 비고                                                                           VARCHAR2(100)  */
	private String AUTO_TRANS_YN         ; /* 자동이체여부(GRP_CMM_CD = AUTO_TRANS_YN) VARCHAR2(1)   */
	private String DUTY_STRT_DATE        ; /* 의무납입시작일                           VARCHAR2(10)  */
	private String DUTY_END_DATE         ; /* 의무납입종료일                           VARCHAR2(10)  */
	private String PAYMENT_END_DATE      ; /* 납입종료년도                             VARCHAR2(10)  */
	private String BANK                  ; /* 은행코드(GRP_CMM_CD = BANK)              VARCHAR2(50)  */
	private String OWNER                 ; /* 예금주                                   VARCHAR2(30)  */
	private String BK_ID                 ; /* 계좌번호                                 VARCHAR2(50)  */
	private String REGI_AUTO_TRANS_YN    ; /* 자동송금등록여부                         VARCHAR2(1)   */
	private String ANNUITY_YMD           ; /* 연금개시일                               VARCHAR2(10)  */
    private String ANNUITY_AGE           ; /* 연금개시연령                                                                   VARCHAR2(10)   */
	private String EXPECTED_RATE         ; /* 예정이율(%)                              NUMBER(22)    */
	private String DETERMIN_RATE         ; /* 확정이율(%)                              NUMBER(22)    */
	private String BENEFICIARY_MATU      ; /* 만기                                     VARCHAR2(10)  */
	private String BENEFICIARY_ADMI      ; /* 입원                                     VARCHAR2(10)  */
	private String BENEFICIARY_DEAD      ; /* 사망                                     VARCHAR2(10)  */
	private String DSNT_HEAL_YN          ; /* 건강체                                   VARCHAR2(1)   */
	private String DSNT_AUTO_YN          ; /* 자동이체                                 VARCHAR2(1)   */
	private String DSNT_GROUP_YN         ; /* 단체                                     VARCHAR2(1)   */
	private String MAIN_CONT_AMT         ; /* 주계약가입금액                           NUMBER(22)    */
	private String PRINCIPAL_AMT         ; /* 납입원금                                 NUMBER(22)    */
	private String ADDITIONAL_AMT        ; /* 추가납입보험료                           NUMBER(22)    */
	private String WITHDRAW_AMT          ; /* 인출보험금                               NUMBER(22)    */
	private String INSU_LOAN_AMT         ; /* 보험대출금                               NUMBER(22)    */
	private String ACCUMULATE_AMT        ; /* 적립금                                   NUMBER(22)    */
	private String CAN_REFUND_AMT        ; /* 해약환급금                               NUMBER(22)    */
	private String MATURITY_AMT          ; /* 만기보험금                               NUMBER(22)    */
	private String ADDITIONAL_BUSI_AMT   ; /* 추가납입보험료 사업비율(%)               NUMBER(22)    */
	private String FUND_SUB_HIST         ; /* 펀드가입내역                             VARCHAR2(100) */
	private String MEPIBS_GBN1           ; /* 지연수령                                 VARCHAR2(1)   */
	private String MEPIBS_GBN2           ; /* 건강체할인                               VARCHAR2(1)   */
	private String MEPIBS_GBN3           ; /* 단체할인                                 VARCHAR2(1)   */
	private String MEPIBS_GBN4           ; /* 계약관계자변경                           VARCHAR2(1)   */
	private String MEPIBS_GBN5           ; /* 비용구조                                 VARCHAR2(1)   */
	private String MEPIBS_GBN6           ; /* 3SPA&10RT                                VARCHAR2(1)   */
	private String MEPIBS_GBN7           ; /* 연금저축&종목전환                        VARCHAR2(1)   */
	private String MEPIBS_GBN8           ; /* 변액보험펀드변경                         VARCHAR2(1)   */
	private String MEPIBS_GBN9           ; /* 가치상품                                 VARCHAR2(1)   */
	private String JONG_PIABO            ; /* 종피보험자                               VARCHAR2(20)  */
    
    private String MO_NM;		/* 모집인명 */
    private String YU_NM;		/* 유지FP명 */
    private String INSCO_NM;	/* 원수사명 */
    private String MO_SNM;		/* 모집인소속 */
    private String PROD_KIND1;  /* 상품군1 */
    private String MO_SNMPATH;	/* 모집인 소속경로 */
    private String YU_SNMPATH;  /* 유지FP 소속경로 */
    private String EMPINFO;		/* 사원정보(계약등록 시 퀵서치에서 사용) */
    private String BENEFICIARY;	/* 수익자 */
    private String BENEFICIARY_NM;	/* 수익자명 */
    private String UPREM_AMT;	/* USD */
    private String HPREM_AMT;	/* HKD */
    private String DEPOSITRE_TOTAL;	/* 예금적립금총액 */
    private String PREM_PAID;	/* 총 기납입원금 */
    private String TRUST;		/* 신탁여부 */
    private String CUS_ACC_ID;	/* 고객접속ID */
	private String IFA_CD;		/* IFA 코드 */
	private String IFA_CD_NM;   /* IFA 코드명 */
	private String CUST_ID; 	/* 고객 ID(고객 테이블 CUST_ID 참조)  */
	private List list;
	
    
    // 장기/생보 일시납
    private String SRCH_SCD;				/* 조직코드 */
    private String SRCH_SNM;				/* 조직명 */
    private String SRCH_CON_EMP_WORD;		/* 사원명/사번 */
    private String SRCH_CON_WORD;			/* 증권번호/계약자명/피보험자명 */
    private String SRCH_CON_START_VALUE;	/* 계약시작일 */
    private String SRCH_CON_END_VALUE;		/* 계약종료일 */
    
    // 자동차
    private String SRCH_SCD2;				/* 조직코드 */
    private String SRCH_SNM2;				/* 조직명 */
    private String SRCH_CON_EMP_WORD2;		/* 사원명/사번 */
    private String SRCH_CON_WORD2;			/* 증권번호/계약자명/피보험자명/차량번호 */
    private String SRCH_CON_START_VALUE2;	/* 계약시작일 */
    private String SRCH_CON_END_VALUE2;		/* 계약종료일 */

    // 일반
    private String SRCH_SCD3;				/* 조직코드 */
    private String SRCH_SNM3;				/* 조직명 */
    private String SRCH_CON_EMP_WORD3;		/* 사원명/사번 */
    private String INSCO_CD3;				/* 원수사 */
    private String PROD_KIND23;				/* 상품명 */
    private String PROD_NM3;				/* 상품군2 */
    private String SRCH_CON_WORD3;			/* 증권번호/계약자명/피보험자명/물건명 */
    private String SRCH_CON_START_VALUE3;	/* 계약시작일 */
    private String SRCH_CON_END_VALUE3;		/* 계약종료일 */
    
    ArrayList<FileVO> fileList;				/* 첨부파일 목록 */
    ArrayList<ShareVO> shareList;			/* 쉐어 목록 */
    
    /* 쉐어정보 (TBCN_CONTRACT_SHARE)  */
    private String SHARE_CD     ; /* 쉐어구분코드(GRP_CMM_CD = SHARE_CD) VARCHAR2(1)   */
    private String SCD          ; /* 조직코드                            VARCHAR2(10)  */
    private String EMP_CD       ; /* 사원번호                            VARCHAR2(20)  */
    private String RET_RATIO    ; /* 성적(유지율)쉐어비율                NUMBER(22)    */
    private String FEES_RATIO   ; /* 수수료쉐어비율                      NUMBER(22)    */
    private String REF_SEQ      ; /* 계약 일련번호                       NUMBER(22)    */

    private String EMP_NM       ; /* 관리사원명 */
    private String SNM          ; /* 관리사원 조직명 */
    
    /* 크레딧, 월납화 */
    private String CREDIT       ; /* 크레딧 */
    private String USD_NAP_MONTH; /* USD 월납화 */
    private String HKD_NAP_MONTH; /* HKD 월납화 */
    private String TOTAL_COUNT; /* 총 건수*/
    private String TOTAL_CREDIT; /* 총 크레딧*/
    private String TOTAL_USD_NAP_MONTH; /* 총 USD 월납화 */
    private String TOTAL_HKD_NAP_MONTH; /* 총 HKD 월납화 */
    
    private String SRCH_CON_VALUE; /* 계약일자검색조건 */
    
    
    /* 업적조회 */
    private String SRCH_EMP; 			//하위업적조회(사번)
    private String SRCH_TERM_START_VALUE;       // 시작일자
    private String SRCH_TERM_END_VALUE;     // 끝 일자
    private String EMPSTA;      //  재직구분
    
    private String CONT_CNT;        //건수[기간]
    private String CONT_CREDIT;     //CREDIT[기간]
    private String CONT_USD;        //USD[기간]
    private String CONT_HKD;        //HKD[기간]
    private String CONT_CNT_M;      //건수[당월]
    private String CONT_CREDIT_M;       //CREDIT[당월]
    private String CONT_USD_M;      //USD[당월]
    private String CONT_HKD_M;      //HKD[당월]
    private String CONT_CNT_Y;      //건수[당년]
    private String CONT_CREDIT_Y;       //CREDIT[당년]
    private String CONT_USD_Y;      //USD[당년]
    private String CONT_HKD_Y;      //HKD[당년]
    private String CONT_CNT_PY;     //건수[직전 1년]
    private String CONT_CREDIT_PY;      //CREDIT[직전 1년]
    private String CONT_USD_PY;     //USD[직전 1년]
    private String CONT_HKD_PY;     //HKD[직전 1년]
      
	public String getCREDIT() {
		return CREDIT;
	}
	public void setCREDIT(String cREDIT) {
		CREDIT = cREDIT;
	}
	public String getUSD_NAP_MONTH() {
		return USD_NAP_MONTH;
	}
	public void setUSD_NAP_MONTH(String uSD_NAP_MONTH) {
		USD_NAP_MONTH = uSD_NAP_MONTH;
	}
	public String getHKD_NAP_MONTH() {
		return HKD_NAP_MONTH;
	}
	public void setHKD_NAP_MONTH(String hKD_NAP_MONTH) {
		HKD_NAP_MONTH = hKD_NAP_MONTH;
	}
	public String getTOTAL_COUNT() {
		return TOTAL_COUNT;
	}
	public void setTOTAL_COUNT(String tOTAL_COUNT) {
		TOTAL_COUNT = tOTAL_COUNT;
	}
	public String getTOTAL_CREDIT() {
		return TOTAL_CREDIT;
	}
	public void setTOTAL_CREDIT(String tOTAL_CREDIT) {
		TOTAL_CREDIT = tOTAL_CREDIT;
	}
	public String getTOTAL_USD_NAP_MONTH() {
		return TOTAL_USD_NAP_MONTH;
	}
	public void setTOTAL_USD_NAP_MONTH(String tOTAL_USD_NAP_MONTH) {
		TOTAL_USD_NAP_MONTH = tOTAL_USD_NAP_MONTH;
	}
	public String getTOTAL_HKD_NAP_MONTH() {
		return TOTAL_HKD_NAP_MONTH;
	}
	public void setTOTAL_HKD_NAP_MONTH(String tOTAL_HKD_NAP_MONTH) {
		TOTAL_HKD_NAP_MONTH = tOTAL_HKD_NAP_MONTH;
	}
	public String getGEAJA_NM() {
		return GEAJA_NM;
	}
	public void setGEAJA_NM(String gEAJA_NM) {
		GEAJA_NM = gEAJA_NM;
	}
	public String getPIABO_NM() {
		return PIABO_NM;
	}
	public void setPIABO_NM(String pIABO_NM) {
		PIABO_NM = pIABO_NM;
	}
	public String getBENEFICIARY_NM() {
		return BENEFICIARY_NM;
	}
	public void setBENEFICIARY_NM(String bENEFICIARY_NM) {
		BENEFICIARY_NM = bENEFICIARY_NM;
	}
	public List getCustomerList() {
		return list;
	}
	public void setCustomerList(List customerList) {
		this.list = customerList;
	}
	public String getCUST_ID() {
		return CUST_ID;
	}
	public void setCUST_ID(String cUST_ID) {
		CUST_ID = cUST_ID;
	}
	public String getIFA_CD() {
		return IFA_CD;
	}
	public void setIFA_CD(String iFA_CD) {
		IFA_CD = iFA_CD;
	}
	public String getBENEFICIARY() {
		return BENEFICIARY;
	}
	public void setBENEFICIARY(String bENEFICIARY) {
		BENEFICIARY = bENEFICIARY;
	}
	public String getUPREM_AMT() {
		return UPREM_AMT;
	}
	public void setUPREM_AMT(String uPREM_AMT) {
		UPREM_AMT = uPREM_AMT;
	}
	public String getHPREM_AMT() {
		return HPREM_AMT;
	}
	public void setHPREM_AMT(String hPREM_AMT) {
		HPREM_AMT = hPREM_AMT;
	}
	public String getDEPOSITRE_TOTAL() {
		return DEPOSITRE_TOTAL;
	}
	public void setDEPOSITRE_TOTAL(String dEPOSITRE_TOTAL) {
		DEPOSITRE_TOTAL = dEPOSITRE_TOTAL;
	}
	public String getPREM_PAID() {
		return PREM_PAID;
	}
	public void setPREM_PAID(String pREM_PAID) {
		PREM_PAID = pREM_PAID;
	}
	public String getTRUST() {
		return TRUST;
	}
	public void setTRUST(String tRUST) {
		TRUST = tRUST;
	}
	public String getCUS_ACC_ID() {
		return CUS_ACC_ID;
	}
	public void setCUS_ACC_ID(String cUS_ACC_ID) {
		CUS_ACC_ID = cUS_ACC_ID;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
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
	public String getPROD_SEQ() {
		return PROD_SEQ;
	}
	public void setPROD_SEQ(String pROD_SEQ) {
		PROD_SEQ = pROD_SEQ;
	}
	public String getPROD_NM() {
		return PROD_NM;
	}
	public void setPROD_NM(String pROD_NM) {
		PROD_NM = pROD_NM;
	}
	public String getPROD_KIND2() {
		return PROD_KIND2;
	}
	public void setPROD_KIND2(String pROD_KIND2) {
		PROD_KIND2 = pROD_KIND2;
	}
	public String getCONT_DATE() {
		return CONT_DATE;
	}
	public void setCONT_DATE(String cONT_DATE) {
		CONT_DATE = cONT_DATE;
	}
	public String getCONT_STATUS() {
		return CONT_STATUS;
	}
	public void setCONT_STATUS(String cONT_STATUS) {
		CONT_STATUS = cONT_STATUS;
	}
	public String getNAPCNT() {
		return NAPCNT;
	}
	public void setNAPCNT(String nAPCNT) {
		NAPCNT = nAPCNT;
	}
	public String getSUGUM_STATUS() {
		return SUGUM_STATUS;
	}
	public void setSUGUM_STATUS(String sUGUM_STATUS) {
		SUGUM_STATUS = sUGUM_STATUS;
	}
	public String getNAP_MONTH() {
		return NAP_MONTH;
	}
	public void setNAP_MONTH(String nAP_MONTH) {
		NAP_MONTH = nAP_MONTH;
	}
	public String getNAP_DATE() {
		return NAP_DATE;
	}
	public void setNAP_DATE(String nAP_DATE) {
		NAP_DATE = nAP_DATE;
	}
	public String getSTATUS_DATE() {
		return STATUS_DATE;
	}
	public void setSTATUS_DATE(String sTATUS_DATE) {
		STATUS_DATE = sTATUS_DATE;
	}
	public String getGIJUN_DATE() {
		return GIJUN_DATE;
	}
	public void setGIJUN_DATE(String gIJUN_DATE) {
		GIJUN_DATE = gIJUN_DATE;
	}
	public String getNAPMETHOD() {
		return NAPMETHOD;
	}
	public void setNAPMETHOD(String nAPMETHOD) {
		NAPMETHOD = nAPMETHOD;
	}
	public String getNAPGI() {
		return NAPGI;
	}
	public void setNAPGI(String nAPGI) {
		NAPGI = nAPGI;
	}
	public String getNAPGI_GBN() {
		return NAPGI_GBN;
	}
	public void setNAPGI_GBN(String nAPGI_GBN) {
		NAPGI_GBN = nAPGI_GBN;
	}
	public String getPREM_AMT() {
		return PREM_AMT;
	}
	public void setPREM_AMT(String pREM_AMT) {
		PREM_AMT = pREM_AMT;
	}
	public String getMON_PREM_AMT() {
		return MON_PREM_AMT;
	}
	public void setMON_PREM_AMT(String mON_PREM_AMT) {
		MON_PREM_AMT = mON_PREM_AMT;
	}
	public String getDSNT_AMT() {
		return DSNT_AMT;
	}
	public void setDSNT_AMT(String dSNT_AMT) {
		DSNT_AMT = dSNT_AMT;
	}
	public String getDISCOUNT_YN() {
		return DISCOUNT_YN;
	}
	public void setDISCOUNT_YN(String dISCOUNT_YN) {
		DISCOUNT_YN = dISCOUNT_YN;
	}
	public String getINSU_STRT_DATE() {
		return INSU_STRT_DATE;
	}
	public void setINSU_STRT_DATE(String iNSU_STRT_DATE) {
		INSU_STRT_DATE = iNSU_STRT_DATE;
	}
	public String getINSU_END_DATE() {
		return INSU_END_DATE;
	}
	public void setINSU_END_DATE(String iNSU_END_DATE) {
		INSU_END_DATE = iNSU_END_DATE;
	}
	public String getLIFE_YN() {
		return LIFE_YN;
	}
	public void setLIFE_YN(String lIFE_YN) {
		LIFE_YN = lIFE_YN;
	}
	public String getINSCO_HWAN() {
		return INSCO_HWAN;
	}
	public void setINSCO_HWAN(String iNSCO_HWAN) {
		INSCO_HWAN = iNSCO_HWAN;
	}
	public String getHWAN_RATE() {
		return HWAN_RATE;
	}
	public void setHWAN_RATE(String hWAN_RATE) {
		HWAN_RATE = hWAN_RATE;
	}
	public String getHWAN() {
		return HWAN;
	}
	public void setHWAN(String hWAN) {
		HWAN = hWAN;
	}
	public String getMO_CD() {
		return MO_CD;
	}
	public void setMO_CD(String mO_CD) {
		MO_CD = mO_CD;
	}
	public String getFAMILY_CONT() {
		return FAMILY_CONT;
	}
	public void setFAMILY_CONT(String fAMILY_CONT) {
		FAMILY_CONT = fAMILY_CONT;
	}
	public String getDB_CONT() {
		return DB_CONT;
	}
	public void setDB_CONT(String dB_CONT) {
		DB_CONT = dB_CONT;
	}
	public String getBUNGUB_CONT() {
		return BUNGUB_CONT;
	}
	public void setBUNGUB_CONT(String bUNGUB_CONT) {
		BUNGUB_CONT = bUNGUB_CONT;
	}
	public String getCAREFUL_CONT() {
		return CAREFUL_CONT;
	}
	public void setCAREFUL_CONT(String cAREFUL_CONT) {
		CAREFUL_CONT = cAREFUL_CONT;
	}
	public String getISSUE() {
		return ISSUE;
	}
	public void setISSUE(String iSSUE) {
		ISSUE = iSSUE;
	}
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
	public String getGCUST_ID() {
		return GCUST_ID;
	}
	public void setGCUST_ID(String gCUST_ID) {
		GCUST_ID = gCUST_ID;
	}
	public String getGEAJA() {
		return GEAJA;
	}
	public void setGEAJA(String gEAJA) {
		GEAJA = gEAJA;
	}
	public String getGPERNO() {
		return GPERNO;
	}
	public void setGPERNO(String gPERNO) {
		GPERNO = gPERNO;
	}
	public String getGCORP_YN() {
		return GCORP_YN;
	}
	public void setGCORP_YN(String gCORP_YN) {
		GCORP_YN = gCORP_YN;
	}
	public String getGFOREIGN_YN() {
		return GFOREIGN_YN;
	}
	public void setGFOREIGN_YN(String gFOREIGN_YN) {
		GFOREIGN_YN = gFOREIGN_YN;
	}
	public String getGHPNO() {
		return GHPNO;
	}
	public void setGHPNO(String gHPNO) {
		GHPNO = gHPNO;
	}
	public String getGTELNO() {
		return GTELNO;
	}
	public void setGTELNO(String gTELNO) {
		GTELNO = gTELNO;
	}
	public String getGFAXNO() {
		return GFAXNO;
	}
	public void setGFAXNO(String gFAXNO) {
		GFAXNO = gFAXNO;
	}
	public String getGEMAIL() {
		return GEMAIL;
	}
	public void setGEMAIL(String gEMAIL) {
		GEMAIL = gEMAIL;
	}
	public String getGZIPCD() {
		return GZIPCD;
	}
	public void setGZIPCD(String gZIPCD) {
		GZIPCD = gZIPCD;
	}
	public String getGADDR1() {
		return GADDR1;
	}
	public void setGADDR1(String gADDR1) {
		GADDR1 = gADDR1;
	}
	public String getGADDR2() {
		return GADDR2;
	}
	public void setGADDR2(String gADDR2) {
		GADDR2 = gADDR2;
	}
	public String getSAME_YN() {
		return SAME_YN;
	}
	public void setSAME_YN(String sAME_YN) {
		SAME_YN = sAME_YN;
	}
	public String getPCUST_ID() {
		return PCUST_ID;
	}
	public void setPCUST_ID(String pCUST_ID) {
		PCUST_ID = pCUST_ID;
	}
	public String getPIABO() {
		return PIABO;
	}
	public void setPIABO(String pIABO) {
		PIABO = pIABO;
	}
	public String getPPERNO() {
		return PPERNO;
	}
	public void setPPERNO(String pPERNO) {
		PPERNO = pPERNO;
	}
	public String getPCORP_YN() {
		return PCORP_YN;
	}
	public void setPCORP_YN(String pCORP_YN) {
		PCORP_YN = pCORP_YN;
	}
	public String getPFOREIGN_YN() {
		return PFOREIGN_YN;
	}
	public void setPFOREIGN_YN(String pFOREIGN_YN) {
		PFOREIGN_YN = pFOREIGN_YN;
	}
	public String getPHPNO() {
		return PHPNO;
	}
	public void setPHPNO(String pHPNO) {
		PHPNO = pHPNO;
	}
	public String getPTELNO() {
		return PTELNO;
	}
	public void setPTELNO(String pTELNO) {
		PTELNO = pTELNO;
	}
	public String getPFAXNO() {
		return PFAXNO;
	}
	public void setPFAXNO(String pFAXNO) {
		PFAXNO = pFAXNO;
	}
	public String getPEMAIL() {
		return PEMAIL;
	}
	public void setPEMAIL(String pEMAIL) {
		PEMAIL = pEMAIL;
	}
	public String getPZIPCD() {
		return PZIPCD;
	}
	public void setPZIPCD(String pZIPCD) {
		PZIPCD = pZIPCD;
	}
	public String getPADDR1() {
		return PADDR1;
	}
	public void setPADDR1(String pADDR1) {
		PADDR1 = pADDR1;
	}
	public String getPADDR2() {
		return PADDR2;
	}
	public void setPADDR2(String pADDR2) {
		PADDR2 = pADDR2;
	}
	public String getINS_CONT_TYPE() {
		return INS_CONT_TYPE;
	}
	public void setINS_CONT_TYPE(String iNS_CONT_TYPE) {
		INS_CONT_TYPE = iNS_CONT_TYPE;
	}
	public String getSUBJECT() {
		return SUBJECT;
	}
	public void setSUBJECT(String sUBJECT) {
		SUBJECT = sUBJECT;
	}
	public String getPLACE() {
		return PLACE;
	}
	public void setPLACE(String pLACE) {
		PLACE = pLACE;
	}
	public String getETC_COLLATERAL() {
		return ETC_COLLATERAL;
	}
	public void setETC_COLLATERAL(String eTC_COLLATERAL) {
		ETC_COLLATERAL = eTC_COLLATERAL;
	}
	public String getUSG_GBN() {
		return USG_GBN;
	}
	public void setUSG_GBN(String uSG_GBN) {
		USG_GBN = uSG_GBN;
	}
	public String getCARNUM() {
		return CARNUM;
	}
	public void setCARNUM(String cARNUM) {
		CARNUM = cARNUM;
	}
	public String getCARINFO() {
		return CARINFO;
	}
	public void setCARINFO(String cARINFO) {
		CARINFO = cARINFO;
	}
	public String getCAROPTION() {
		return CAROPTION;
	}
	public void setCAROPTION(String cAROPTION) {
		CAROPTION = cAROPTION;
	}
	public String getBIGO() {
		return BIGO;
	}
	public void setBIGO(String bIGO) {
		BIGO = bIGO;
	}
	public String getAUTO_TRANS_YN() {
		return AUTO_TRANS_YN;
	}
	public void setAUTO_TRANS_YN(String aUTO_TRANS_YN) {
		AUTO_TRANS_YN = aUTO_TRANS_YN;
	}
	public String getDUTY_STRT_DATE() {
		return DUTY_STRT_DATE;
	}
	public void setDUTY_STRT_DATE(String dUTY_STRT_DATE) {
		DUTY_STRT_DATE = dUTY_STRT_DATE;
	}
	public String getDUTY_END_DATE() {
		return DUTY_END_DATE;
	}
	public void setDUTY_END_DATE(String dUTY_END_DATE) {
		DUTY_END_DATE = dUTY_END_DATE;
	}
	public String getPAYMENT_END_DATE() {
		return PAYMENT_END_DATE;
	}
	public void setPAYMENT_END_DATE(String pAYMENT_END_DATE) {
		PAYMENT_END_DATE = pAYMENT_END_DATE;
	}
	public String getBANK() {
		return BANK;
	}
	public void setBANK(String bANK) {
		BANK = bANK;
	}
	public String getOWNER() {
		return OWNER;
	}
	public void setOWNER(String oWNER) {
		OWNER = oWNER;
	}
	public String getBK_ID() {
		return BK_ID;
	}
	public void setBK_ID(String bK_ID) {
		BK_ID = bK_ID;
	}
	public String getREGI_AUTO_TRANS_YN() {
		return REGI_AUTO_TRANS_YN;
	}
	public void setREGI_AUTO_TRANS_YN(String rEGI_AUTO_TRANS_YN) {
		REGI_AUTO_TRANS_YN = rEGI_AUTO_TRANS_YN;
	}
	public String getANNUITY_YMD() {
		return ANNUITY_YMD;
	}
	public void setANNUITY_YMD(String aNNUITY_YMD) {
		ANNUITY_YMD = aNNUITY_YMD;
	}
	public String getYU_CD() {
		return YU_CD;
	}
	public void setYU_CD(String yU_CD) {
		YU_CD = yU_CD;
	}
	public String getANNUITY_AGE() {
		return ANNUITY_AGE;
	}
	public void setANNUITY_AGE(String aNNUITY_AGE) {
		ANNUITY_AGE = aNNUITY_AGE;
	}
	public String getEXPECTED_RATE() {
		return EXPECTED_RATE;
	}
	public void setEXPECTED_RATE(String eXPECTED_RATE) {
		EXPECTED_RATE = eXPECTED_RATE;
	}
	public String getDETERMIN_RATE() {
		return DETERMIN_RATE;
	}
	public void setDETERMIN_RATE(String dETERMIN_RATE) {
		DETERMIN_RATE = dETERMIN_RATE;
	}
	public String getBENEFICIARY_MATU() {
		return BENEFICIARY_MATU;
	}
	public void setBENEFICIARY_MATU(String bENEFICIARY_MATU) {
		BENEFICIARY_MATU = bENEFICIARY_MATU;
	}
	public String getBENEFICIARY_ADMI() {
		return BENEFICIARY_ADMI;
	}
	public void setBENEFICIARY_ADMI(String bENEFICIARY_ADMI) {
		BENEFICIARY_ADMI = bENEFICIARY_ADMI;
	}
	public String getBENEFICIARY_DEAD() {
		return BENEFICIARY_DEAD;
	}
	public void setBENEFICIARY_DEAD(String bENEFICIARY_DEAD) {
		BENEFICIARY_DEAD = bENEFICIARY_DEAD;
	}
	public String getDSNT_HEAL_YN() {
		return DSNT_HEAL_YN;
	}
	public void setDSNT_HEAL_YN(String dSNT_HEAL_YN) {
		DSNT_HEAL_YN = dSNT_HEAL_YN;
	}
	public String getDSNT_AUTO_YN() {
		return DSNT_AUTO_YN;
	}
	public void setDSNT_AUTO_YN(String dSNT_AUTO_YN) {
		DSNT_AUTO_YN = dSNT_AUTO_YN;
	}
	public String getDSNT_GROUP_YN() {
		return DSNT_GROUP_YN;
	}
	public void setDSNT_GROUP_YN(String dSNT_GROUP_YN) {
		DSNT_GROUP_YN = dSNT_GROUP_YN;
	}
	public String getMAIN_CONT_AMT() {
		return MAIN_CONT_AMT;
	}
	public void setMAIN_CONT_AMT(String mAIN_CONT_AMT) {
		MAIN_CONT_AMT = mAIN_CONT_AMT;
	}
	public String getPRINCIPAL_AMT() {
		return PRINCIPAL_AMT;
	}
	public void setPRINCIPAL_AMT(String pRINCIPAL_AMT) {
		PRINCIPAL_AMT = pRINCIPAL_AMT;
	}
	public String getADDITIONAL_AMT() {
		return ADDITIONAL_AMT;
	}
	public void setADDITIONAL_AMT(String aDDITIONAL_AMT) {
		ADDITIONAL_AMT = aDDITIONAL_AMT;
	}
	public String getWITHDRAW_AMT() {
		return WITHDRAW_AMT;
	}
	public void setWITHDRAW_AMT(String wITHDRAW_AMT) {
		WITHDRAW_AMT = wITHDRAW_AMT;
	}
	public String getINSU_LOAN_AMT() {
		return INSU_LOAN_AMT;
	}
	public void setINSU_LOAN_AMT(String iNSU_LOAN_AMT) {
		INSU_LOAN_AMT = iNSU_LOAN_AMT;
	}
	public String getACCUMULATE_AMT() {
		return ACCUMULATE_AMT;
	}
	public void setACCUMULATE_AMT(String aCCUMULATE_AMT) {
		ACCUMULATE_AMT = aCCUMULATE_AMT;
	}
	public String getCAN_REFUND_AMT() {
		return CAN_REFUND_AMT;
	}
	public void setCAN_REFUND_AMT(String cAN_REFUND_AMT) {
		CAN_REFUND_AMT = cAN_REFUND_AMT;
	}
	public String getMATURITY_AMT() {
		return MATURITY_AMT;
	}
	public void setMATURITY_AMT(String mATURITY_AMT) {
		MATURITY_AMT = mATURITY_AMT;
	}
	public String getADDITIONAL_BUSI_AMT() {
		return ADDITIONAL_BUSI_AMT;
	}
	public void setADDITIONAL_BUSI_AMT(String aDDITIONAL_BUSI_AMT) {
		ADDITIONAL_BUSI_AMT = aDDITIONAL_BUSI_AMT;
	}
	public String getFUND_SUB_HIST() {
		return FUND_SUB_HIST;
	}
	public void setFUND_SUB_HIST(String fUND_SUB_HIST) {
		FUND_SUB_HIST = fUND_SUB_HIST;
	}
	public String getMEPIBS_GBN1() {
		return MEPIBS_GBN1;
	}
	public void setMEPIBS_GBN1(String mEPIBS_GBN1) {
		MEPIBS_GBN1 = mEPIBS_GBN1;
	}
	public String getMEPIBS_GBN2() {
		return MEPIBS_GBN2;
	}
	public void setMEPIBS_GBN2(String mEPIBS_GBN2) {
		MEPIBS_GBN2 = mEPIBS_GBN2;
	}
	public String getMEPIBS_GBN3() {
		return MEPIBS_GBN3;
	}
	public void setMEPIBS_GBN3(String mEPIBS_GBN3) {
		MEPIBS_GBN3 = mEPIBS_GBN3;
	}
	public String getMEPIBS_GBN4() {
		return MEPIBS_GBN4;
	}
	public void setMEPIBS_GBN4(String mEPIBS_GBN4) {
		MEPIBS_GBN4 = mEPIBS_GBN4;
	}
	public String getMEPIBS_GBN5() {
		return MEPIBS_GBN5;
	}
	public void setMEPIBS_GBN5(String mEPIBS_GBN5) {
		MEPIBS_GBN5 = mEPIBS_GBN5;
	}
	public String getMEPIBS_GBN6() {
		return MEPIBS_GBN6;
	}
	public void setMEPIBS_GBN6(String mEPIBS_GBN6) {
		MEPIBS_GBN6 = mEPIBS_GBN6;
	}
	public String getMEPIBS_GBN7() {
		return MEPIBS_GBN7;
	}
	public void setMEPIBS_GBN7(String mEPIBS_GBN7) {
		MEPIBS_GBN7 = mEPIBS_GBN7;
	}
	public String getMEPIBS_GBN8() {
		return MEPIBS_GBN8;
	}
	public void setMEPIBS_GBN8(String mEPIBS_GBN8) {
		MEPIBS_GBN8 = mEPIBS_GBN8;
	}
	public String getMEPIBS_GBN9() {
		return MEPIBS_GBN9;
	}
	public void setMEPIBS_GBN9(String mEPIBS_GBN9) {
		MEPIBS_GBN9 = mEPIBS_GBN9;
	}
	public String getJONG_PIABO() {
		return JONG_PIABO;
	}
	public void setJONG_PIABO(String jONG_PIABO) {
		JONG_PIABO = jONG_PIABO;
	}
	public String getMO_NM() {
		return MO_NM;
	}
	public void setMO_NM(String mO_NM) {
		MO_NM = mO_NM;
	}
	public String getYU_NM() {
		return YU_NM;
	}
	public void setYU_NM(String yU_NM) {
		YU_NM = yU_NM;
	}
	public String getINSCO_NM() {
		return INSCO_NM;
	}
	public void setINSCO_NM(String iNSCO_NM) {
		INSCO_NM = iNSCO_NM;
	}
	public String getMO_SNM() {
		return MO_SNM;
	}
	public void setMO_SNM(String mO_SNM) {
		MO_SNM = mO_SNM;
	}
	public String getSRCH_SCD() {
		return SRCH_SCD;
	}
	public void setSRCH_SCD(String sRCH_SCD) {
		SRCH_SCD = sRCH_SCD;
	}
	public String getSRCH_SNM() {
		return SRCH_SNM;
	}
	public void setSRCH_SNM(String sRCH_SNM) {
		SRCH_SNM = sRCH_SNM;
	}
	public String getSRCH_CON_EMP_WORD() {
		return SRCH_CON_EMP_WORD;
	}
	public void setSRCH_CON_EMP_WORD(String sRCH_CON_EMP_WORD) {
		SRCH_CON_EMP_WORD = sRCH_CON_EMP_WORD;
	}
	public String getSRCH_CON_WORD() {
		return SRCH_CON_WORD;
	}
	public void setSRCH_CON_WORD(String sRCH_CON_WORD) {
		SRCH_CON_WORD = sRCH_CON_WORD;
	}
	public String getSRCH_CON_START_VALUE() {
		return SRCH_CON_START_VALUE;
	}
	public void setSRCH_CON_START_VALUE(String sRCH_CON_START_VALUE) {
		SRCH_CON_START_VALUE = sRCH_CON_START_VALUE;
	}
	public String getSRCH_CON_END_VALUE() {
		return SRCH_CON_END_VALUE;
	}
	public void setSRCH_CON_END_VALUE(String sRCH_CON_END_VALUE) {
		SRCH_CON_END_VALUE = sRCH_CON_END_VALUE;
	}
	public String getSRCH_SCD2() {
		return SRCH_SCD2;
	}
	public void setSRCH_SCD2(String sRCH_SCD2) {
		SRCH_SCD2 = sRCH_SCD2;
	}
	public String getSRCH_SNM2() {
		return SRCH_SNM2;
	}
	public void setSRCH_SNM2(String sRCH_SNM2) {
		SRCH_SNM2 = sRCH_SNM2;
	}
	public String getSRCH_CON_EMP_WORD2() {
		return SRCH_CON_EMP_WORD2;
	}
	public void setSRCH_CON_EMP_WORD2(String sRCH_CON_EMP_WORD2) {
		SRCH_CON_EMP_WORD2 = sRCH_CON_EMP_WORD2;
	}
	public String getSRCH_CON_WORD2() {
		return SRCH_CON_WORD2;
	}
	public void setSRCH_CON_WORD2(String sRCH_CON_WORD2) {
		SRCH_CON_WORD2 = sRCH_CON_WORD2;
	}
	public String getSRCH_CON_START_VALUE2() {
		return SRCH_CON_START_VALUE2;
	}
	public void setSRCH_CON_START_VALUE2(String sRCH_CON_START_VALUE2) {
		SRCH_CON_START_VALUE2 = sRCH_CON_START_VALUE2;
	}
	public String getSRCH_CON_END_VALUE2() {
		return SRCH_CON_END_VALUE2;
	}
	public void setSRCH_CON_END_VALUE2(String sRCH_CON_END_VALUE2) {
		SRCH_CON_END_VALUE2 = sRCH_CON_END_VALUE2;
	}
	public String getSRCH_SCD3() {
		return SRCH_SCD3;
	}
	public void setSRCH_SCD3(String sRCH_SCD3) {
		SRCH_SCD3 = sRCH_SCD3;
	}
	public String getSRCH_SNM3() {
		return SRCH_SNM3;
	}
	public void setSRCH_SNM3(String sRCH_SNM3) {
		SRCH_SNM3 = sRCH_SNM3;
	}
	public String getSRCH_CON_EMP_WORD3() {
		return SRCH_CON_EMP_WORD3;
	}
	public void setSRCH_CON_EMP_WORD3(String sRCH_CON_EMP_WORD3) {
		SRCH_CON_EMP_WORD3 = sRCH_CON_EMP_WORD3;
	}
	public String getINSCO_CD3() {
		return INSCO_CD3;
	}
	public void setINSCO_CD3(String iNSCO_CD3) {
		INSCO_CD3 = iNSCO_CD3;
	}
	public String getPROD_KIND23() {
		return PROD_KIND23;
	}
	public void setPROD_KIND23(String pROD_KIND23) {
		PROD_KIND23 = pROD_KIND23;
	}
	public String getPROD_NM3() {
		return PROD_NM3;
	}
	public void setPROD_NM3(String pROD_NM3) {
		PROD_NM3 = pROD_NM3;
	}
	public String getSRCH_CON_WORD3() {
		return SRCH_CON_WORD3;
	}
	public void setSRCH_CON_WORD3(String sRCH_CON_WORD3) {
		SRCH_CON_WORD3 = sRCH_CON_WORD3;
	}
	public String getSRCH_CON_START_VALUE3() {
		return SRCH_CON_START_VALUE3;
	}
	public void setSRCH_CON_START_VALUE3(String sRCH_CON_START_VALUE3) {
		SRCH_CON_START_VALUE3 = sRCH_CON_START_VALUE3;
	}
	public String getSRCH_CON_END_VALUE3() {
		return SRCH_CON_END_VALUE3;
	}
	public void setSRCH_CON_END_VALUE3(String sRCH_CON_END_VALUE3) {
		SRCH_CON_END_VALUE3 = sRCH_CON_END_VALUE3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<FileVO> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<FileVO> fileList) {
		this.fileList = fileList;
	}
	public ArrayList<ShareVO> getShareList() {
		return shareList;
	}
	public void setShareList(ArrayList<ShareVO> shareList) {
		this.shareList = shareList;
	}
	public String getSHARE_CD() {
		return SHARE_CD;
	}
	public void setSHARE_CD(String sHARE_CD) {
		SHARE_CD = sHARE_CD;
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
	public String getPROD_KIND1() {
		return PROD_KIND1;
	}
	public void setPROD_KIND1(String pROD_KIND1) {
		PROD_KIND1 = pROD_KIND1;
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
	public String getMO_SNMPATH() {
		return MO_SNMPATH;
	}
	public void setMO_SNMPATH(String mO_SNMPATH) {
		MO_SNMPATH = mO_SNMPATH;
	}
	public String getYU_SNMPATH() {
		return YU_SNMPATH;
	}
	public void setYU_SNMPATH(String yU_SNMPATH) {
		YU_SNMPATH = yU_SNMPATH;
	}
	public String getEMPINFO() {
		return EMPINFO;
	}
	public void setEMPINFO(String eMPINFO) {
		EMPINFO = eMPINFO;
	}
	public String getACCOUNT_END_DATE() {
		return ACCOUNT_END_DATE;
	}
	public void setACCOUNT_END_DATE(String aCCOUNT_END_DATE) {
		ACCOUNT_END_DATE = aCCOUNT_END_DATE;
	}
	public String getSRCH_CON_VALUE() {
		return SRCH_CON_VALUE;
	}
	public void setSRCH_CON_VALUE(String sRCH_CON_VALUE) {
		SRCH_CON_VALUE = sRCH_CON_VALUE;
	}
	public String getSRCH_EMP() {
		return SRCH_EMP;
	}
	public void setSRCH_EMP(String sRCH_EMP) {
		SRCH_EMP = sRCH_EMP;
	}
	public String getSRCH_TERM_START_VALUE() {
		return SRCH_TERM_START_VALUE;
	}
	public void setSRCH_TERM_START_VALUE(String sRCH_TERM_START_VALUE) {
		SRCH_TERM_START_VALUE = sRCH_TERM_START_VALUE;
	}
	public String getSRCH_TERM_END_VALUE() {
		return SRCH_TERM_END_VALUE;
	}
	public void setSRCH_TERM_END_VALUE(String sRCH_TERM_END_VALUE) {
		SRCH_TERM_END_VALUE = sRCH_TERM_END_VALUE;
	}
	public String getEMPSTA() {
		return EMPSTA;
	}
	public void setEMPSTA(String eMPSTA) {
		EMPSTA = eMPSTA;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getCONT_CNT() {
		return CONT_CNT;
	}
	public void setCONT_CNT(String cONT_CNT) {
		CONT_CNT = cONT_CNT;
	}
	public String getCONT_CREDIT() {
		return CONT_CREDIT;
	}
	public void setCONT_CREDIT(String cONT_CREDIT) {
		CONT_CREDIT = cONT_CREDIT;
	}
	public String getCONT_USD() {
		return CONT_USD;
	}
	public void setCONT_USD(String cONT_USD) {
		CONT_USD = cONT_USD;
	}
	public String getCONT_HKD() {
		return CONT_HKD;
	}
	public void setCONT_HKD(String cONT_HKD) {
		CONT_HKD = cONT_HKD;
	}
	public String getCONT_CNT_M() {
		return CONT_CNT_M;
	}
	public void setCONT_CNT_M(String cONT_CNT_M) {
		CONT_CNT_M = cONT_CNT_M;
	}
	public String getCONT_CREDIT_M() {
		return CONT_CREDIT_M;
	}
	public void setCONT_CREDIT_M(String cONT_CREDIT_M) {
		CONT_CREDIT_M = cONT_CREDIT_M;
	}
	public String getCONT_USD_M() {
		return CONT_USD_M;
	}
	public void setCONT_USD_M(String cONT_USD_M) {
		CONT_USD_M = cONT_USD_M;
	}
	public String getCONT_HKD_M() {
		return CONT_HKD_M;
	}
	public void setCONT_HKD_M(String cONT_HKD_M) {
		CONT_HKD_M = cONT_HKD_M;
	}
	public String getCONT_CNT_Y() {
		return CONT_CNT_Y;
	}
	public void setCONT_CNT_Y(String cONT_CNT_Y) {
		CONT_CNT_Y = cONT_CNT_Y;
	}
	public String getCONT_CREDIT_Y() {
		return CONT_CREDIT_Y;
	}
	public void setCONT_CREDIT_Y(String cONT_CREDIT_Y) {
		CONT_CREDIT_Y = cONT_CREDIT_Y;
	}
	public String getCONT_USD_Y() {
		return CONT_USD_Y;
	}
	public void setCONT_USD_Y(String cONT_USD_Y) {
		CONT_USD_Y = cONT_USD_Y;
	}
	public String getCONT_HKD_Y() {
		return CONT_HKD_Y;
	}
	public void setCONT_HKD_Y(String cONT_HKD_Y) {
		CONT_HKD_Y = cONT_HKD_Y;
	}
	public String getCONT_CNT_PY() {
		return CONT_CNT_PY;
	}
	public void setCONT_CNT_PY(String cONT_CNT_PY) {
		CONT_CNT_PY = cONT_CNT_PY;
	}
	public String getCONT_CREDIT_PY() {
		return CONT_CREDIT_PY;
	}
	public void setCONT_CREDIT_PY(String cONT_CREDIT_PY) {
		CONT_CREDIT_PY = cONT_CREDIT_PY;
	}
	public String getCONT_USD_PY() {
		return CONT_USD_PY;
	}
	public void setCONT_USD_PY(String cONT_USD_PY) {
		CONT_USD_PY = cONT_USD_PY;
	}
	public String getCONT_HKD_PY() {
		return CONT_HKD_PY;
	}
	public void setCONT_HKD_PY(String cONT_HKD_PY) {
		CONT_HKD_PY = cONT_HKD_PY;
	}
	public String getIFA_CD_NM() {
		return IFA_CD_NM;
	}
	public void setIFA_CD_NM(String iFA_CD_NM) {
		IFA_CD_NM = iFA_CD_NM;
	}
	
}
