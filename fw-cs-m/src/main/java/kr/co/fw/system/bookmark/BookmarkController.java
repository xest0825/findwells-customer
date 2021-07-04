package kr.co.fw.system.bookmark;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 즐겨찾기 관리
 */
@Controller(value="BookmarkController")
public class BookmarkController 
{
	private static final Logger logger = LoggerFactory.getLogger(BookmarkController.class);
	
	@Autowired
	private BookmarkService BookmarkService;


	/**
	 * @description 즐겨찾기 유무
	 * @param BookmarkVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/checkBookmark.ajax")
	public ModelAndView checkBookmark(HttpServletRequest request, HttpServletResponse response, BookmarkVO vo)
			throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			mv.addObject("BookmarkVO", BookmarkService.checkBookmark(vo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @description 즐겨찾기 입력
	 * @param BookmarkVO
	 * @return ModelAndView 
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/insertBookmark.ajax")
	public ModelAndView insertBookmark(HttpServletRequest request, HttpServletResponse response, BookmarkVO vo)
			throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			BookmarkService.insertBookmark(vo);
			mv.addObject("BookmarkVO", BookmarkService.checkBookmark(vo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @description 즐겨찾기 수정
	 * @param BookmarkVO
	 * @return ModelAndView 
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/modifyBookmark.ajax")
	public ModelAndView modifyBookmark(HttpServletRequest request, HttpServletResponse response, BookmarkVO vo)
			throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			BookmarkService.modifyBookmark(vo);
			mv.addObject("BookmarkVO", BookmarkService.checkBookmark(vo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @description 즐겨찾기 삭제
	 * @param BookmarkVO
	 * @return ModelAndView 
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/deleteBookmark.ajax")
	public ModelAndView insertMenuRole(HttpServletRequest request, HttpServletResponse response, BookmarkVO vo)
			throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			BookmarkService.deleteBookmark(vo);
			mv.addObject("BookmarkVO", BookmarkService.checkBookmark(vo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @description 즐겨찾기 리스트
	 * @param BookmarkVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/getBookmarkList.ajax")
	public ModelAndView getBookmarkList(HttpServletRequest request, HttpServletResponse response, BookmarkVO vo)
			throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			mv.addObject("BOOKMARK_LIST", BookmarkService.getBookmarkList(vo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @desc 즐겨찾기 팝업
	 * @return ModelAndView
	 * @param BookmarkVO
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/bookmarkPopup.pop")
	public ModelAndView bookmarkPopup(HttpServletRequest request, HttpServletResponse response, BookmarkVO vo)
			throws Exception {
		ModelAndView mv = new ModelAndView("system/menu/bookmarkPopup");
		try {
			mv.addObject("BookmarkVO", BookmarkService.selectBookmark(vo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
			
}
