package kr.co.fw.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import kr.co.fw.base.BaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService extends BaseService {

	public List<HashMap<String, Object>> getItemList(BoardVO paramvo) {
		log.info("BoardService.getItemList");
		return getBoardDAO().getItemList(paramvo);
	}

	/**
	 * @desc : 게시글 조회수 수정
	 * @author : JJT
	 * @since : 2017.01.20
	 * @param : BoardItemVO
	 * @return : int
	 * @throws : Exception
	 */
	public int updateItemInqCnt(BoardItemVO paramvo) throws Exception {
		log.info("BoardMngService updateItemInqCnt");
		try {
			return getBoardDAO().updateItemInqCnt(paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @desc   : 게시글 목록 조회
	 * @author : choiys 
	 * @since  : 2016-01-20
	 * @param  : BoardItemMngVO
	 * @return : List<BoardItemVO>
	 * @throws : Exception
	 */
	public List<HashMap<String, Object>> selectBoardItemList(BoardItemVO paramvo)
			throws Exception {
		List<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		log.info("BoardMngService selectBoardItemList");
		try {
			resultList = getBoardDAO().selectBoardItemList(paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		log.info("resultList.size() = " + resultList.size());
		return resultList;
	}
	
	/**
	 * @desc   : 게시글 목록 조회
	 * @author : choiys 
	 * @since  : 2016-01-20
	 * @param  : BoardItemMngVO
	 * @return : List<BoardItemVO>
	 * @throws : Exception
	 */
	public List<BoardItemVO> selectBoardItemList2(BoardItemVO paramvo)
			throws Exception {
		List<BoardItemVO> resultList = new ArrayList<BoardItemVO>();
		log.info("BoardMngService selectBoardItemList");
		try {
			resultList = getBoardDAO().selectBoardItemList2(paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		log.info("resultList.size() = " + resultList.size());
		return resultList;
	}
	
	/**
	 * @desc   : 게시글 정보 조회
	 * @author : choiys 
	 * @since  : 2016-01-25
	 * @param  : BoardItemVO
	 * @return : BoardItemVO
	 * @throws : Exception
	 */
	public BoardItemVO selectBoardItem(BoardItemVO paramvo)
			throws Exception {
		log.info("BoardMngService selectBoardItem");
		try {
			BoardItemVO boardItemVo = new BoardItemVO();
			boardItemVo = getBoardDAO().selectBoardItem(paramvo);
			//Gson gson = new Gson();
			//boardItemVo.setBultNoListStr(gson.toJson(getBoardDAO().selectBultNoList(boardItemVo)));
			//return getBoardDAO().selectBoardItem(boardItemVo);
			return boardItemVo;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @desc 액션로그(게시판 확인)로그 입력
	 * @param SystemVO
	 * @return int
	 * @throws Exception
	 */
	public int insertReadAction(BoardVO paramvo) throws Exception {
		try {
			return getBoardDAO().insertReadAction(paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}
