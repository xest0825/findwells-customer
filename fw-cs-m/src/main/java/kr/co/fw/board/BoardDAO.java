package kr.co.fw.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAO extends BaseDAO {

	private static final String SQL_PREFIX = "Board.";

	public List<HashMap<String, Object>> getItemList(BoardVO paramvo) {
		log.info("BoardDAO.getItemList");
		return getSqlSession().selectList(getBoardMapper() + "getItemList", paramvo);
	}

	/**
	 * @desc : 게시글 조회수 수정
	 * @author : ChoiYS
	 * @since : 2016-01-26
	 * @param : BoardItemVO
	 * @return : int
	 * @throws : Exception
	 */
	public int updateItemInqCnt(BoardItemVO paramvo) throws Exception {
		log.info("BoardMngDAO updateItemInqCnt");
		int result = 0;
		try {
			result = getSqlSession().update(SQL_PREFIX + "updateItemInqCnt", paramvo);
			log.info("updateBoard result : " + result);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return result;

	}
	
	/**
	 * @desc   : 게시글 목록 조회 
	 * @author : choiys
	 * @date   : 2015-01-21
	 * @param  : BoardItemMngVO
	 * @return : List<BoardItemVO>
	 * @throws : Exception
	 */
	public List<BoardItemVO> selectBoardItemList(BoardItemMngVO paramvo) throws Exception {
		log.info("BoardMngDAO selectBoardItemList");
		List<BoardItemVO> resultList = new ArrayList<BoardItemVO>();
		try {
			resultList = getSqlSession().selectList(SQL_PREFIX + "selectBoardItemList", paramvo);
			log.info("selectBoardItemList resultList size : " + resultList.size());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return resultList;
	}
	
	/**
	 * @desc   : 게시글 정보 조회
	 * @author : choiys
	 * @since  : 2015-01-25
	 * @param  : BoardItemVO
	 * @return : BoardItemVO
	 * @throws : Exception
	 */
	public BoardItemVO selectBoardItem(BoardItemVO paramvo) throws Exception {
		log.info("BoardMngDAO selectBoardItem");

		try {
			BoardItemVO boarditemvo = new BoardItemVO();
			boarditemvo = getSqlSession().selectOne(SQL_PREFIX + "selectBoardItem", paramvo);
			return boarditemvo;

		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

	}
	
	/**
	 * @desc   : 게시글번호 목록 조회
	 * @author : choiys
	 * @since  : 2015-01-25
	 * @param  : BoardItemVO
	 * @return : HashMap<String, Object>
	 * @throws : Exception
	 */
	public List<HashMap<String, Object>> selectBultNoList(BoardItemVO paramvo) throws Exception {
		log.info("BoardMngDAO selectBultNoList");
		try {
			return getSqlSession().selectList(SQL_PREFIX + "selectBultNoList", paramvo);
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
	 **/
	public int insertReadAction(BoardVO paramvo) throws Exception {
		try {
			return getSqlSession().insert(SQL_PREFIX + "insertReadAction", paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
}
