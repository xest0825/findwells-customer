package kr.co.fw.contract.productGroup;

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

@Controller(value="ProductGroupController")
public class ProductGroupController {

	private static final Logger logger = LoggerFactory.getLogger(ProductGroupController.class);

	@Autowired
	ProductGroupService productGroupService;
	
	/**
	 * @Description  : 상품군 페이지 이동
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 07
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productGroupMng/productGroupMng.go")
	public ModelAndView productGroupMng() throws Exception {
		ModelAndView mv = new ModelAndView("/contract/productGroupMng/productGroupMng");
		
		try {
			mv.addObject("User", new ProductGroupVO());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상푼군관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productGroupMng/selectProductGroupList.ajax")
	public ModelAndView selectProductGroupList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ProductGroupVO") ProductGroupVO parametervo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
	
		if(request.getParameter("JSON_STRING") == null){
			ProductGroupVO productGroupvo = new ProductGroupVO();
			parametervo = productGroupvo;
		} else {
			Gson gson = new Gson();
			parametervo = gson.fromJson(request.getParameter("JSON_STRING"), ProductGroupVO.class);
		}
		try {
			mv.addObject("results", productGroupService.selectProductGroupList(parametervo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품군관리 등록/수정 팝업
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productGroupMng/productGroupRegi.pop")
	public ModelAndView productGroupRegi(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ProductGroupVO") ProductGroupVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("/contract/productGroupMng/productGroupRegi");
		ProductGroupVO productGroupvo = new ProductGroupVO();
		try {
			Gson gson = new Gson();
			productGroupvo = gson.fromJson(request.getParameter("JSON_STRING"), ProductGroupVO.class);

			if (!productGroupvo.getSEQ().equals("")) { // 수정
				mv.addObject("ProductGroupVO", productGroupService.selectProductGroup(productGroupvo));
			} else { // 등록
				mv.addObject("ProductGroupVO", paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품군 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productGroupMng/insertProductGroup.ajax")
	public ModelAndView insertProductGroup(HttpServletRequest request, @ModelAttribute(value = "ProductGroupVO") ProductGroupVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			productGroupService.insertProductGroup(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품군 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productGroupMng/updateProductGroup.ajax")
	public ModelAndView updateProductGroup(HttpServletRequest request, @ModelAttribute(value = "ProductGroupVO") ProductGroupVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			productGroupService.updateProductGroup(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품군 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/contract/productGroupMng/deleteProductGroup.ajax")
	public ModelAndView deleteProductGroup(HttpServletRequest request, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ProductGroupVO> models = (ArrayList<ProductGroupVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ProductGroupVO.class);

		try {
			productGroupService.deleteProductGroup(models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품군정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/ProductGroupMng/selectProductGroupListExcel.ajax")
	public void selectProductGroupListExcel(HttpServletRequest request, HttpServletResponse response, ProductGroupVO vo) throws Exception {
		try {
			
			excelHandler2 eh = productGroupService.selectProductGroupListExcel(vo);

			if (eh.getRowindex() == 0) {
				CommUtil.sendGenexonAlert(response, "info", "상품군관리 - 엑셀다운로드", "조회 데이타가 없습니다.");
			} else {
				String filename = "상품군관리_" + CommUtil.getCurrentDateTime() + ".xlsx";
				eh.sendResponse(response, filename);
			}

		} catch (Exception e) {
			throw e;
		}
	}

}
