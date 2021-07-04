package kr.co.fw.contract.productGroup;

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

@Repository(value = "ProductGroupDAO")
public class ProductGroupDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProductGroupDAO.class);
	
	private static final String SQL_PREFIX = "ProductGroup.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * @Description  : 상품군관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ProductGroupVO>
	 * @throws       : Exception
	 */
	public List<ProductGroupVO> selectProductGroupList(ProductGroupVO paramvo) throws Exception {
		List<ProductGroupVO> reulstList = new ArrayList<ProductGroupVO>();
		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectProductGroupList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	/**
	 * @Description  : 상품군 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectProductGroup(ProductGroupVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = sqlSession.selectOne(SQL_PREFIX + "selectProductGroup", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}

	/**
	 * @Description  : 상품군 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void insertProductGroup(ProductGroupVO paramvo) throws Exception {
		try {
			sqlSession.insert(SQL_PREFIX + "insertProductGroup", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품군 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateProductGroup(ProductGroupVO paramvo) throws Exception {
		try {
			sqlSession.update(SQL_PREFIX + "updateProductGroup", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품군 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void deleteProductGroup(ProductGroupVO paramvo) throws Exception {
		try {
			sqlSession.delete(SQL_PREFIX + "deleteProductGroup", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품군정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void selectProductGroupListExcel(ProductGroupVO vo, excelHandler2 eh) throws Exception {
		try {
			sqlSession.select(SQL_PREFIX + "selectProductGroupList", vo, eh);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
}
