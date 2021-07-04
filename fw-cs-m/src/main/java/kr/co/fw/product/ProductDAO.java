package kr.co.fw.product;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class ProductDAO extends BaseDAO {

	
	/**
	 * 상품 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getProductList(ProductVO paramvo) {
		return getSqlSession().selectList(getProductMapper() + "getProductList", paramvo);
	}

	/**
	 * 상품 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertProduct(ProductVO paramvo) {
		return getSqlSession().insert(getProductMapper() + "insertProduct", paramvo);
	}

	/**
	 * 상품 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateProduct(ProductVO paramvo) {
		return getSqlSession().update(getProductMapper() + "updateProduct", paramvo);
	}

	/**
	 * 상품 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteProduct(ProductVO paramvo) {
		return getSqlSession().delete(getProductMapper() + "deleteProduct", paramvo);
	}
	
	
	/**
	 * 보장 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getCoverageList(ProductVO paramvo) {
		return getSqlSession().selectList(getProductMapper() + "getCoverageList", paramvo);
	}

	/**
	 * 보장 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertCoverage(ProductVO paramvo) {
		return getSqlSession().insert(getProductMapper() + "insertCoverage", paramvo);
	}

	/**
	 * 보장 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateCoverage(ProductVO paramvo) {
		return getSqlSession().update(getProductMapper() + "updateCoverage", paramvo);
	}

	/**
	 * 보장 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteCoverage(ProductVO paramvo) {
		return getSqlSession().delete(getProductMapper() + "deleteCoverage", paramvo);
	}
	

	/**
	 * 보장 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getPayInfoList(ProductVO paramvo) {
		return getSqlSession().selectList(getProductMapper() + "getPayInfoList", paramvo);
	}

	/**
	 * 보장 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertPayInfo(ProductVO paramvo) {
		return getSqlSession().insert(getProductMapper() + "insertPayInfo", paramvo);
	}

	/**
	 * 보장 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updatePayInfo(ProductVO paramvo) {
		return getSqlSession().update(getProductMapper() + "updatePayInfo", paramvo);
	}

	/**
	 * 보장 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deletePayInfo(ProductVO paramvo) {
		return getSqlSession().delete(getProductMapper() + "deletePayInfo", paramvo);
	}
	
	
	/**
	 * 보험료 예시 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getPremiumAmtExampleList(ProductVO paramvo) {
		return getSqlSession().selectList(getProductMapper() + "getPremiumAmtExampleList", paramvo);
	}

	/**
	 * 보험료 예시 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertPremiumAmtExample(ProductVO paramvo) {
		return getSqlSession().insert(getProductMapper() + "insertPremiumAmtExample", paramvo);
	}

	/**
	 * 보험료 예시 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updatePremiumAmtExample(ProductVO paramvo) {
		return getSqlSession().update(getProductMapper() + "updatePremiumAmtExample", paramvo);
	}

	/**
	 * 보험료 예시 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deletePremiumAmtExample(ProductVO paramvo) {
		return getSqlSession().delete(getProductMapper() + "deletePremiumAmtExample", paramvo);
	}
	
}
