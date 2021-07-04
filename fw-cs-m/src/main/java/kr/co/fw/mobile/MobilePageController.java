package kr.co.fw.mobile;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fw.board.BoardItemVO;
import kr.co.fw.board.BoardService;
import kr.co.fw.board.BoardVO;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.contract.ContractVO;
import kr.co.fw.customer.CustomerVO;
import kr.co.fw.insa.InSaVO;
import kr.co.fw.insa.InsaService;

/**
 * 메인
 */
@Controller(value = "MobilePageController")
public class MobilePageController {

	private static final Logger logger = LoggerFactory.getLogger(MobilePageController.class);

	@Autowired
	private BoardService boardMngService;

	@Autowired
	private InsaService insaService;

	/**
	 * @description 모바일 첫 페이지로 이동
	 */
	@RequestMapping(value = "/mobile/index.go")
	public ModelAndView index(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/index.go 시작");
		ModelAndView mav = new ModelAndView("old/index");
		return mav;
	}

	/**
	 * @description 모바일 첫 페이지로 이동
	 */
	@RequestMapping(value = "/mobile/index2.go")
	public ModelAndView index2(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/index2.go 시작");
		ModelAndView mav = new ModelAndView("old/index2");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/achievement.go")
	public ModelAndView achievement(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/achievement.go 시작");
		ModelAndView mav = new ModelAndView("old/achievement");
		mav.addObject("menu_name", "업적조회");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/achievement_detail.go")
	public ModelAndView achievement_detail(HttpServletRequest req, ContractVO paramvo) throws Exception {
		logger.debug("/mobile/achievement_detail.go 시작");
		ModelAndView mav = new ModelAndView("old/achievement_detail");
		mav.addObject("AchievementVO", paramvo);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/contract.go")
	public ModelAndView contract(HttpServletRequest req, ContractVO paramvo) throws Exception {
		logger.debug("/mobile/contract.go 시작");
		ModelAndView mav = new ModelAndView("old/contract");
		mav.addObject("menu_name", "보유계약");
		mav.addObject("User", paramvo);
		if (CommUtil.isEmpty(paramvo.getPage())) {
			paramvo.setPage("1");
		}
		mav.addObject("ContractVO", paramvo);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/contract_detail.go")
	public ModelAndView contract_detail(HttpServletRequest req, ContractVO paramvo) throws Exception {
		logger.debug("/mobile/contract_detail.go 시작");
		ModelAndView mav = new ModelAndView("old/contract_detail");
		mav.addObject("ContractVO", paramvo);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/data.go")
	public ModelAndView data(HttpServletRequest req, BoardVO boardVO) throws Exception {
		logger.debug("/mobile/data.go 시작");
		ModelAndView mav = new ModelAndView("old/data");
		mav.addObject("menu_name", "상품자료실");
		if (CommUtil.isEmpty(boardVO.getPage())) {
			boardVO.setPage("1");
		}
		mav.addObject("BoardVO", boardVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/data_detail.go")
	public ModelAndView data_detail(HttpServletRequest req, BoardItemVO boardItemVO) throws Exception {
		logger.debug("/mobile/data_detail.go 시작");
		ModelAndView mav = new ModelAndView("/mobile/data_detail");

		// 조회수 설정
		boardMngService.updateItemInqCnt(boardItemVO);

		BoardItemVO paramvo = new BoardItemVO();
		paramvo = boardMngService.selectBoardItem(boardItemVO);
		paramvo.setDATA_DCD("V");

		// 액션로그 설정
		BoardVO sysvo = new BoardVO();
		sysvo.setBD_NO(paramvo.getBD_NO());
		sysvo.setITEM_NO(paramvo.getITEM_NO());
		sysvo.setFILE_NM(paramvo.getTITL());
		sysvo.setACTIONGUBUN(paramvo.getAUTHOR_NM());
		boardMngService.insertReadAction(sysvo);

		mav.addObject("BoardItemVO", boardItemVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/data2.go")
	public ModelAndView data2(HttpServletRequest req, BoardVO boardVO) throws Exception {
		logger.debug("/mobile/data2.go 시작");
		ModelAndView mav = new ModelAndView("old/data2");
		mav.addObject("menu_name", "교육자료실");
		if (CommUtil.isEmpty(boardVO.getPage())) {
			boardVO.setPage("1");
		}
		mav.addObject("BoardVO", boardVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/data_detail2.go")
	public ModelAndView data_detail2(HttpServletRequest req, BoardItemVO boardItemVO) throws Exception {
		logger.debug("/mobile/data_detail2.go 시작");
		ModelAndView mav = new ModelAndView("old/data_detail2");

		// 조회수 설정
		boardMngService.updateItemInqCnt(boardItemVO);

		BoardItemVO paramvo = new BoardItemVO();
		paramvo = boardMngService.selectBoardItem(boardItemVO);
		paramvo.setDATA_DCD("V");

		// 액션로그 설정
		BoardVO sysvo = new BoardVO();
		sysvo.setBD_NO(paramvo.getBD_NO());
		sysvo.setITEM_NO(paramvo.getITEM_NO());
		sysvo.setFILE_NM(paramvo.getTITL());
		sysvo.setACTIONGUBUN(paramvo.getAUTHOR_NM());
		boardMngService.insertReadAction(sysvo);

		mav.addObject("BoardItemVO", boardItemVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/help.go")
	public ModelAndView help(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/help.go 시작");
		ModelAndView mav = new ModelAndView("old/help");
		mav.addObject("menu_name", "헬프데스크");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/insco.go")
	public ModelAndView insco(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/insco.go 시작");
		ModelAndView mav = new ModelAndView("old/insco");
		mav.addObject("menu_name", "원수사");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/login.go")
	public ModelAndView login(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/login.go 시작");
		ModelAndView mav = new ModelAndView("old/login");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/member.go")
	public ModelAndView member(HttpServletRequest req, CustomerVO paramvo) throws Exception {
		logger.debug("/mobile/member.go 시작");
		ModelAndView mav = new ModelAndView("old/member");
		mav.addObject("menu_name", "고객조회");
		if (CommUtil.isEmpty(paramvo.getPage())) {
			paramvo.setPage("1");
		}
		mav.addObject("CustomerVO", paramvo);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/member_detail.go")
	public ModelAndView member_detail(HttpServletRequest req, CustomerVO paramvo) throws Exception {
		logger.debug("/mobile/member_detail.go 시작");
		ModelAndView mav = new ModelAndView("old/member_detail");
		mav.addObject("CustomerVO", paramvo);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/notice.go")
	public ModelAndView notice(HttpServletRequest req, BoardVO boardVO) throws Exception {
		logger.debug("/mobile/notice.go 시작");
		ModelAndView mav = new ModelAndView("old/notice");
		mav.addObject("menu_name", "게시판");
		if (CommUtil.isEmpty(boardVO.getPage())) {
			boardVO.setPage("1");
		}
		mav.addObject("BoardVO", boardVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/notice_detail.go")
	public ModelAndView notice_detail(HttpServletRequest req, BoardItemVO boardItemVO) throws Exception {
		logger.debug("/mobile/notice_detail.go 시작");
		ModelAndView mav = new ModelAndView("old/notice_detail");
		// TBBD_READ_USER 에 인서트

		// 조회수 설정
		boardMngService.updateItemInqCnt(boardItemVO);

		BoardItemVO paramvo = new BoardItemVO();
		paramvo = boardMngService.selectBoardItem(boardItemVO);
		paramvo.setDATA_DCD("V");

		// 액션로그 설정
		BoardVO sysvo = new BoardVO();
		sysvo.setBD_NO(paramvo.getBD_NO());
		sysvo.setITEM_NO(paramvo.getITEM_NO());
		sysvo.setFILE_NM(paramvo.getTITL());
		sysvo.setACTIONGUBUN(paramvo.getAUTHOR_NM());
		boardMngService.insertReadAction(sysvo);

		mav.addObject("BoardItemVO", boardItemVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/report.go")
	public ModelAndView report(HttpServletRequest req, BoardVO boardVO) throws Exception {
		logger.debug("/mobile/report.go 시작");
		ModelAndView mav = new ModelAndView("old/report");
		mav.addObject("menu_name", "리포트");
		if (CommUtil.isEmpty(boardVO.getPage())) {
			boardVO.setPage("1");
		}
		mav.addObject("BoardVO", boardVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/report_detail.go")
	public ModelAndView report_detail(HttpServletRequest req, BoardItemVO boardItemVO) throws Exception {
		logger.debug("/mobile/report_detail.go 시작");
		ModelAndView mav = new ModelAndView("old/report_detail");
		// TBBD_READ_USER 에 인서트

		// 조회수 설정
		boardMngService.updateItemInqCnt(boardItemVO);

		BoardItemVO paramvo = new BoardItemVO();
		paramvo = boardMngService.selectBoardItem(boardItemVO);
		paramvo.setDATA_DCD("V");

		// 액션로그 설정
		BoardVO sysvo = new BoardVO();
		sysvo.setBD_NO(paramvo.getBD_NO());
		sysvo.setITEM_NO(paramvo.getITEM_NO());
		sysvo.setFILE_NM(paramvo.getTITL());
		sysvo.setACTIONGUBUN(paramvo.getAUTHOR_NM());
		boardMngService.insertReadAction(sysvo);

		mav.addObject("BoardItemVO", boardItemVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/user_report.go")
	public ModelAndView user_report(HttpServletRequest req, BoardItemVO boardItemVO) throws Exception {
		logger.debug("/mobile/user_report.go 시작");
		ModelAndView mav = new ModelAndView("old/user_report");
		// TBBD_READ_USER 에 인서트

		String sharer = boardItemVO.getSHARER();
		InSaVO insavo = new InSaVO();
		insavo.setMB_ID("YNG");
		insavo.setEMP_CD(sharer);
		Map<String, Object> hmap = new HashMap<String, Object>();
		hmap = insaService.selectEmpInfo(insavo);
		boardItemVO.setSHARER_NM((String) hmap.get("EMP_NM"));
		boardItemVO.setSHARER_TEL_NO((String) hmap.get("HPNO"));
		boardItemVO.setSHARER_PROFILE_PATH((String) hmap.get("FILE_NAME"));

		mav.addObject("BoardItemVO", boardItemVO);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/password_enter.go")
	public ModelAndView password_enter(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/password_enter.go 시작");
		ModelAndView mav = new ModelAndView("old/password_enter");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/password_find.go")
	public ModelAndView password_find(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/password_find.go 시작");
		ModelAndView mav = new ModelAndView("old/password_find");
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/password_set.go")
	public ModelAndView password_set(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/password_set.go 시작");
		ModelAndView mav = new ModelAndView("old/password_set");
		return mav;
	}

	/**
	 * @description 인사관리
	 */
	@RequestMapping(value = "/mobile/personnel.go")
	public ModelAndView personnel(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/personnel.go 시작");
		ModelAndView mav = new ModelAndView("old/personnel");
		mav.addObject("menu_name", "인사관리");
		return mav;
	}

	/**
	 * @description 인사 상세
	 */
	@RequestMapping(value = "/mobile/personnel_detail.go")
	public ModelAndView personnel_detail(HttpServletRequest req, InSaVO paramvo) throws Exception {
		logger.debug("/mobile/personnel_detail.go 시작");
		ModelAndView mav = new ModelAndView("old/personnel_detail");
		mav.addObject("InSaVO", paramvo);
		return mav;
	}

	/**
	 * @description
	 */
	@RequestMapping(value = "/mobile/schedule.go")
	public ModelAndView schedule(HttpServletRequest req) throws Exception {
		logger.debug("/mobile/schedule.go 시작");
		ModelAndView mav = new ModelAndView("old/schedule");
		mav.addObject("menu_name", "일정관리");
		return mav;
	}

}
