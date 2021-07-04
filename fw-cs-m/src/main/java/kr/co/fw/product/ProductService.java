package kr.co.fw.product;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

@Service
public class ProductService extends BaseService {

	/**
	 * 상품 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getProductList(ProductVO paramvo) {
		return getProductDAO().getProductList(paramvo);
	}

	/**
	 * 상품 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertProduct(ProductVO paramvo) {
		return getProductDAO().insertProduct(paramvo);
	}

	/**
	 * 상품 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateProduct(ProductVO paramvo) {
		return getProductDAO().updateProduct(paramvo);
	}

	/**
	 * 상품 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteProduct(ProductVO paramvo) {
		return getProductDAO().deleteProduct(paramvo);
	}
	
	
	/**
	 * 보장 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getCoverageList(ProductVO paramvo) {
		return getProductDAO().getCoverageList(paramvo);
	}

	/**
	 * 보장 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertCoverage(ProductVO paramvo) {
		return getProductDAO().insertCoverage(paramvo);
	}

	/**
	 * 보장 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateCoverage(ProductVO paramvo) {
		return getProductDAO().updateCoverage(paramvo);
	}

	/**
	 * 보장 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteCoverage(ProductVO paramvo) {
		return getProductDAO().deleteCoverage(paramvo);
	}
	

	/**
	 * 보장 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getPayInfoList(ProductVO paramvo) {
		return getProductDAO().getPayInfoList(paramvo);
	}

	/**
	 * 보장 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertPayInfo(ProductVO paramvo) {
		return getProductDAO().insertPayInfo(paramvo);
	}

	/**
	 * 보장 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updatePayInfo(ProductVO paramvo) {
		return getProductDAO().updatePayInfo(paramvo);
	}

	/**
	 * 보장 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deletePayInfo(ProductVO paramvo) {
		return getProductDAO().deletePayInfo(paramvo);
	}
	
	
	/**
	 * 보험료 예시 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getPremiumAmtExampleList(ProductVO paramvo) {
		return getProductDAO().getPremiumAmtExampleList(paramvo);
	}

	/**
	 * 보험료 예시 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertPremiumAmtExample(ProductVO paramvo) {
		return getProductDAO().insertPremiumAmtExample(paramvo);
	}

	/**
	 * 보험료 예시 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updatePremiumAmtExample(ProductVO paramvo) {
		return getProductDAO().updatePremiumAmtExample(paramvo);
	}

	/**
	 * 보험료 예시 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deletePremiumAmtExample(ProductVO paramvo) {
		return getProductDAO().deletePremiumAmtExample(paramvo);
	}

}
