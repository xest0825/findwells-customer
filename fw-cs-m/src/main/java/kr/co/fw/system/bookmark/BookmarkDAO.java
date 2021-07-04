package kr.co.fw.system.bookmark;
/*
 * Copyright GENEXON (c) 2014.
 */


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.system.menu.ResourcesVO;
import kr.co.fw.base.BaseDAO;
import kr.co.fw.system.security.model.CustomUser;
import kr.co.fw.system.security.model.CustomUserDetailsHelper;

/**
 * 즐겨찾기 DAO
 */
@Repository(value = "BookmarkDAO")
public class BookmarkDAO extends BaseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BookmarkDAO.class);
	
	private static final String SQL_PREFIX = "Bookmark.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	/**
	 * @description 즐겨찾기 리스트를 조회한다.
	 * @param BookmarkVO
	 * @return List<ResourcesVO> 
	 * @throws Exception
	 */
	public List<ResourcesVO> getBookmarkList(BookmarkVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "getBookmarkList", paramvo);
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
			return sqlSession.selectOne(SQL_PREFIX + "checkBookmark", paramvo);
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
			if (paramvo.getUSE_YN().equals("N")) {
				result = sqlSession.insert(SQL_PREFIX + "insertBookmark", paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @description 즐겨찾기를 수정한다
	 * @param BookmarkVO
	 * @return integer
	 * @throws Exception
	 */
	public int modifyBookmark(BookmarkVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "modifyBookmark", paramvo);
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
			CustomUser AUTHUSERVO = (CustomUser) CustomUserDetailsHelper.getAuthenticatedUser();
			paramvo.setEMP_CD(AUTHUSERVO.getUser_id());
			result = sqlSession.delete(SQL_PREFIX + "deleteBookmark", paramvo);
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
			CustomUser AUTHUSERVO = (CustomUser) CustomUserDetailsHelper.getAuthenticatedUser();
			paramvo.setEMP_CD(AUTHUSERVO.getUser_id());
			return sqlSession.selectOne(SQL_PREFIX + "selectBookmark", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}
