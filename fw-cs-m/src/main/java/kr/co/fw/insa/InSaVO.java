package kr.co.fw.insa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.fw.base.BaseVO;
import kr.co.fw.common.file.FileVO;

/**
 * 인사정보 VO TBIN_EMPMST
 */
public class InSaVO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 5552939733840697694L;
	
	private String COM_YM;
    private List<HashMap<String,String>> COM_YM_ARR = null;
	private String SEQ             ;  /* 일련번호(TBIN_EMPMST_FSB_SEQ)                NUMBER(22)     */
	private String EMP_CD          ;  /* 사원코드                                     VARCHAR2(20)   */
	private String EMP_NM          ;  /* 사원명                                       VARCHAR2(20)   */
	private String USER_ID         ;  /* 사원ID                                       VARCHAR2(20)   */
	private String SCD             ;  /* 조직코드                                     VARCHAR2(20)   */
	private String PERNO           ;  /* 주민등록번호                                 VARCHAR2(4000) */
	private String HPNO            ;  /* 핸드폰번호                                   VARCHAR2(20)   */
	private String JOIN_GBN        ;  /* 입사구분(GRP_CMM_CD = JOIN_GBN)              VARCHAR2(20)   */
	private String NOW_SCD   	   ;  /* 현소속                                  VARCHAR2(250)   */
	private String JIKGUB          ;  /* 직급코드(GRP_CMM_CD = JIKGUB)                VARCHAR2(20)   */
	private String JIKCHK          ;  /* 직책코드(GRP_CMM_CD = JIKCHK)                VARCHAR2(20)   */
	private String EMAIL           ;  /* 이메일                                       VARCHAR2(50)   */
	private String ZIPCD           ;  /* 우편번호                                     VARCHAR2(7)    */
	private String ADDR1           ;  /* 자택주소                                     VARCHAR2(200)  */
	private String ADDR2           ;  /* 자택주소상세                                 VARCHAR2(200)  */
	private String EMPSTA          ;  /* 재직여부(GRP_CMM_CD = EMPSTA)                VARCHAR2(20)   */
	private String PAY_GBN         ;  /* 급여구분(GRP_CMM_CD = PAY_GBN)               VARCHAR2(20)   */
	private String RE_EMP_CD       ;  /* 소개자 사원코드                              VARCHAR2(20)   */
	private String RE_EMP_NM       ;  /* 소개자 사원명                                VARCHAR2(20)   */
	private String MG_EMP_CD       ;  /* 관리자 사원코드                              VARCHAR2(20)   */
	private String MG_EMP_NM       ;  /* 관리자 사원명                                VARCHAR2(20)   */
	private String RCRT_TYPE       ;  /* 유치방식(GRP_CMM_CD = RCRT_TYPE)             VARCHAR2(1)    */
	private String LREG_YMD        ;  /* 생보등록일                                   VARCHAR2(10)   */
	private String NREG_YMD        ;  /* 손보등록일                                   VARCHAR2(10)   */
	private String VREG_YMD        ;  /* 변액등록일                                   VARCHAR2(10)   */
	private String ENT_YMD         ;  /* 입사일자                                     VARCHAR2(10)   */
	private String GENT_YMD        ;  /* 위촉일자                                     VARCHAR2(10)   */
	private String END_YMD         ;  /* 퇴사일자                                     VARCHAR2(10)   */
	private String OUT_YMD         ;  /* 해촉일자                                     VARCHAR2(10)   */
	private String BANK            ;  /* 은행코드(GRP_CMM_CD = BANK)                  VARCHAR2(20)   */
	private String BK_ID           ;  /* 계좌번호                                     VARCHAR2(66)   */
	private String OWNER           ;  /* 예금주                                       VARCHAR2(50)   */
	private String H_BANK;  /* 홍콩 은행코드(GRP_CMM_CD = H_BANK)                  VARCHAR2(20)   */
	private String H_BK_ID;  /* 홍콩 계좌번호                                     VARCHAR2(66)   */
	private String H_OWNER;  /* 홍콩 예금주                                       VARCHAR2(50)   */
	private String HBANK;  /* 홍콩 은행코드(GRP_CMM_CD = H_BANK)                  VARCHAR2(20)   */
	private String HBK_ID;  /* 홍콩 계좌번호                                     VARCHAR2(66)   */
	private String HOWNER;  /* 홍콩 예금주                                       VARCHAR2(50)   */
	private String OWNER_RELATION  ;  /* 예금주와의 관계(GRP_CMM_CD = OWNER_RELATION) VARCHAR2(20)   */
	private String MEMO            ;  /* 메모                                         VARCHAR2(1000) */
	private String FILE_NAME       ;  /* 첨부파일명                                   VARCHAR2(200)  */
	private String ROLE_ID         ;  /* 시스템 사용권한                              VARCHAR2(10)   */
	private String BOARD_ROLE_ID   ;  /* 게시판 시스템 사용권한                     VARCHAR2(10)   */
	private String BOARD_ROLE_NM   ;  /* 게시판 시스템 사용권한명                     VARCHAR2(10)   */
	private String PASSPORT_NUM	   ;  /* 여권번호                              VARCHAR2(15)   */
	private String ADDRE1	   	   ;  /* 영문주소                              VARCHAR2(250)   */
	private String ADDRE2	   	   ;  /* 영문상세주소                              VARCHAR2(250)   */
	private String EMP_NME	   	   ;  /* 영문이름               			 VARCHAR2(30)   */
    ArrayList<FileVO> fileList     ;  /* 첨부파일 목록 */
    ArrayList<FileVO> necessaryFileList     ;  /* 필수첨부파일 목록 */
	
    private String RE_EMP_SCD = ""; 	// 소개자조직코드
    private String RE_EMP_SNM = ""; 	// 소개자조직명
    private String RE_JIKGUB;			// 소개자 직급
    private String RCRT_TYPENM = "";	// 유치방식명
    private String SCDPATH = "";  		// 조직경로 (본사/~지사/~팀)
    private String SCDNMPATH = "";		// 조직경로 (본사/~지사/~팀)
    private String SCDNMPATH1 = "";		// 조직경로 (본사)
    private String SCDNMPATH2 = "";   	// 조직경로 (~지사)
    private String SCDNMPATH3 = "";  	// 조직경로 (~팀)
    private String SCDNMPATH4 = "";  	// 조직경로 (~팀)
    private String SCDNMPATH5 = "";  	// 조직경로 (~팀)
    private String SNM = "";     		// 조직명
    private String SNMPATH;				// 조직경로2
    private String PAY_GBNNM = ""; 		// 급여구분명
    private String JIKGUBNM = "";  		// 직급명 
    private String JIKCHKNM = "";  		// 직책명 
    private String EMPSTANM = ""; 	    // 재직구분명 
    private String JOIN_GBNNM = ""; 	// 입사구분명
    private String BANKNM;				// 은행코드명
    private String OWNER_RELATIONNM;	// 예금주와의 관계명
	private String ROLE_NM		   ;  /* 시스템 사용권한명 */ 
    
    private String EMPINFO = "";   // 사원정보(퀵서치 데이터 받아올 때 사용)
    private String DATA_DCD;

	private String SRCH_SCD;
	private String SRCH_SNM;
	private String SRCH_EMP;
	private String SRCH_EMP_VALUE;
	private String SRCH_JIKCHK;
	private String SRCH_JIKGUB;
	private String SRCH_ROLE_ID;		// 조회권한
	private String SRCH_EMPSTA;
	private String SRCH_TERM; 			// 조회 - 기간 - 조회조건들
	private String SRCH_TERM_START_VALUE;
	private String SRCH_TERM_END_VALUE;
	
	private String SRCH_EMP_DETAIL;		/* 인사 상세정보 : 6개월 전까지 보여지도록 */
	
	private String queryStr; //조직경로를 동적으로 만들기위해
	private String SRCH_BOARD_AUTH; //게시판권한 조회
	
	private String CNT;
	private String HPREM_AMT;
	private String UPERM_AMT;
	private String CREDIT;
	
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
	public String getPASSPORT_NUM() {
		return PASSPORT_NUM;
	}
	public void setPASSPORT_NUM(String pASSPORT_NUM) {
		PASSPORT_NUM = pASSPORT_NUM;
	}
	public String getADDRE1() {
		return ADDRE1;
	}
	public void setADDRE1(String aDDRE1) {
		ADDRE1 = aDDRE1;
	}
	public String getADDRE2() {
		return ADDRE2;
	}
	public void setADDRE2(String aDDRE2) {
		ADDRE2 = aDDRE2;
	}
	public String getEMP_NME() {
		return EMP_NME;
	}
	public void setEMP_NME(String eMP_NME) {
		EMP_NME = eMP_NME;
	}
	public List<HashMap<String, String>> getCOM_YM_ARR() {
		return COM_YM_ARR;
	}
	public void setCOM_YM_ARR(List<HashMap<String, String>> cOM_YM_ARR) {
		COM_YM_ARR = cOM_YM_ARR;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
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
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getSCD() {
		return SCD;
	}
	public void setSCD(String sCD) {
		SCD = sCD;
	}
	public String getPERNO() {
		return PERNO;
	}
	public void setPERNO(String pERNO) {
		PERNO = pERNO;
	}
	public String getHPNO() {
		return HPNO;
	}
	public void setHPNO(String hPNO) {
		HPNO = hPNO;
	}
	public String getJOIN_GBN() {
		return JOIN_GBN;
	}
	public void setJOIN_GBN(String jOIN_GBN) {
		JOIN_GBN = jOIN_GBN;
	}
	public String getNOW_SCD() {
		return NOW_SCD;
	}
	public void setNOW_SCD(String nOW_SCD) {
		NOW_SCD = nOW_SCD;
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
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
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
	public String getEMPSTA() {
		return EMPSTA;
	}
	public void setEMPSTA(String eMPSTA) {
		EMPSTA = eMPSTA;
	}
	public String getPAY_GBN() {
		return PAY_GBN;
	}
	public void setPAY_GBN(String pAY_GBN) {
		PAY_GBN = pAY_GBN;
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
	public String getRCRT_TYPE() {
		return RCRT_TYPE;
	}
	public void setRCRT_TYPE(String rCRT_TYPE) {
		RCRT_TYPE = rCRT_TYPE;
	}
	public String getLREG_YMD() {
		return LREG_YMD;
	}
	public void setLREG_YMD(String lREG_YMD) {
		LREG_YMD = lREG_YMD;
	}
	public String getNREG_YMD() {
		return NREG_YMD;
	}
	public void setNREG_YMD(String nREG_YMD) {
		NREG_YMD = nREG_YMD;
	}
	public String getVREG_YMD() {
		return VREG_YMD;
	}
	public void setVREG_YMD(String vREG_YMD) {
		VREG_YMD = vREG_YMD;
	}
	public String getENT_YMD() {
		return ENT_YMD;
	}
	public void setENT_YMD(String eNT_YMD) {
		ENT_YMD = eNT_YMD;
	}
	public String getGENT_YMD() {
		return GENT_YMD;
	}
	public void setGENT_YMD(String gENT_YMD) {
		GENT_YMD = gENT_YMD;
	}
	public String getEND_YMD() {
		return END_YMD;
	}
	public void setEND_YMD(String eND_YMD) {
		END_YMD = eND_YMD;
	}
	public String getOUT_YMD() {
		return OUT_YMD;
	}
	public void setOUT_YMD(String oUT_YMD) {
		OUT_YMD = oUT_YMD;
	}
	public String getBANK() {
		return BANK;
	}
	public void setBANK(String bANK) {
		BANK = bANK;
	}
	public String getBK_ID() {
		return BK_ID;
	}
	public void setBK_ID(String bK_ID) {
		BK_ID = bK_ID;
	}
	public String getOWNER() {
		return OWNER;
	}
	public void setOWNER(String oWNER) {
		OWNER = oWNER;
	}
	public String getOWNER_RELATION() {
		return OWNER_RELATION;
	}
	public void setOWNER_RELATION(String oWNER_RELATION) {
		OWNER_RELATION = oWNER_RELATION;
	}
	public String getMEMO() {
		return MEMO;
	}
	public void setMEMO(String mEMO) {
		MEMO = mEMO;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	public String getRE_EMP_SCD() {
		return RE_EMP_SCD;
	}
	public void setRE_EMP_SCD(String rE_EMP_SCD) {
		RE_EMP_SCD = rE_EMP_SCD;
	}
	public String getRE_EMP_SNM() {
		return RE_EMP_SNM;
	}
	public void setRE_EMP_SNM(String rE_EMP_SNM) {
		RE_EMP_SNM = rE_EMP_SNM;
	}
	public String getRE_JIKGUB() {
		return RE_JIKGUB;
	}
	public void setRE_JIKGUB(String rE_JIKGUB) {
		RE_JIKGUB = rE_JIKGUB;
	}
	public String getRCRT_TYPENM() {
		return RCRT_TYPENM;
	}
	public void setRCRT_TYPENM(String rCRT_TYPENM) {
		RCRT_TYPENM = rCRT_TYPENM;
	}
	public String getSCDPATH() {
		return SCDPATH;
	}
	public void setSCDPATH(String sCDPATH) {
		SCDPATH = sCDPATH;
	}
	public String getSCDNMPATH() {
		return SCDNMPATH;
	}
	public void setSCDNMPATH(String sCDNMPATH) {
		SCDNMPATH = sCDNMPATH;
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
	public String getSNM() {
		return SNM;
	}
	public void setSNM(String sNM) {
		SNM = sNM;
	}
	public String getSNMPATH() {
		return SNMPATH;
	}
	public void setSNMPATH(String sNMPATH) {
		SNMPATH = sNMPATH;
	}
	public String getPAY_GBNNM() {
		return PAY_GBNNM;
	}
	public void setPAY_GBNNM(String pAY_GBNNM) {
		PAY_GBNNM = pAY_GBNNM;
	}
	public String getJIKGUBNM() {
		return JIKGUBNM;
	}
	public void setJIKGUBNM(String jIKGUBNM) {
		JIKGUBNM = jIKGUBNM;
	}
	public String getJIKCHKNM() {
		return JIKCHKNM;
	}
	public void setJIKCHKNM(String jIKCHKNM) {
		JIKCHKNM = jIKCHKNM;
	}
	public String getEMPSTANM() {
		return EMPSTANM;
	}
	public void setEMPSTANM(String eMPSTANM) {
		EMPSTANM = eMPSTANM;
	}
	public String getJOIN_GBNNM() {
		return JOIN_GBNNM;
	}
	public void setJOIN_GBNNM(String jOIN_GBNNM) {
		JOIN_GBNNM = jOIN_GBNNM;
	}
	public String getBANKNM() {
		return BANKNM;
	}
	public void setBANKNM(String bANKNM) {
		BANKNM = bANKNM;
	}
	public String getOWNER_RELATIONNM() {
		return OWNER_RELATIONNM;
	}
	public void setOWNER_RELATIONNM(String oWNER_RELATIONNM) {
		OWNER_RELATIONNM = oWNER_RELATIONNM;
	}
	public String getEMPINFO() {
		return EMPINFO;
	}
	public void setEMPINFO(String eMPINFO) {
		EMPINFO = eMPINFO;
	}
	
	public String getDATA_DCD() {
		return DATA_DCD;
	}
	public void setDATA_DCD(String dATA_DCD) {
		DATA_DCD = dATA_DCD;
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
	public String getSRCH_EMP() {
		return SRCH_EMP;
	}
	public void setSRCH_EMP(String sRCH_EMP) {
		SRCH_EMP = sRCH_EMP;
	}
	public String getSRCH_EMP_VALUE() {
		return SRCH_EMP_VALUE;
	}
	public void setSRCH_EMP_VALUE(String sRCH_EMP_VALUE) {
		SRCH_EMP_VALUE = sRCH_EMP_VALUE;
	}
	public String getSRCH_JIKCHK() {
		return SRCH_JIKCHK;
	}
	public void setSRCH_JIKCHK(String sRCH_JIKCHK) {
		SRCH_JIKCHK = sRCH_JIKCHK;
	}
	public String getSRCH_JIKGUB() {
		return SRCH_JIKGUB;
	}
	public void setSRCH_JIKGUB(String sRCH_JIKGUB) {
		SRCH_JIKGUB = sRCH_JIKGUB;
	}
	public String getSRCH_ROLE_ID() {
		return SRCH_ROLE_ID;
	}
	public void setSRCH_ROLE_ID(String sRCH_ROLE_ID) {
		SRCH_ROLE_ID = sRCH_ROLE_ID;
	}
	public String getBOARD_ROLE_ID() {
		return BOARD_ROLE_ID;
	}
	public void setBOARD_ROLE_ID(String bOARD_ROLE_ID) {
		BOARD_ROLE_ID = bOARD_ROLE_ID;
	}
	public String getBOARD_ROLE_NM() {
		return BOARD_ROLE_NM;
	}
	public void setBOARD_ROLE_NM(String bOARD_ROLE_NM) {
		BOARD_ROLE_NM = bOARD_ROLE_NM;
	}
	public String getSRCH_EMPSTA() {
		return SRCH_EMPSTA;
	}
	public void setSRCH_EMPSTA(String sRCH_EMPSTA) {
		SRCH_EMPSTA = sRCH_EMPSTA;
	}
	public String getSRCH_TERM() {
		return SRCH_TERM;
	}
	public void setSRCH_TERM(String sRCH_TERM) {
		SRCH_TERM = sRCH_TERM;
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
	public String getSRCH_EMP_DETAIL() {
		return SRCH_EMP_DETAIL;
	}
	public void setSRCH_EMP_DETAIL(String sRCH_EMP_DETAIL) {
		SRCH_EMP_DETAIL = sRCH_EMP_DETAIL;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getROLE_ID() {
		return ROLE_ID;
	}
	public void setROLE_ID(String rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}
	public String getROLE_NM() {
		return ROLE_NM;
	}
	public void setROLE_NM(String rOLE_NM) {
		ROLE_NM = rOLE_NM;
	}
	public ArrayList<FileVO> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<FileVO> fileList) {
		this.fileList = fileList;
	}
	public ArrayList<FileVO> getNecessaryFileList() {
		return necessaryFileList;
	}
	public void setNecessaryFileList(ArrayList<FileVO> necessaryFileList) {
		this.necessaryFileList = necessaryFileList;
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
	public String getH_BANK() {
		return H_BANK;
	}
	public void setH_BANK(String h_BANK) {
		H_BANK = h_BANK;
	}
	public String getH_BK_ID() {
		return H_BK_ID;
	}
	public void setH_BK_ID(String h_BK_ID) {
		H_BK_ID = h_BK_ID;
	}
	public String getH_OWNER() {
		return H_OWNER;
	}
	public void setH_OWNER(String h_OWNER) {
		H_OWNER = h_OWNER;
	}
	public String getHBANK() {
		return HBANK;
	}
	public void setHBANK(String hBANK) {
		HBANK = hBANK;
	}
	public String getHBK_ID() {
		return HBK_ID;
	}
	public void setHBK_ID(String hBK_ID) {
		HBK_ID = hBK_ID;
	}
	public String getHOWNER() {
		return HOWNER;
	}
	public void setHOWNER(String hOWNER) {
		HOWNER = hOWNER;
	}
	public String getSRCH_BOARD_AUTH() {
		return SRCH_BOARD_AUTH;
	}
	public void setSRCH_BOARD_AUTH(String sRCH_BOARD_AUTH) {
		SRCH_BOARD_AUTH = sRCH_BOARD_AUTH;
	}
	public String getCNT() {
		return CNT;
	}
	public void setCNT(String cNT) {
		CNT = cNT;
	}
	public String getHPREM_AMT() {
		return HPREM_AMT;
	}
	public void setHPREM_AMT(String hPREM_AMT) {
		HPREM_AMT = hPREM_AMT;
	}
	public String getUPERM_AMT() {
		return UPERM_AMT;
	}
	public void setUPERM_AMT(String uPERM_AMT) {
		UPERM_AMT = uPERM_AMT;
	}
	public String getCREDIT() {
		return CREDIT;
	}
	public void setCREDIT(String cREDIT) {
		CREDIT = cREDIT;
	}
	
}
