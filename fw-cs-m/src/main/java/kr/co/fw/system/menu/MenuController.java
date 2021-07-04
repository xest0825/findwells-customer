package kr.co.fw.system.menu;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 메뉴 관리 컨트롤러
 *
 */
@Controller(value="MenuController")
public class MenuController 
{

	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired

	
	/**
	 * @desc 메뉴 관리 화면   
	 * @return String
	 */
	@RequestMapping(value = "/menu/menu.go", method = RequestMethod.POST)
	public String menuview() {
		return "system/menu/menu";
	}

	
	/**
	 * @brief 메뉴 리스트 트리 조회
	 * @param request
	 * @param response
	 * @param ResourcesVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/getMenuList.ajax")
	public ModelAndView getMenuList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Resultsearchvo") ResourcesVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", menuService.getMenuList(paramvo));

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief Description  :  메뉴관리 화면에서 하위 리스트 조회    
	 * @param request
	 * @param response
	 * @param ResourcesVO
	 * @return ModelAndview
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/getResources.ajax")
	public ModelAndView getResources(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Resultsearchvo") ResourcesVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", menuService.getResources(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 메뉴 리스트 조회  
	 * @param request
	 * @param response
	 * @param ResourcesVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/getMenu.ajax")
	public ModelAndView getMenu(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Resultsearchvo") ResourcesVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", menuService.getMenu(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}


	/**
	 * @brief 매뉴 저장  
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menu/insertMenu.ajax")
	public ModelAndView insertMenu(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ResourcesVO> models = (ArrayList<ResourcesVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), ResourcesVO.class);
		try {
			menuService.insertMenu(models);
			models.get(0).setROLE_ID("ROLE_SUPER");
			menuService.insertMenuRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
		
	
	/**
	 * @brief 메뉴 수정  
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menu/updateMenu.ajax")
	public ModelAndView updateMenu(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ResourcesVO> models = (ArrayList<ResourcesVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), ResourcesVO.class);
		try {
			menuService.updateMenu(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 메뉴 삭제  
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menu/deleteMenu.ajax")
	public ModelAndView deleteMenu(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ResourcesVO> models = (ArrayList<ResourcesVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), ResourcesVO.class);
		try {
			menuService.deleteMenu(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 메뉴 롤메핑 리스트 조회  
	 * @param request
	 * @param response
	 * @param ResourcesVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/getMenuRole.ajax")
	public ModelAndView getMenuRole(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Resultsearchvo") ResourcesVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {

			mv.addObject("results", menuService.getMenuRole(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}


	/**
	 * @brief 매뉴 롤메핑 저장  
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menu/insertMenuRole.ajax")
	public ModelAndView insertMenuRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ResourcesVO> models = (ArrayList<ResourcesVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), ResourcesVO.class);
		try {
			menuService.insertMenuRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
		
	
	/**
	 * @brief 메뉴롤메핑 수정  
	 * @param request
	 * @param response
	 * @param ModelAndView
	 * @return paramJObj
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menu/updateMenuRole.ajax")
	public ModelAndView updateMenuRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ResourcesVO> models = (ArrayList<ResourcesVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), ResourcesVO.class);
		try {
			menuService.updateMenuRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 메뉴 롤메핑 삭제  
	 * @param request
	 * @param response
	 * @param ModelAndView
	 * @return paramJObj
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/menu/deleteMenuRole.ajax")
	public ModelAndView deleteMenuRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ResourcesVO> models = (ArrayList<ResourcesVO>) JSONArray
				.toCollection(paramJObj.getJSONArray("models"), ResourcesVO.class);
		try {
			menuService.deleteMenuRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 롤마스터 조회  
	 * @param request
	 * @param response
	 * @param ResourcesVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/menu/getMenuRoleMaster.ajax")
	public ModelAndView getMenuRoleMaster(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Resultsearchvo") ResourcesVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", menuService.getMenuRoleMaster(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
}
