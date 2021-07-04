package kr.co.fw.board;

import java.util.ArrayList;

import kr.co.fw.base.BaseVO;

public class BoardItemMngVO extends BaseVO {
	
	private String SRCH_CTGR;
	private String SRCH_TYPE;
	private String SRCH_WORD;
	
	ArrayList<BoardItemVO> boardItemList;
	
	BoardItemVO boardItem;
	
	private String BD_NO;
	private String ITEM_NO;
	private String EMP_CD;
	private String MENU_GBN;
	
	
	
	public String getSRCH_CTGR() {
		return SRCH_CTGR;
	}
	public void setSRCH_CTGR(String sRCH_CTGR) {
		SRCH_CTGR = sRCH_CTGR;
	}
	public String getSRCH_TYPE() {
		return SRCH_TYPE;
	}
	public void setSRCH_TYPE(String sRCH_TYPE) {
		SRCH_TYPE = sRCH_TYPE;
	}
	public String getSRCH_WORD() {
		return SRCH_WORD;
	}
	public void setSRCH_WORD(String sRCH_WORD) {
		SRCH_WORD = sRCH_WORD;
	}
	public ArrayList<BoardItemVO> getBoardItemList() {
		return boardItemList;
	}
	public void setBoardItemList(ArrayList<BoardItemVO> boardItemList) {
		this.boardItemList = boardItemList;
	}
	public BoardItemVO getBoardItem() {
		return boardItem;
	}
	public void setBoardItem(BoardItemVO boardItem) {
		this.boardItem = boardItem;
	}
	public String getBD_NO() {
		return BD_NO;
	}
	public void setBD_NO(String bD_NO) {
		BD_NO = bD_NO;
	}
	public String getITEM_NO() {
		return ITEM_NO;
	}
	public void setITEM_NO(String iTEM_NO) {
		ITEM_NO = iTEM_NO;
	}
	public String getEMP_CD() {
		return EMP_CD;
	}
	public void setEMP_CD(String eMP_CD) {
		EMP_CD = eMP_CD;
	}
	public String getMENU_GBN() {
		return MENU_GBN;
	}
	public void setMENU_GBN(String mENU_GBN) {
		MENU_GBN = mENU_GBN;
	}
	
}
