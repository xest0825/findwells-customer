package kr.co.fw.contract.product;

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

@Controller(value="ProductController")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	/**
	 * @Description  : 상품 페이지 이동
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 11
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/productMng.go")
	public ModelAndView productMng() throws Exception {
		ModelAndView mv = new ModelAndView("/contract/productMng/productMng");
		
		try {
			mv.addObject("User", new ProductVO());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/selectProductList.ajax")
	public ModelAndView selectProductList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ProductVO") ProductVO parametervo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
	
		if(request.getParameter("JSON_STRING") == null){
			ProductVO productvo = new ProductVO();
			parametervo = productvo;
		} else {
			Gson gson = new Gson();
			parametervo = gson.fromJson(request.getParameter("JSON_STRING"), ProductVO.class);
		}
		try {
			mv.addObject("results", productService.selectProductList(parametervo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품관리 등록/수정 팝업
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/productRegi.pop")
	public ModelAndView productRegi(HttpServletRequest request, HttpServletResponse response, @ModelAttribute(value = "ProductVO") ProductVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("/contract/productMng/productRegi");
		ProductVO productvo = new ProductVO();
		try {
			Gson gson = new Gson();
			productvo = gson.fromJson(request.getParameter("JSON_STRING"), ProductVO.class);

			if (!productvo.getSEQ().equals("")) { // 수정
				mv.addObject("ProductVO", productService.selectProduct(productvo));
			} else { // 등록
				mv.addObject("ProductVO", paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/insertProduct.ajax")
	public ModelAndView insertProduct(HttpServletRequest request, @ModelAttribute(value = "ProductVO") ProductVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			productService.insertProduct(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/updateProduct.ajax")
	public ModelAndView updateProduct(HttpServletRequest request, @ModelAttribute(value = "ProductVO") ProductVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			productService.updateProduct(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/contract/productMng/deleteProduct.ajax")
	public ModelAndView deleteProduct(HttpServletRequest request, @RequestBody JSONObject paramJObj) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		ArrayList<ProductVO> models = (ArrayList<ProductVO>) JSONArray.toCollection(paramJObj.getJSONArray("models"), ProductVO.class);

		try {
			productService.deleteProduct(models);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 상품정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/ProductMng/selectProductListExcel.ajax")
	public void selectProductListExcel(HttpServletRequest request, HttpServletResponse response, ProductVO vo) throws Exception {
		try {
			
			excelHandler2 eh = productService.selectProductListExcel(vo);

			if (eh.getRowindex() == 0) {
				CommUtil.sendGenexonAlert(response, "info", "상품관리 - 엑셀다운로드", "조회 데이타가 없습니다.");
			} else {
				String filename = "상품관리_" + CommUtil.getCurrentDateTime() + ".xlsx";
				eh.sendResponse(response, filename);
			}

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @Description  : 상품 판매적용일 적용(수정)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/updateProductEndDate.ajax")
	public ModelAndView updateProductEndDate(HttpServletRequest request, @ModelAttribute(value = "ProductVO") ProductVO paramvo) throws Exception {
		ModelAndView mv = new ModelAndView("jsonView");
		
		try {
			productService.updateProductEndDate(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	/**
	 * @Description  : 계약-> 상품 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 15
	 * @return       : String
	 * @throws       : Exception
	 */
	@RequestMapping(value = "/contract/productMng/selectProduct.ajax")
	public ModelAndView selectProduct(HttpServletRequest request, @ModelAttribute(value = "ProductVO") ProductVO paramvo) throws Exception {
			ModelAndView mv = new ModelAndView("jsonView");
		try {
			mv.addObject("ProductVO", productService.selectProduct(paramvo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return mv;
	}

	
}
