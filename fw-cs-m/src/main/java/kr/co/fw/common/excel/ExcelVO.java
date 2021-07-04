package kr.co.fw.common.excel;

import kr.co.fw.base.BaseVO;

public class ExcelVO extends BaseVO {

	/* TBSY_EXCEL_MST */
	private String MB_NM;
	private String EXCEL_CD     ;  /* 입력데이타(EXCEL) 코드 VARCHAR2(5)      */
	private String EXCEL_NM     ;  /* 입력데이타(EXCEL) 명   VARCHAR2(30)     */
	private String INSCO_CD     ;  /* 원수사코드             VARCHAR2(3)      */
	private String INSCO_NM		;  /* 원수사명 								  */
	private String COM_CD_GBN   ;  /* 수수료코드구분         VARCHAR2(1)      */
	private String COM_CD_GBN_NM;
	private String DESCRIPTION  ;	/* 설명                   VARCHAR2(1000)  */ 
	
	/* EXCEL_DATA_MONTH */
	private String COM_YM	;/*	업적월	VARCHAR2(6) */
	private String DATA_CTG	;/*	업무영역	VARCHAR2(10) */
	private String DATA_CTG_NM	;	/* 업무영역명 */
	private String SEQ	;/*	일련번호	NUMBER(22) */
	
	/* TBSY_EXCEL_DATA_MAP_MST */
	private String DATA_CD		;/*	데이터코드(수수료마스터코드)	VARCHAR2(20) */
	private String GUIDE		;/*	가이드데이터	VARCHAR2(256) */
	private String REQ_YN		;/*	필수여부	VARCHAR2(1) */
	private String REQ_YN_OUT	;/*	필수여부 TEMP  */
	private String FIX_VAL		;/*	고정값	VARCHAR2(256) */
	private String DEFAULT_VAL	;/*	NULL일때 기본값	VARCHAR2(256) */
	
	/* TBSY_EXCEL_DATA_MAP_MONTH */
	private String ROW_RANGE	;/*	적용행범위(ALL:ROWSTART_SEQ부터 전체, ROW : ROWSTART_SEQ 1개행만)	VARCHAR2(10) */
	private String COL_CD		;/*	컬럼코드	VARCHAR2(4) */
	private String ROWSTART_SEQ	;/*	시작행일련번호	NUMBER(22) */
	
	/* TBSY_EXCEL_STATUS_MONTH */
	private String STATUS			;/*	업로드상태(ER:에러,SV:저장완료,NA:없음)	VARCHAR2(2) */
	private String IN_CNT			;/*	입력개수	NUMBER(22) */
	private String SAVE_CNT			;/*	저장개수	NUMBER(22) */
	private String ERR_CNT			;/*	에러개수	NUMBER(22) */
	private String EXCEL_FILE_NO	;/*	엑셀파일번호	VARCHAR2(40) */
	private String NO_FILE_YN		;/*	미입수여부	VARCHAR2(1) */
	
	/* TBSY_EXCEL_UPLOAD_TABLE_MST */
	private String TABLE_NAME;		/* 테이블명 VARCHAR2(30) */
	
	/* TBSY_EXCEL_UPLOAD_COLUMN_MST  */
	private String REF_SEQ;			/* 참조시퀀스(TBSY_EXCEL_UPLOAD_TABLE_MST의 SEQ) NUMBER */
	private String COLUMN_NAME;		/* 컬럼명 VARCHAR2(30)  */
	private String COLUMN_COMMENT;	/* 컬럼 코멘트	VARCHAR2(30) */
	private String DATA_TYPE;		/* 데이터유형	VARCHAR2(20) */
	private String NULLABLE;		/* 빈값허용유무	VARCHAR2(1) */
	
	public String getMB_NM() {
		return MB_NM;
	}
	public void setMB_NM(String mB_NM) {
		MB_NM = mB_NM;
	}
	public String getEXCEL_CD() {
		return EXCEL_CD;
	}
	public void setEXCEL_CD(String eXCEL_CD) {
		EXCEL_CD = eXCEL_CD;
	}
	public String getEXCEL_NM() {
		return EXCEL_NM;
	}
	public void setEXCEL_NM(String eXCEL_NM) {
		EXCEL_NM = eXCEL_NM;
	}
	public String getINSCO_CD() {
		return INSCO_CD;
	}
	public void setINSCO_CD(String iNSCO_CD) {
		INSCO_CD = iNSCO_CD;
	}
	public String getINSCO_NM() {
		return INSCO_NM;
	}
	public void setINSCO_NM(String iNSCO_NM) {
		INSCO_NM = iNSCO_NM;
	}
	public String getCOM_CD_GBN() {
		return COM_CD_GBN;
	}
	public void setCOM_CD_GBN(String cOM_CD_GBN) {
		COM_CD_GBN = cOM_CD_GBN;
	}
	public String getCOM_CD_GBN_NM() {
		return COM_CD_GBN_NM;
	}
	public void setCOM_CD_GBN_NM(String cOM_CD_GBN_NM) {
		COM_CD_GBN_NM = cOM_CD_GBN_NM;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	
	public String getCOM_YM() {
		return COM_YM;
	}
	public void setCOM_YM(String cOM_YM) {
		COM_YM = cOM_YM;
	}
	public String getDATA_CTG() {
		return DATA_CTG;
	}
	public void setDATA_CTG(String dATA_CTG) {
		DATA_CTG = dATA_CTG;
	}
	public String getDATA_CTG_NM() {
		return DATA_CTG_NM;
	}
	public void setDATA_CTG_NM(String dATA_CTG_NM) {
		DATA_CTG_NM = dATA_CTG_NM;
	}
	public String getSEQ() {
		return SEQ;
	}
	public void setSEQ(String sEQ) {
		SEQ = sEQ;
	}
	public String getDATA_CD() {
		return DATA_CD;
	}
	public void setDATA_CD(String dATA_CD) {
		DATA_CD = dATA_CD;
	}
	public String getGUIDE() {
		return GUIDE;
	}
	public void setGUIDE(String gUIDE) {
		GUIDE = gUIDE;
	}
	public String getREQ_YN() {
		return REQ_YN;
	}
	public void setREQ_YN(String rEQ_YN) {
		REQ_YN = rEQ_YN;
	}
	public String getREQ_YN_OUT() {
		return REQ_YN_OUT;
	}
	public void setREQ_YN_OUT(String rEQ_YN_OUT) {
		REQ_YN_OUT = rEQ_YN_OUT;
	}
	public String getFIX_VAL() {
		return FIX_VAL;
	}
	public void setFIX_VAL(String fIX_VAL) {
		FIX_VAL = fIX_VAL;
	}
	public String getDEFAULT_VAL() {
		return DEFAULT_VAL;
	}
	public void setDEFAULT_VAL(String dEFAULT_VAL) {
		DEFAULT_VAL = dEFAULT_VAL;
	}
	public String getROW_RANGE() {
		return ROW_RANGE;
	}
	public void setROW_RANGE(String rOW_RANGE) {
		ROW_RANGE = rOW_RANGE;
	}
	public String getCOL_CD() {
		return COL_CD;
	}
	public void setCOL_CD(String cOL_CD) {
		COL_CD = cOL_CD;
	}
	public String getROWSTART_SEQ() {
		return ROWSTART_SEQ;
	}
	public void setROWSTART_SEQ(String rOWSTART_SEQ) {
		ROWSTART_SEQ = rOWSTART_SEQ;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getIN_CNT() {
		return IN_CNT;
	}
	public void setIN_CNT(String iN_CNT) {
		IN_CNT = iN_CNT;
	}
	public String getSAVE_CNT() {
		return SAVE_CNT;
	}
	public void setSAVE_CNT(String sAVE_CNT) {
		SAVE_CNT = sAVE_CNT;
	}
	public String getERR_CNT() {
		return ERR_CNT;
	}
	public void setERR_CNT(String eRR_CNT) {
		ERR_CNT = eRR_CNT;
	}
	
	public String getEXCEL_FILE_NO() {
		return EXCEL_FILE_NO;
	}
	
	public void setEXCEL_FILE_NO(String eXCEL_FILE_NO) {
		EXCEL_FILE_NO = eXCEL_FILE_NO;
	}
	
	public String getNO_FILE_YN() {
		return NO_FILE_YN;
	}
	
	public void setNO_FILE_YN(String nO_FILE_YN) {
		NO_FILE_YN = nO_FILE_YN;
	}
	
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	
	public void setTABLE_NAME(String tABLE_NAME) {
		TABLE_NAME = tABLE_NAME;
	}
	
	public String getREF_SEQ() {
		return REF_SEQ;
	}
	
	public void setREF_SEQ(String rEF_SEQ) {
		REF_SEQ = rEF_SEQ;
	}
	
	public String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}
	
	public void setCOLUMN_NAME(String cOLUMN_NAME) {
		COLUMN_NAME = cOLUMN_NAME;
	}
	
	public String getCOLUMN_COMMENT() {
		return COLUMN_COMMENT;
	}
	
	public void setCOLUMN_COMMENT(String cOLUMN_COMMENT) {
		COLUMN_COMMENT = cOLUMN_COMMENT;
	}
	
	public String getDATA_TYPE() {
		return DATA_TYPE;
	}
	
	public void setDATA_TYPE(String dATA_TYPE) {
		DATA_TYPE = dATA_TYPE;
	}
	
	public String getNULLABLE() {
		return NULLABLE;
	}
	
	public void setNULLABLE(String nULLABLE) {
		NULLABLE = nULLABLE;
	}
	
}
