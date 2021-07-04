package kr.co.fw.system.role;


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
 * 권한  관리
 * metaDataSource 사용(메모리)
 */
@Controller(value="RoleController")
public class RoleController 
{

	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;


	/**
	 * @brief 권한 관리 화면   
	 * @return string
	 */
	@RequestMapping(value = "/role/role.go", method = RequestMethod.POST)
	public String roleview() {
		return "system/role/role";
	}

	/**
	 * @brief 권한 리스트 조회  
	 * @param request
	 * @param response
	 * @param RoleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/role/getRoleList.ajax")
	public ModelAndView getRoleList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Rolevo") RoleVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", roleService.getRoleList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 권한 저장  
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndview
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/role/insertRole.ajax")
	public ModelAndView insertRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<RoleVO> models = (ArrayList<RoleVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				RoleVO.class);

		try {
			roleService.insertRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
		
	
	/**
	 * @brief 권한 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndview
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/role/updateRole.ajax")
	public ModelAndView updateRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<RoleVO> models = (ArrayList<RoleVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				RoleVO.class);

		try {
			roleService.updateRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 권한 삭제 
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/role/deleteRole.ajax")
	public ModelAndView deleteRole(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<RoleVO> models = (ArrayList<RoleVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				RoleVO.class);

		try {
			roleService.deleteRole(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 권한 계층조회 
	 * @param request
	 * @param response
	 * @param RoleVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/role/getRoleHieraList.ajax")
	public ModelAndView getRoleHieraList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Rolevo") RoleVO paramvo) throws Exception {

		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", roleService.getRoleHieraList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 권한 계층 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/role/insertRoleHiera.ajax")
	public ModelAndView insertRoleHiera(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<RoleVO> models = (ArrayList<RoleVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				RoleVO.class);

		try {
			roleService.insertRoleHiera(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	

	/**
	 * @brief 권한 계층 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/role/updateRoleHiera.ajax")
	public ModelAndView updateRoleHiera(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<RoleVO> models = (ArrayList<RoleVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				RoleVO.class);

		try {
			roleService.updateRoleHiera(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	
	/**
	 * @brief 권한 계층 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/role/deleteRoleHiera.ajax")
	public ModelAndView deleteRoleHiera(HttpServletRequest request, HttpServletResponse response,
			@RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<RoleVO> models = (ArrayList<RoleVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"),
				RoleVO.class);

		try {
			roleService.deleteRoleHiera(models);
			mv.addObject("results", models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	

	/**
	 * @brief 해당 권한 메뉴트리 조회
	 * @param request
	 * @param response
	 * @param RoleVO
	 * @return ModelAndView
	 * @throws Exception
	 */	
	@RequestMapping(value = "/role/getRoleTree.ajax")
	public ModelAndView getRoleTree(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute(value = "Rolevo") RoleVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		try {
			mv.addObject("results", roleService.getRoleTree(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
}
