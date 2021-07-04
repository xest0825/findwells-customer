package kr.co.fw.board;

import java.util.ArrayList;

import kr.co.fw.base.BaseVO;

public class BoardMngVO extends BaseVO{
	
    /**
     * 게시판 관리
     */
	private String SRCH_GBN;              //  구분
	private String SRCH_USE_YN;           //  사용여부
	private String SRCH_WORD;             //  게시판/그룹명
    
	private ArrayList<BoardVO> boardList; // 게시판리스트
	
	private BoardInfoVO boardInfo;
	
	private String BULBD_NO;             // 게시판 번호

	public String getSRCH_GBN() {
		return SRCH_GBN;
	}

	public void setSRCH_GBN(String sRCH_GBN) {
		SRCH_GBN = sRCH_GBN;
	}

	public String getSRCH_USE_YN() {
		return SRCH_USE_YN;
	}

	public void setSRCH_USE_YN(String sRCH_USE_YN) {
		SRCH_USE_YN = sRCH_USE_YN;
	}

	public String getSRCH_WORD() {
		return SRCH_WORD;
	}

	public void setSRCH_WORD(String sRCH_WORD) {
		SRCH_WORD = sRCH_WORD;
	}

	public ArrayList<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardVO> boardList) {
		this.boardList = boardList;
	}

	public String getBULBD_NO() {
		return BULBD_NO;
	}

	public void setBULBD_NO(String bULBD_NO) {
		BULBD_NO = bULBD_NO;
	}

	public BoardInfoVO getBoardInfo() {
		return boardInfo;
	}

	public void setBoardInfo(BoardInfoVO boardInfo) {
		this.boardInfo = boardInfo;
	}
	
	
}
