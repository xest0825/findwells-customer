package kr.co.fw.contract.byenHwanMng;

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
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import kr.co.fw.common.excel.excelHandler2;
import kr.co.fw.common.util.CommUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller(value="ByenHwanController")
public class ByenHwanController {

	private static final Logger logger = LoggerFactory.getLogger(ByenHwanController.class);

	@Autowired
	ByenHwanService byenHwanService;
	
	/**
	 * @Description  : 변환율관리 페이지 이동
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/byenHwanMng.go")
	public ModelAndView byenHwanMng() throws Exception {
		ModelAndView mv = new ModelAndView("/contract/byenHwanMng/byenHwanMng");
		
		try {
			mv.addObject("User", new ByenHwanVO());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 변환율관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/selectByenHwanList.ajax")
	public ModelAndView selectByenHwanList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ByenHwanVO") ByenHwanVO parametervo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
	
		if(request.getParameter("JSON_STRING") == null){
			ByenHwanVO byenhwanvo = new ByenHwanVO();
			parametervo = byenhwanvo;
		} else {
			Gson gson = new Gson();
			parametervo = gson.fromJson(request.getParameter("JSON_STRING"), ByenHwanVO.class);
		}
		try {
			mv.addObject("results", byenHwanService.selectByenHwanList(parametervo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

    /**
	 * @Description  : 상품구분2 조회 (dropDownList)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
     */
	@RequestMapping(value = "/contract/byenHwanMng/selectByenhwanProdKind2.ajax")
	public ModelAndView selectByenhwanProdKind2(HttpServletRequest request, HttpServletResponse response, ByenHwanVO parametervo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			
			mv.addObject("results", byenHwanService.selectByenhwanProdKind2(parametervo));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		return mv;
	}

    /**
	 * @Description  : 변환율관리 마감월 조회 (dropDownList)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
     */
	@RequestMapping(value = "/contract/byenHwanMng/selectByenhwanComYm.ajax")
	public ModelAndView selectByenhwanComYm(HttpServletRequest request, HttpServletResponse response, ByenHwanVO parametervo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		try {
			
			mv.addObject("results", byenHwanService.selectByenhwanComYm(parametervo));
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 변환율관리 등록/수정 팝업
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/byenHwanRegi.pop")
	public ModelAndView byenHwanRegi(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ByenHwanVO") ByenHwanVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("/contract/byenHwanMng/byenHwanRegi");
		ByenHwanVO byenhwanvo = new ByenHwanVO();
		try {
			Gson gson = new Gson();
			byenhwanvo = gson.fromJson(request.getParameter("JSON_STRING"), ByenHwanVO.class);

			if (!byenhwanvo.getSEQ().equals("")) { // 수정
				mv.addObject("ByenHwanVO", byenHwanService.selectByenHwan(byenhwanvo));
			} else { // 등록
				mv.addObject("ByenHwanVO", paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 변환율 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/insertByenHwan.ajax")
	public ModelAndView insertByenHwan(HttpServletRequest request, @ModelAttribute(value = "ByenHwanVO") ByenHwanVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			byenHwanService.insertByenHwan(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 변환율 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/updateByenHwan.ajax")
	public ModelAndView updateByenHwan(HttpServletRequest request, @ModelAttribute(value = "ByenHwanVO") ByenHwanVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			byenHwanService.updateByenHwan(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 변환율 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/contract/byenHwanMng/deleteByenHwan.ajax")
	public ModelAndView deleteByenHwan(HttpServletRequest request, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ByenHwanVO> models = (ArrayList<ByenHwanVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ByenHwanVO.class);

		try {
			byenHwanService.deleteByenHwan(models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 변환율정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 11
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/selectByenHwanListExcel.ajax")
	public void selectByenHwanListExcel(HttpServletRequest request, HttpServletResponse response, ByenHwanVO vo) throws Exception {
		try {
			
			excelHandler2 eh = byenHwanService.selectByenHwanListExcel(vo);

			if (eh.getRowindex() == 0) {
				CommUtil.sendGenexonAlert(response, "info", "변환율관리 - 엑셀다운로드", "조회 데이타가 없습니다.");
			} else {
				String filename = "변환율관리_" + CommUtil.getCurrentDateTime() + ".xlsx";
				eh.sendResponse(response, filename);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Description  : 상품등록 -> 상품군2 change 이벤트 발생시 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/byenHwanMng/selectProductByenHwan.ajax")
	public ModelAndView selectProductByenHwan(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ByenHwanVO") ByenHwanVO parametervo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			mv.addObject("results", byenHwanService.selectProductByenHwan(parametervo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}
	
}
