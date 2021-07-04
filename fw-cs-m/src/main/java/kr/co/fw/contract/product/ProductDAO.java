package kr.co.fw.contract.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.common.excel.excelHandler2;

@Repository(value = "ProductDAO")
public class ProductDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductDAO.class);
	
	private static final String SQL_PREFIX = "Product.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/**
	 * @Description  : 상품관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : List<ProductVO>
	 * @throws       : Exception
	 */
	public List<ProductVO> selectProductList(ProductVO paramvo) throws Exception {
		List<ProductVO> reulstList = new ArrayList<ProductVO>();
		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectProductList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
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
			map = sqlSession.selectOne(SQL_PREFIX + "selectProduct", paramvo);
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
	public void insertProduct(ProductVO paramvo) throws Exception {
		try {
			sqlSession.insert(SQL_PREFIX + "insertProduct", paramvo);
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
	public void updateProduct(ProductVO paramvo) throws Exception {
		try {
			sqlSession.update(SQL_PREFIX + "updateProduct", paramvo);
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
	public void deleteProduct(ProductVO paramvo) throws Exception {
		try {
			sqlSession.delete(SQL_PREFIX + "deleteProduct", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : 
	 * @throws       : Exception
	 */
	public void selectProductListExcel(ProductVO vo, excelHandler2 eh) throws Exception {
		try {
			sqlSession.select(SQL_PREFIX + "selectProductList", vo, eh);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품 판매적용일 적용(수정)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 12
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateProductEndDate(ProductVO paramvo) throws Exception {
		try {
			sqlSession.update(SQL_PREFIX + "updateProductEndDate", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
}
