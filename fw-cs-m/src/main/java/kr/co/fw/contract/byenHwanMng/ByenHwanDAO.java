package kr.co.fw.contract.byenHwanMng;

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

@Repository(value = "ByenHwanDAO")
public class ByenHwanDAO {

	private static final Logger logger = LoggerFactory.getLogger(ByenHwanDAO.class);
	
	private static final String SQL_PREFIX = "ByenHwan.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * @Description  : 변환율관리 목록조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ByenHwanVO>
	 * @throws       : Exception
	 */
	public List<ByenHwanVO> selectByenHwanList(ByenHwanVO paramvo) throws Exception {
		List<ByenHwanVO> reulstList = new ArrayList<ByenHwanVO>();
		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectByenHwanList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	/**
	 * @Description  : 상품구분2 조회 (dropDownList)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ByenHwanVO>
	 * @throws       : Exception
	 */
	public List<ByenHwanVO> selectByenhwanProdKind2(ByenHwanVO paramvo) throws Exception {
		List<ByenHwanVO> reulstList = new ArrayList<ByenHwanVO>();
		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectByenhwanProdKind2", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	/**
	 * @Description  : 변환율관리 마감월 조회 (dropDownList)
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : List<ByenHwanVO>
	 * @throws       : Exception
	 */
	public List<ByenHwanVO> selectByenhwanComYm(ByenHwanVO paramvo) throws Exception {
		List<ByenHwanVO> reulstList = new ArrayList<ByenHwanVO>();
		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectByenhwanComYm", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	/**
	 * @Description  : 변환율 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectByenHwan(ByenHwanVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = sqlSession.selectOne(SQL_PREFIX + "selectByenHwan", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}

	/**
	 * @Description  : 변환율 등록
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void insertByenHwan(ByenHwanVO paramvo) throws Exception {
		try {
			sqlSession.insert(SQL_PREFIX + "insertByenHwan", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 변환율 수정
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void updateByenHwan(ByenHwanVO paramvo) throws Exception {
		try {
			sqlSession.update(SQL_PREFIX + "updateByenHwan", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 변환율 삭제
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : 
	 * @throws       : Exception
	 */
	public void deleteByenHwan(ByenHwanVO paramvo) throws Exception {
		try {
			sqlSession.delete(SQL_PREFIX + "deleteByenHwan", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 변환율정보 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 11
	 * @return       : 
	 * @throws       : Exception
	 */
	public void selectByenHwanListExcel(ByenHwanVO vo, excelHandler2 eh) throws Exception {
		try {
			sqlSession.select(SQL_PREFIX + "selectByenHwanList", vo, eh);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 상품등록 -> 상품군2 change 이벤트 발생시 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 06. 08
	 * @return       : Map
	 * @throws       : Exception
	 */
	public Map selectProductByenHwan(ByenHwanVO paramvo) throws Exception {
		Map map = new HashMap();
		try {
			map = sqlSession.selectOne(SQL_PREFIX + "selectProductByenHwan", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return map;
	}
	
}
