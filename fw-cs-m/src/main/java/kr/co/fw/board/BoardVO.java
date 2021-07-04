package kr.co.fw.board;

import java.util.ArrayList;

import kr.co.fw.base.BaseVO;

public class BoardVO extends BaseVO {
	
    /**
     * BoardVO 게시판
     */
	// 게시판의 일반적인 정보
	private String BD_NO;         // 게시판번호            NUMBER
    private String BD_NM;         // 게시판명              VARCHAR2(150)
    private String BDNMPATH;      // 게시판경로
    private String BD_DESC;       // 게시판설명            VARCHAR2(300)
    private String PBD_NO;  	  // 부모게시판번호        NUMBER
    private String FOLDER_YN;     // 그룹(폴더)여부             VARCHAR2(1)
    private String FOLDER_YN_NM;  // 그룹(폴더)여부 이름
    private String MENU_GBN;      // 게시판, 자료실 구분
    private String BD_RESOURCE_ID;         // 메뉴 resource 앞부분
    private String BD_CNT;		  // 가져올 게시글의 갯수

    // 게시판 자체의 기능적특성
    private String RPL_USE_EN;       // 답급사용여부          VARCHAR2(1)
    private String APND_USE_EN;      // 덧글사용여부          VARCHAR2(1)
    private String BULT_DEL_USE_EN;  // 게시글 삭제 사용 유무 VARCHAR2(1)
//    private int    NW_BULT_APPT_PRID;// 신규 게시글 적용기간  NUMBER
    private String NW_BULT_APPT_PRID;// 신규 게시글 적용기간  NUMBER
    private String SRCH_USE_EN;      // 검색기능 사용유무     VARCHAR2(1)
    private String ATCH_FILE_USE_EN; // 첨부파일 사용 유무    VARCHAR2(1)
//    private int    ABL_ATCH_CNT;     // 가능첨부파일 개수     NUMBER
    private String ABL_ATCH_CNT;     // 가능첨부파일 개수     NUMBER
    private String PLAYER_USE_EN;    // 동영상 사용유무       VARCHAR2(1)
    private String KNOWLEDGE_EN;     // 지식공유 사용유무     VARCHAR2(1)
    private String SIDELINK_EN;      // 사이드링크 사용유무   VARCHAR2(1)
    private String OPEN_EN;          // 오픈관리 사용유무     VARCHAR2(1)
    //private String USE_YN;           // 게시판 사용유무       VARCHAR2(1)
    private String DESIG_RECEIVER_YN; // 수신자 지정가능여부  VARCHAR2(1)
    private String CATEGORY;          // 카테고리
    private String [] OpenSCD;        //
    private ArrayList<?> OpenSCDList; // 공개설정(사업부)     
    
    // 게시판이 부모로서 통계적인 특성(테이블에는 없어도 됨)
    private int    ITM_CNT;           // 게시판 글등록수       NUMBER
    private int    RPL_CNT;           // 답글 등록수           NUMBER
    private int    COMMENT_CNT;           // 댓글 등록수           NUMBER
    
    // 메타데이터
    private String EMP_CD;

    private String ISLEAF;           // 계층구조에서 leaf 여부 (세터가 필요없음)
    private String LV  = "";
    
    private String DSP_MAIN_YN; 		//해당 게시판 메인 노출 여부
    private String DSP_MAIN_POSITION;   //해당 게시판 메인에 노출시 위치 지정(1~3) (DISPLAY_MAIN_POSITION)
    private String TEMPDATA;			// 게시판파일 등록용 임시변수
    
    private String RESOURCE_URL;
    
    private String CONF_CD;
    private String CONF_VAL;
    private String CONF_CD_NM;
    private String CONF_CD_DESC;
    private String DEFAULT_VAL;
    
    //게시글
    private String ITEM_NO;
    private String FILE_NM;
    private String GUBUN;
    
    private String EXCLUDE_REPORT;
    
    
	public String getBD_CNT() {
		return BD_CNT;
	}
	public void setBD_CNT(String bD_CNT) {
		BD_CNT = bD_CNT;
	}
	public String getRESOURCE_URL() {
		return RESOURCE_URL;
	}
	public void setRESOURCE_URL(String rESOURCE_URL) {
		RESOURCE_URL = rESOURCE_URL;
	}

	public String getTEMPDATA() {
		return TEMPDATA;
	}
	public void setTEMPDATA(String tEMPDATA) {
		TEMPDATA = tEMPDATA;
	}
	public String getLV() {
		return LV;
	}
	public void setLV(String lV) {
		LV = lV;
	}
    public boolean getexpanded() {
		return true;
    }
    
	

	public String getFOLDER_YN() {
		return FOLDER_YN;
	}
	public void setFOLDER_YN(String fOLDER_YN) {
		FOLDER_YN = fOLDER_YN;
	}
	
	public String getFOLDER_YN_NM() {
		return FOLDER_YN_NM;
	}
	public void setFOLDER_YN_NM(String fOLDER_YN_NM) {
		FOLDER_YN_NM = fOLDER_YN_NM;
	}
	public String getMENU_GBN() {
		return MENU_GBN;
	}
	public void setMENU_GBN(String mENU_GBN) {
		MENU_GBN = mENU_GBN;
	}
	public String getRPL_USE_EN() {
		return RPL_USE_EN;
	}
	public void setRPL_USE_EN(String rPL_USE_EN) {
		RPL_USE_EN = rPL_USE_EN;
	}

	public String getAPND_USE_EN() {
		return APND_USE_EN;
	}
	public void setAPND_USE_EN(String aPND_USE_EN) {
		APND_USE_EN = aPND_USE_EN;
	}
	public String getBULT_DEL_USE_EN() {
		return BULT_DEL_USE_EN;
	}
	public void setBULT_DEL_USE_EN(String bULT_DEL_USE_EN) {
		BULT_DEL_USE_EN = bULT_DEL_USE_EN;
	}
	public String getSRCH_USE_EN() {
		return SRCH_USE_EN;
	}
	public void setSRCH_USE_EN(String sRCH_USE_EN) {
		SRCH_USE_EN = sRCH_USE_EN;
	}
	public String getATCH_FILE_USE_EN() {
		return ATCH_FILE_USE_EN;
	}
	public void setATCH_FILE_USE_EN(String aTCH_FILE_USE_EN) {
		ATCH_FILE_USE_EN = aTCH_FILE_USE_EN;
	}
	public String getPLAYER_USE_EN() {
		return PLAYER_USE_EN;
	}
	public void setPLAYER_USE_EN(String pLAYER_USE_EN) {
		PLAYER_USE_EN = pLAYER_USE_EN;
	}
	public String getKNOWLEDGE_EN() {
		return KNOWLEDGE_EN;
	}
	public void setKNOWLEDGE_EN(String kNOWLEDGE_EN) {
		KNOWLEDGE_EN = kNOWLEDGE_EN;
	}
	public String getSIDELINK_EN() {
		return SIDELINK_EN;
	}
	public void setSIDELINK_EN(String sIDELINK_EN) {
		SIDELINK_EN = sIDELINK_EN;
	}
	public String getOPEN_EN() {
		return OPEN_EN;
	}
	public void setOPEN_EN(String oPEN_EN) {
		OPEN_EN = oPEN_EN;
	}

	public int getITM_CNT() {
		return ITM_CNT;
	}
	public void setITM_CNT(int iTM_CNT) {
		ITM_CNT = iTM_CNT;
	}
	public int getRPL_CNT() {
		return RPL_CNT;
	}
	public void setRPL_CNT(int rPL_CNT) {
		RPL_CNT = rPL_CNT;
	}
	
	public int getCOMMENT_CNT() {
		return COMMENT_CNT;
	}
	public void setCOMMENT_CNT(int cOMMENT_CNT) {
		COMMENT_CNT = cOMMENT_CNT;
	}
//	public String getUSE_YN() {
//		return USE_YN;
//	}
//	public void setUSE_YN(String uSE_YN) {
//		USE_YN = uSE_YN;
//	}
	
    /**
     * 자식 존제여부 반환
     * getter만 있음
     * @param 0/1
     */
    public boolean getISLEAF_OUT() {
    	if("0".equals(this.ISLEAF)) 
    		return true;
    	else
    		return false;
	}
    
	public String getDESIG_RECEIVER_YN() {
		return DESIG_RECEIVER_YN;
	}
	public void setDESIG_RECEIVER_YN(String dESIG_RECEIVER_YN) {
		DESIG_RECEIVER_YN = dESIG_RECEIVER_YN;
	}
	
	public ArrayList<?> getOpenSCDList() {
		return OpenSCDList;
	}
	public void setOpenSCDList(ArrayList<?> openSCDList) {
		OpenSCDList = openSCDList;
	}
	public String[] getOpenSCD() {
		return OpenSCD;
	}
	public void setOpenSCD(String[] openSCD) {
		OpenSCD = openSCD;
	}
	public String getCATEGORY() {
		return CATEGORY;
	}
	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}
	public String getNW_BULT_APPT_PRID() {
		return NW_BULT_APPT_PRID;
	}
	public void setNW_BULT_APPT_PRID(String nW_BULT_APPT_PRID) {
		NW_BULT_APPT_PRID = nW_BULT_APPT_PRID;
	}
	public String getABL_ATCH_CNT() {
		return ABL_ATCH_CNT;
	}
	public void setABL_ATCH_CNT(String aBL_ATCH_CNT) {
		ABL_ATCH_CNT = aBL_ATCH_CNT;
	}
	public String getDSP_MAIN_YN() {
		return DSP_MAIN_YN;
	}
	public void setDSP_MAIN_YN(String dSP_MAIN_YN) {
		DSP_MAIN_YN = dSP_MAIN_YN;
	}
	public String getDSP_MAIN_POSITION() {
		return DSP_MAIN_POSITION;
	}
	public void setDSP_MAIN_POSITION(String dSP_MAIN_POSITION) {
		DSP_MAIN_POSITION = dSP_MAIN_POSITION;
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
	public String getBDNMPATH() {
		return BDNMPATH;
	}
	public void setBDNMPATH(String bDNMPATH) {
		BDNMPATH = bDNMPATH;
	}
	public String getBD_DESC() {
		return BD_DESC;
	}
	public void setBD_DESC(String bD_DESC) {
		BD_DESC = bD_DESC;
	}
	public String getPBD_NO() {
		return PBD_NO;
	}
	public void setPBD_NO(String pBD_NO) {
		PBD_NO = pBD_NO;
	}
	public String getEMP_CD() {
		return EMP_CD;
	}
	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}
	public String getCONF_CD() {
		return CONF_CD;
	}
	public void setCONF_CD(String cONF_CD) {
		CONF_CD = cONF_CD;
	}
	public String getCONF_VAL() {
		return CONF_VAL;
	}
	public void setCONF_VAL(String cONF_VAL) {
		CONF_VAL = cONF_VAL;
	}
	public String getCONF_CD_NM() {
		return CONF_CD_NM;
	}
	public void setCONF_CD_NM(String cONF_CD_NM) {
		CONF_CD_NM = cONF_CD_NM;
	}
	public String getCONF_CD_DESC() {
		return CONF_CD_DESC;
	}
	public void setCONF_CD_DESC(String cONF_CD_DESC) {
		CONF_CD_DESC = cONF_CD_DESC;
	}
	public String getDEFAULT_VAL() {
		return DEFAULT_VAL;
	}
	public void setDEFAULT_VAL(String dEFAULT_VAL) {
		DEFAULT_VAL = dEFAULT_VAL;
	}
	public String getBD_RESOURCE_ID() {
		return BD_RESOURCE_ID;
	}
	public void setBD_RESOURCE_ID(String bD_RESOURCE_ID) {
		BD_RESOURCE_ID = bD_RESOURCE_ID;
	}
	public String getITEM_NO() {
		return ITEM_NO;
	}
	public void setITEM_NO(String iTEM_NO) {
		ITEM_NO = iTEM_NO;
	}
	public String getFILE_NM() {
		return FILE_NM;
	}
	public void setFILE_NM(String fILE_NM) {
		FILE_NM = fILE_NM;
	}
	public String getGUBUN() {
		return GUBUN;
	}
	public void setGUBUN(String gUBUN) {
		GUBUN = gUBUN;
	}
	public String getEXCLUDE_REPORT() {
		return EXCLUDE_REPORT;
	}
	public void setEXCLUDE_REPORT(String eXCLUDE_REPORT) {
		EXCLUDE_REPORT = eXCLUDE_REPORT;
	}
    
	
}
