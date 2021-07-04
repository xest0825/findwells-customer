package kr.co.fw.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.fw.base.BaseVO;

public class BoardInfoVO extends BaseVO {
	
	
    private String[] writeAutr;        // 게시판 쓰기권한
    private String[] modifyAutr;       // 게시판 수정권한
    private String[] viewAutr;         // 게시판 상세보기 권한
    private String[] deleteAutr;       // 게시글 삭제권한
    
    private ArrayList<BoardOpenVO> openList;     // 게시판 공개 조직 (사업부)
    private ArrayList<BoardOpenVO> openSCDList;  // 게시판 공개대상 조직 (사업부)
    private ArrayList<BoardCategoryVO> categoryList; // 카테고리 리스트
    private String openListStr;        // 게시판 공개대상 조직(사업부) json string
    private String openSCDListStr;     // 게시판 공개대상 조직(사업부) json string 
    private String categoryListStr;    // 카테고리 리스트 json string

    private BoardVO board;             /** 게시판 Model */
    
    
    private ArrayList<BoardAuthVO> authorityGroup; /** 권한그룹 */
    private String jsonStr;
    
    private String isNew;
    
    private List<String> DSP_MAIN_POSITION_LIST;
    
    private List<HashMap<String,String>> confList;
    
	public String[] getWriteAutr() {
		return writeAutr;
	}

	public void setWriteAutr(String[] writeAutr) {
		this.writeAutr = writeAutr;
	}

	public String[] getModifyAutr() {
		return modifyAutr;
	}

	public void setModifyAutr(String[] modifyAutr) {
		this.modifyAutr = modifyAutr;
	}

	public String[] getViewAutr() {
		return viewAutr;
	}

	public void setViewAutr(String[] viewAutr) {
		this.viewAutr = viewAutr;
	}

	public String[] getDeleteAutr() {
		return deleteAutr;
	}

	public void setDeleteAutr(String[] deleteAutr) {
		this.deleteAutr = deleteAutr;
	}

	public BoardVO getBoard() {
		return board;
	}

	public void setBoard(BoardVO board) {
		this.board = board;
	}

	public ArrayList<BoardAuthVO> getAuthorityGroup() {
		return authorityGroup;
	}

	public void setAuthorityGroup(ArrayList<BoardAuthVO> authorityGroup) {
		this.authorityGroup = authorityGroup;
	}

	public ArrayList<BoardOpenVO> getOpenList() {
		return openList;
	}

	public void setOpenList(ArrayList<BoardOpenVO> openList) {
		this.openList = openList;
	}

	public String getOpenListStr() {
		return openListStr;
	}

	public void setOpenListStr(String openListStr) {
		this.openListStr = openListStr;
	}

	public ArrayList<BoardOpenVO> getOpenSCDList() {
		return openSCDList;
	}

	public void setOpenSCDList(ArrayList<BoardOpenVO> openSCDList) {
		this.openSCDList = openSCDList;
	}

	public ArrayList<BoardCategoryVO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<BoardCategoryVO> categoryList) {
		this.categoryList = categoryList;
	}

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String listStr) {
		this.jsonStr = listStr;
	}

	public String getOpenSCDListStr() {
		return openSCDListStr;
	}

	public void setOpenSCDListStr(String openSCDListStr) {
		this.openSCDListStr = openSCDListStr;
	}

	public String getCategoryListStr() {
		return categoryListStr;
	}

	public void setCategoryListStr(String categoryListStr) {
		this.categoryListStr = categoryListStr;
	}

	public String getIsNew() {
		return isNew;
	}

	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}

	public List<String> getDSP_MAIN_POSITION_LIST() {
		return DSP_MAIN_POSITION_LIST;
	}

	public void setDSP_MAIN_POSITION_LIST(List<String> dSP_MAIN_POSITION_LIST) {
		DSP_MAIN_POSITION_LIST = dSP_MAIN_POSITION_LIST;
	}

	public List<HashMap<String, String>> getConfList() {
		return confList;
	}

	public void setConfList(List<HashMap<String, String>> confList) {
		this.confList = confList;
	}
	
}
