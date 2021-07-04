package kr.co.fw.contract.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fw.common.excel.excelHandler2;

@Service(value = "ProductService")
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductDAO productDAO;
	
	/**
	 * @Description  : 상품관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : List<ProductVO>
	 * @throws       : Exception
	 */
	public List<ProductVO> selectProductList(ProductVO paramvo) throws Exception {
		List<ProductVO> resultList = new ArrayList<ProductVO>();
		try {
			resultList = productDAO.selectProductList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return resultList;
	}

	/**
	 * @Description  : 상품 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectProduct(ProductVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = productDAO.selectProduct(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}

	/**
	 * @Description  : 상품 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : 
	 * @throws       : Exception
	 */
	public void insertProduct(ProductVO paramrvo) throws Exception {
		try {
			productDAO.insertProduct(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateProduct(ProductVO paramrvo) throws Exception {
		try {
			productDAO.updateProduct(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : 
	 * @throws       : Exception
	 */
	public void deleteProduct(ArrayList<ProductVO> models) throws Exception {
		try {
			for (int i = 0; i < models.size(); i++) {
				ProductVO paramvo = models.get(i);

				productDAO.deleteProduct(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : excelHandler2
	 * @throws       : Exception
	 */
	public excelHandler2 selectProductListExcel(ProductVO vo) throws Exception {
		excelHandler2 eh = null;
		String[] tiltestemp = {"IFA", "원수사", "상품군2", "상품명", "풀네임+한글설명", "상품환산", "납입년수", "판매개시", "판매종료", "사용", "상품번호"};
		
		String[] fieldstemp = {"INSCO_TYPENM", "INSCO_NM", "PROD_KIND2", "PROD_NM", "PROD_FULL_NM", "BYENHWAN_RATE", "HWANSAN_COUNT", "PROD_STRT_YMD", "PROD_END_YMD", "USE_YN", "SEQ"};

		try {
			ArrayList<String> titleList = new ArrayList<String>();
			ArrayList<String> fieldsList = new ArrayList<String>();
			
			Collections.addAll(titleList, tiltestemp);
			Collections.addAll(fieldsList,fieldstemp);
			
			eh = new excelHandler2(vo.getExcel_path() ,titleList, fieldsList);
			productDAO.selectProductListExcel(vo, eh);

			//컬럼 사이즈 설정
			if(eh.getRowindex() != 0) {
				for(int i=0; i<tiltestemp.length; i++) {
					eh.getDataSheet().setColumnWidth(i, (eh.getDataSheet().getColumnWidth(i)) + (int)2048); //(int)1 : 약 0.03픽셀
				}
			}
		
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return eh;
	}

	/**
	 * @Description  : 상품 판매적용일 적용(수정)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateProductEndDate(ProductVO paramrvo) throws Exception {
		try {
			productDAO.updateProductEndDate(paramrvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

}
