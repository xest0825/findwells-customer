package kr.co.fw.common.insco;
/*
 * Copyright GENEXON (c) 2014.
 */

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
import kr.co.fw.common.excel.excelHandler2;

/**
 * 원수사 DAO
 */
@Repository(value = "InscoDAO")
public class InscoDAO extends BaseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(InscoDAO.class);
	
	private static final String SQL_PREFIX = "Insco.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * @Description  : 원수사 중복 조회
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : int
	 * @throws       : Exception
	 */
	public int selectInscoCnt(InscoVO paramvo) throws Exception {
		try {
			return sqlSession.selectOne(SQL_PREFIX + "selectInscoCnt", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @Description  : 원수사관리 엑셀다운로드
	 * @author       : lakhyun.kim
	 * @since        : 2018. 05. 29
	 * @return       : excelHandler2
	 * @throws       : Exception
	 */
	public void selectInscoListExcel(InscoVO vo, excelHandler2 eh) throws Exception {
		try {
			sqlSession.select(SQL_PREFIX + "selectInscoList", vo,eh);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}

	/**
	 * @brief 원수사목록 조회
	 * @param InscoVO
	 * @return ArrayList<InscoVO>
	 * @throws Exception
	 */
	public List<InscoVO> selectInscoList(InscoVO paramvo) throws Exception {

		try {
			return sqlSession.selectList(SQL_PREFIX + "selectInscoList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @brief 원수사 입력
	 * @param InscoVO
	 * @return int
	 * @throws Exception
	 */
	public int insertInsco(InscoVO paramvo) throws Exception {

		try {
			return sqlSession.insert(SQL_PREFIX + "insertInsco", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}
	
	/**
	 * @brief 원수사 수정
	 * @param InscoVO
	 * @return int
	 * @throws Exception
	 */
	public int updateInsco(InscoVO paramvo) throws Exception {

		try {
			return sqlSession.update(SQL_PREFIX + "updateInsco", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * @brief 원수사 삭제
	 * @param InscoVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteInsco(InscoVO paramvo) throws Exception {

		try {
			return sqlSession.delete(SQL_PREFIX + "deleteInsco", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

	}

	/**
	 * ddcode INSCO_CD(원수사코드) 리스트 조회
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @param InscoVO
	 * @return ModelAndView
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectInscoCdList(InscoVO inscoVO) {
		try {
			return sqlSession.selectList(SQL_PREFIX + "selectInscoCdList", inscoVO);
		}catch(Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
}
