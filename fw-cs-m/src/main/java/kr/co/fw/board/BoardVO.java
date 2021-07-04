package kr.co.fw.board;

import java.util.ArrayList;

import kr.co.fw.base.BaseVO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    
    private String ACTIONGUBUN;
    
    
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
    

    
	
}
