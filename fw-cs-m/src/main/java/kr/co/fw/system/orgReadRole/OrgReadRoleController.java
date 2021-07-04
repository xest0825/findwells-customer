package kr.co.fw.system.orgReadRole;
/*
 * Copyright GENEXON (c) 2014.
 */

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fw.insa.InSaVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 권한 관리
 *
 */
@Controller(value = "ScdReadRoleController")
public class OrgReadRoleController {

	private static final Logger logger = LoggerFactory.getLogger(OrgReadRoleController.class);

	@Autowired
	private OrgReadRoleService scdReadRoleService;

	/**
	 * @brief 조회 권한 관리 화면
	 * @return String
	 */
	@RequestMapping(value = "/scdReadRole/scdReadRole.go", method = RequestMethod.POST)
	public String scdReadRoleview() {
		return "system/scdReadRole/scdReadRole";
	}

	/**
	 * @brief 조직조회 권한 트리뷰 조회
	 * @param request
	 * @param response
	 * @param OrgReadRoleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/scdReadRole/getScdReadRoleTree.ajax")
	public ModelAndView getScdReadRoleTree(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ScdReadRoleVO") OrgReadRoleVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {

			mv.addObject("results", scdReadRoleService.getScdReadRoleTree(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @brief 조직조회 권한 등록
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/scdReadRole/insertScdReadRole.ajax")
	public ModelAndView insertScdReadRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {

		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<OrgReadRoleVO> models = (ArrayList<OrgReadRoleVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), OrgReadRoleVO.class);

		try {
			scdReadRoleService.insertScdReadRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @brief 조직조회 권한 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/scdReadRole/deleteScdReadRole.ajax")
	public ModelAndView deleteScdReadRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<OrgReadRoleVO> models = (ArrayList<OrgReadRoleVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), OrgReadRoleVO.class);
		try {
			scdReadRoleService.deleteScdReadRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @brief 인사정보조회
	 * @param request
	 * @param response
	 * @param InSaVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/scdReadRole/selectInsaList.ajax")
	public ModelAndView selectInsaList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "InSaVO") InSaVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", scdReadRoleService.selectInsaList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @brief 사용자 권한매핑 목록 조회
	 * @param request
	 * @param response
	 * @param OrgReadRoleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/scdReadRole/getUserRoleMapList.ajax")
	public ModelAndView getUserRoleMapList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "ScdReadRoleVO") OrgReadRoleVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", scdReadRoleService.getUserRoleMapList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @brief 사용자 권한매핑 등록
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/scdReadRole/insertUserRoleMap.ajax")
	public ModelAndView insertUserRoleMap(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<OrgReadRoleVO> models = (ArrayList<OrgReadRoleVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), OrgReadRoleVO.class);
		try {
			scdReadRoleService.insertUserRoleMap(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @brief 사용자 권한매핑 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/scdReadRole/deleteUserRoleMap.ajax")
	public ModelAndView deleteUserRoleMap(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<OrgReadRoleVO> models = (ArrayList<OrgReadRoleVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), OrgReadRoleVO.class);
		try {
			scdReadRoleService.deleteUserRoleMap(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

}
