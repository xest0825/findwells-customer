package kr.co.fw.common.insco;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.co.fw.common.excel.excelHandler2;
import kr.co.fw.common.util.CommUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 원수사관리 InscoController
 */
@Controller(value = "InscoController")
public class InscoController {

	private static final Logger logger = LoggerFactory.getLogger(InscoController.class);

	@Autowired
	private InscoService inscoService;

	/**
	 * @Description  : 원수사관리 페이지 이동
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 28
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/insco/inscoMng.go")
	public ModelAndView inscoMng(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/contract/insco/inscoMng");
		return mv;
	}
	
	/**
	 * @Description  : 원수사등록/수정 팝업
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/insco/regiInscoPop.pop")
	public ModelAndView regiInscoPop(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "InscoVO") InscoVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("/contract/insco/regiInscoPop");
		try {
			if (request.getParameter("JSON_STRING") != null && !request.getParameter("JSON_STRING").equals("null")) {
				Gson gson = new Gson();
				paramvo = gson.fromJson(request.getParameter("JSON_STRING"), InscoVO.class);
				mv.addObject("InscoVO", paramvo);
			} else {
				mv.addObject("InscoVO", paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	/**
	 * @Description  : 원수사 등록/수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value="/contract/insco/insertOrUpdateInsco.ajax")
	public ModelAndView insertOrUpdateInsco(MultipartHttpServletRequest Request, HttpServletResponse response , @ModelAttribute(value = "InscoVO") InscoVO paramvo){
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			inscoService.insertOrUpdateInsco(Request ,paramvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * @Description  : 원수사관리 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : 
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/insco/selectInscoListExcel.ajax")
	public void getInscoListExcel(HttpServletRequest request, HttpServletResponse response, InscoVO vo) throws Exception {
		try {
			
			excelHandler2 eh =  inscoService.selectInscoListExcel(vo); 

			if (eh.getRowindex() == 0) {
				CommUtil.sendGenexonAlert(response, "info", "원수사관리 - 엑셀다운로드", "조회 데이타가 없습니다.");
			} else {
				String filename = "원수사관리_" + CommUtil.getCurrentDateTime() + ".xlsx";
				eh.sendResponse(response, filename);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	/**
	 * @brief 원수사 조회
	 * @param request
	 * @param response
	 * @param InscoVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/insco/selectInscoList.ajax")
	public ModelAndView selectInscoList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "InscoVO") InscoVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");

		if(request.getParameter("JSON_STRING") != null) {
			Gson gson = new Gson();
			paramvo = gson.fromJson(request.getParameter("JSON_STRING"), InscoVO.class);
		}
		try {
			mv.addObject("results", inscoService.selectInscoList(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 원수사 저장
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insco/insertInsco.ajax")
	public ModelAndView insertInsco(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<InscoVO> models = (ArrayList<InscoVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), InscoVO.class);
		try {
			
			mv.addObject("results", inscoService.insertInsco(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 원수사 수정
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insco/updateInsco.ajax")
	public ModelAndView updateInsco(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<InscoVO> models = (ArrayList<InscoVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), InscoVO.class);
		try {
			
			mv.addObject("results", inscoService.updateInsco(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}

	
	/**
	 * @brief 원수사 삭제
	 * @param request
	 * @param response
	 * @param paramJObj
	 * @return ModelAndView
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insco/deleteInsco.ajax")
	public ModelAndView deleteInsco(HttpServletRequest request, HttpServletResponse response, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<InscoVO> models = (ArrayList<InscoVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), InscoVO.class);
		try {
			
			mv.addObject("results", inscoService.deleteInsco(models));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return mv;
	}
	
	/**
	 * ddcode INSCO_CD(원수사코드) 리스트 조회
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param InscoVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/insco/selectInscoCdList.ajax")
	public ModelAndView selectInscoCdList(HttpServletRequest request, HttpServletResponse response, InscoVO inscoVO) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", inscoService.selectInscoCdList(inscoVO));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}

}
