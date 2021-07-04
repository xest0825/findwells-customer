package kr.co.fw.system.bookmark;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fw.system.menu.ResourcesVO;

/**
 * 즐겨찾기 서비스
 */
@Service(value = "BookmarkService")
public class BookmarkService {

	private static final Logger logger = LoggerFactory.getLogger(BookmarkService.class);
	
	@Autowired
	private BookmarkDAO dao;
	
	
	/**
	 * @description 즐겨찾기 리스트를 조회한다.
	 * @param BookmarkVO
	 * @return List<ResourcesVO> 
	 * @throws Exception
	 */
	public List<ResourcesVO> getBookmarkList(BookmarkVO paramvo) throws Exception {

		try {
			return dao.getBookmarkList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	
	/**
	 * @description 즐겨찾기 유무 
	 * @param BookmarkVO
	 * @return BookmarkVO
	 * @throws Exception
	 */
	public BookmarkVO checkBookmark(BookmarkVO paramvo) throws Exception {

		try {
			return dao.checkBookmark(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	
	/**
	 * @description 즐겨찾기를 입력한다
	 * @param BookmarkVO
	 * @return integer
	 * @throws Exception
	 */
	public int insertBookmark(BookmarkVO paramvo) throws Exception {
		int result = 0;

		try {
			result = dao.insertBookmark(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * 즐겨찾기를 수정한다
	 * @param vo
	 * @return result
	 * @throws Exception
	 */
	public int modifyBookmark(BookmarkVO paramvo) throws Exception {
		int result = 0;

		try {
			result = dao.modifyBookmark(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @description 즐겨찾기를 삭제한다
	 * @param BookmarkVO
	 * @return integer
	 * @throws Exception
	 */
	public int deleteBookmark(BookmarkVO paramvo) throws Exception {
		int result = 0;

		try {
			result = dao.deleteBookmark(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @description 즐겨찾기를 조회한다
	 * @param BookmarkVO
	 * @return BookmarkVO
	 * @throws Exception
	 */
	public BookmarkVO selectBookmark(BookmarkVO paramvo) throws Exception {
		try {
			return dao.selectBookmark(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
}
