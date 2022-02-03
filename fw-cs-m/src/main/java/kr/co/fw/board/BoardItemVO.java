package kr.co.fw.board;

import java.util.List;

import kr.co.fw.common.file.FileVO;


public class BoardItemVO {
	
	private String MB_ID;
	private String BD_NO;        // 게시판번호
	private String BD_NM;        // 게시판명
	private String ITEM_NO;         // 게시글번호
	private String ITEM_KEY;
	private String TITL;            // 제목
	private String CONT;            // 내용
	private String ORGN_WRTN_NO;    // 원글번호
	private String PRNT_WRTN_NO;	// 부모글번호
	private String ORGN_WRTN_DCD;   // 원본글구분코드
	private String DEPTH;           // depth
	private String INQ_CNT;         // 조회수
	private String HGRK_FIX_YN;     // 상위고정여부
	private String POPUP_YN;        // 팝업여부
	private String ATCH_FILE_CNT;   // 첨부파일건수
	private String ATCH_FILE;   	// 첨부파일
	private String HIGHLIGHT_YN;    // 강조여부
	private String ANNC_YN;         // 공지여부(announce)
	private String ANNC_DAYS;       // 공지일수(announce)
	private String MAIN_YN;         // 메인공지여부
	private String MAIN_DAYS;       // 메인공지일수
	private String NTC_YN;          // 알리미사용여부(notice)
	private String NTC_FRYMD;       // 알리미시작일(notice)
	private String NTC_TOYMD;       // 알리미종료일(notice)
	private String OPEN_YN;         // 오픈여부
	private String SIDELINK;        // 사이드링크
	private String DATA_DCD;        // 데이터구분코드
	private String PLAYER_FILE_NM;  // 동영상파일경로
	private String AUTHOR;          // 작성자
	private String AUTHOR_NM;       // 작성자이름
	private String WRT_YMD;         // 작성일
	private String WRT_DTM;         // 작성일시
	private String CATEGORY;        // 카테고리
	private String CATEGORY_CD;     // 카테고리 코드
	private String CATEGORY_NM;     // 카테고리 이름
	private String openListStr;     // 게시판에 설정된 오픈 대상 범위(사업부)
	private String ATCH_YN;
	private String FIRST_NO;
	private String END_NO;
	private String PREV_NO;
	private String NEXT_NO;
	private String EMP_CD;
	private String START_DATE;
	private String END_DATE;
	private String SCHEDULE_YN;
	
	private String board;           // 게시판정보
	
	private String comment;         // 덧글(Comment) 정보
	
	private String fileListStr;     // 파일리스트 정보
	
	private String bultNoListStr; 	// 게시판내 게시글 번호
	
	private String RN;
	private String RESOURCE_URL;
	private String RESOURCE_ID;
	
	private String p;
	
	private String EXCLUDE_REPORT;
	private String SHARER;
	private String SHARER_NM;
	private String SHARER_PROFILE_PATH;
	private String SHARER_TEL_NO;
	
	private String SRCH_CTGR;
	private String SRCH_WORD;
	private String SRCH_TYPE;
	
	private String IN_DTM;
	
	private String limit_cnt;
	
	private List<FileVO> fileList = null;

	public String getMB_ID() {
		return MB_ID;
	}

	public void setMB_ID(String mB_ID) {
		MB_ID = mB_ID;
	}

	public String getBD_NO() {
		return BD_NO;
	}

	public void setBD_NO(String bD_NO) {
		BD_NO = bD_NO;
	}

	public String getBD_NM() {
		return BD_NM;
	}

	public void setBD_NM(String bD_NM) {
		BD_NM = bD_NM;
	}

	public String getITEM_NO() {
		return ITEM_NO;
	}

	public void setITEM_NO(String iTEM_NO) {
		ITEM_NO = iTEM_NO;
	}

	public String getITEM_KEY() {
		return ITEM_KEY;
	}

	public void setITEM_KEY(String iTEM_KEY) {
		ITEM_KEY = iTEM_KEY;
	}

	public String getTITL() {
		return TITL;
	}

	public void setTITL(String tITL) {
		TITL = tITL;
	}

	public String getCONT() {
		return CONT;
	}

	public void setCONT(String cONT) {
		CONT = cONT;
	}

	public String getORGN_WRTN_NO() {
		return ORGN_WRTN_NO;
	}

	public void setORGN_WRTN_NO(String oRGN_WRTN_NO) {
		ORGN_WRTN_NO = oRGN_WRTN_NO;
	}

	public String getPRNT_WRTN_NO() {
		return PRNT_WRTN_NO;
	}

	public void setPRNT_WRTN_NO(String pRNT_WRTN_NO) {
		PRNT_WRTN_NO = pRNT_WRTN_NO;
	}

	public String getORGN_WRTN_DCD() {
		return ORGN_WRTN_DCD;
	}

	public void setORGN_WRTN_DCD(String oRGN_WRTN_DCD) {
		ORGN_WRTN_DCD = oRGN_WRTN_DCD;
	}

	public String getDEPTH() {
		return DEPTH;
	}

	public void setDEPTH(String dEPTH) {
		DEPTH = dEPTH;
	}

	public String getINQ_CNT() {
		return INQ_CNT;
	}

	public void setINQ_CNT(String iNQ_CNT) {
		INQ_CNT = iNQ_CNT;
	}

	public String getHGRK_FIX_YN() {
		return HGRK_FIX_YN;
	}

	public void setHGRK_FIX_YN(String hGRK_FIX_YN) {
		HGRK_FIX_YN = hGRK_FIX_YN;
	}

	public String getPOPUP_YN() {
		return POPUP_YN;
	}

	public void setPOPUP_YN(String pOPUP_YN) {
		POPUP_YN = pOPUP_YN;
	}

	public String getATCH_FILE_CNT() {
		return ATCH_FILE_CNT;
	}

	public void setATCH_FILE_CNT(String aTCH_FILE_CNT) {
		ATCH_FILE_CNT = aTCH_FILE_CNT;
	}

	public String getATCH_FILE() {
		return ATCH_FILE;
	}

	public void setATCH_FILE(String aTCH_FILE) {
		ATCH_FILE = aTCH_FILE;
	}

	public String getHIGHLIGHT_YN() {
		return HIGHLIGHT_YN;
	}

	public void setHIGHLIGHT_YN(String hIGHLIGHT_YN) {
		HIGHLIGHT_YN = hIGHLIGHT_YN;
	}

	public String getANNC_YN() {
		return ANNC_YN;
	}

	public void setANNC_YN(String aNNC_YN) {
		ANNC_YN = aNNC_YN;
	}

	public String getANNC_DAYS() {
		return ANNC_DAYS;
	}

	public void setANNC_DAYS(String aNNC_DAYS) {
		ANNC_DAYS = aNNC_DAYS;
	}

	public String getMAIN_YN() {
		return MAIN_YN;
	}

	public void setMAIN_YN(String mAIN_YN) {
		MAIN_YN = mAIN_YN;
	}

	public String getMAIN_DAYS() {
		return MAIN_DAYS;
	}

	public void setMAIN_DAYS(String mAIN_DAYS) {
		MAIN_DAYS = mAIN_DAYS;
	}

	public String getNTC_YN() {
		return NTC_YN;
	}

	public void setNTC_YN(String nTC_YN) {
		NTC_YN = nTC_YN;
	}

	public String getNTC_FRYMD() {
		return NTC_FRYMD;
	}

	public void setNTC_FRYMD(String nTC_FRYMD) {
		NTC_FRYMD = nTC_FRYMD;
	}

	public String getNTC_TOYMD() {
		return NTC_TOYMD;
	}

	public void setNTC_TOYMD(String nTC_TOYMD) {
		NTC_TOYMD = nTC_TOYMD;
	}

	public String getOPEN_YN() {
		return OPEN_YN;
	}

	public void setOPEN_YN(String oPEN_YN) {
		OPEN_YN = oPEN_YN;
	}

	public String getSIDELINK() {
		return SIDELINK;
	}

	public void setSIDELINK(String sIDELINK) {
		SIDELINK = sIDELINK;
	}

	public String getDATA_DCD() {
		return DATA_DCD;
	}

	public void setDATA_DCD(String dATA_DCD) {
		DATA_DCD = dATA_DCD;
	}

	public String getPLAYER_FILE_NM() {
		return PLAYER_FILE_NM;
	}

	public void setPLAYER_FILE_NM(String pLAYER_FILE_NM) {
		PLAYER_FILE_NM = pLAYER_FILE_NM;
	}

	public String getAUTHOR() {
		return AUTHOR;
	}

	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}

	public String getAUTHOR_NM() {
		return AUTHOR_NM;
	}

	public void setAUTHOR_NM(String aUTHOR_NM) {
		AUTHOR_NM = aUTHOR_NM;
	}

	public String getWRT_YMD() {
		return WRT_YMD;
	}

	public void setWRT_YMD(String wRT_YMD) {
		WRT_YMD = wRT_YMD;
	}

	public String getWRT_DTM() {
		return WRT_DTM;
	}

	public void setWRT_DTM(String wRT_DTM) {
		WRT_DTM = wRT_DTM;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}

	public String getCATEGORY_CD() {
		return CATEGORY_CD;
	}

	public void setCATEGORY_CD(String cATEGORY_CD) {
		CATEGORY_CD = cATEGORY_CD;
	}

	public String getCATEGORY_NM() {
		return CATEGORY_NM;
	}

	public void setCATEGORY_NM(String cATEGORY_NM) {
		CATEGORY_NM = cATEGORY_NM;
	}

	public String getOpenListStr() {
		return openListStr;
	}

	public void setOpenListStr(String openListStr) {
		this.openListStr = openListStr;
	}

	public String getATCH_YN() {
		return ATCH_YN;
	}

	public void setATCH_YN(String aTCH_YN) {
		ATCH_YN = aTCH_YN;
	}

	public String getFIRST_NO() {
		return FIRST_NO;
	}

	public void setFIRST_NO(String fIRST_NO) {
		FIRST_NO = fIRST_NO;
	}

	public String getEND_NO() {
		return END_NO;
	}

	public void setEND_NO(String eND_NO) {
		END_NO = eND_NO;
	}

	public String getPREV_NO() {
		return PREV_NO;
	}

	public void setPREV_NO(String pREV_NO) {
		PREV_NO = pREV_NO;
	}

	public String getNEXT_NO() {
		return NEXT_NO;
	}

	public void setNEXT_NO(String nEXT_NO) {
		NEXT_NO = nEXT_NO;
	}

	public String getEMP_CD() {
		return EMP_CD;
	}

	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String eND_DATE) {
		END_DATE = eND_DATE;
	}

	public String getSCHEDULE_YN() {
		return SCHEDULE_YN;
	}

	public void setSCHEDULE_YN(String sCHEDULE_YN) {
		SCHEDULE_YN = sCHEDULE_YN;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFileListStr() {
		return fileListStr;
	}

	public void setFileListStr(String fileListStr) {
		this.fileListStr = fileListStr;
	}

	public String getBultNoListStr() {
		return bultNoListStr;
	}

	public void setBultNoListStr(String bultNoListStr) {
		this.bultNoListStr = bultNoListStr;
	}

	public String getRN() {
		return RN;
	}

	public void setRN(String rN) {
		RN = rN;
	}

	public String getRESOURCE_URL() {
		return RESOURCE_URL;
	}

	public void setRESOURCE_URL(String rESOURCE_URL) {
		RESOURCE_URL = rESOURCE_URL;
	}

	public String getRESOURCE_ID() {
		return RESOURCE_ID;
	}

	public void setRESOURCE_ID(String rESOURCE_ID) {
		RESOURCE_ID = rESOURCE_ID;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getEXCLUDE_REPORT() {
		return EXCLUDE_REPORT;
	}

	public void setEXCLUDE_REPORT(String eXCLUDE_REPORT) {
		EXCLUDE_REPORT = eXCLUDE_REPORT;
	}

	public String getSHARER() {
		return SHARER;
	}

	public void setSHARER(String sHARER) {
		SHARER = sHARER;
	}

	public String getSHARER_NM() {
		return SHARER_NM;
	}

	public void setSHARER_NM(String sHARER_NM) {
		SHARER_NM = sHARER_NM;
	}

	public String getSHARER_PROFILE_PATH() {
		return SHARER_PROFILE_PATH;
	}

	public void setSHARER_PROFILE_PATH(String sHARER_PROFILE_PATH) {
		SHARER_PROFILE_PATH = sHARER_PROFILE_PATH;
	}

	public String getSHARER_TEL_NO() {
		return SHARER_TEL_NO;
	}

	public void setSHARER_TEL_NO(String sHARER_TEL_NO) {
		SHARER_TEL_NO = sHARER_TEL_NO;
	}

	public String getSRCH_CTGR() {
		return SRCH_CTGR;
	}

	public void setSRCH_CTGR(String sRCH_CTGR) {
		SRCH_CTGR = sRCH_CTGR;
	}

	public String getSRCH_WORD() {
		return SRCH_WORD;
	}

	public void setSRCH_WORD(String sRCH_WORD) {
		SRCH_WORD = sRCH_WORD;
	}

	public List<FileVO> getFileList() {
		return fileList;
	}

	public void setFileList(List<FileVO> fileList) {
		this.fileList = fileList;
	}

	public String getIN_DTM() {
		return IN_DTM;
	}

	public void setIN_DTM(String iN_DTM) {
		IN_DTM = iN_DTM;
	}

	public String getSRCH_TYPE() {
		return SRCH_TYPE;
	}

	public void setSRCH_TYPE(String sRCH_TYPE) {
		SRCH_TYPE = sRCH_TYPE;
	}

	public String getLimit_cnt() {
		return limit_cnt;
	}

	public void setLimit_cnt(String limit_cnt) {
		this.limit_cnt = limit_cnt;
	}

	
	
	
}
