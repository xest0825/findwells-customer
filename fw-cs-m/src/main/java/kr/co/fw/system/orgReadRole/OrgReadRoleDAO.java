package kr.co.fw.system.orgReadRole;
/*
 * Copyright GENEXON (c) 2014.
 */

import kr.co.fw.base.BaseDAO;
import kr.co.fw.insa.InSaVO;
import kr.co.fw.system.orgReadRole.OrgReadRoleVO;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

/**
 * 조직 조회 권한 관리 DAO
 *
 */
@Repository(value = "ScdReadRoleDAO")
public class OrgReadRoleDAO extends BaseDAO {
	

	private static final Logger logger = LoggerFactory.getLogger(OrgReadRoleDAO.class);
	
	private static final String SQL_PREFIX = "ScdReadRole.";

	@Autowired
	private SqlSessionTemplate sqlSession;
	

	/**
	 * @brief 조직 조회 권한 트리뷰 조회
	 * @param OrgReadRoleVO
	 * @return List<OrgReadRoleVO>
	 * @throws Exception
	 */
	public List<OrgReadRoleVO> getScdReadRoleTree(OrgReadRoleVO paramvo) throws Exception {
		List<OrgReadRoleVO> reulstList = new ArrayList<OrgReadRoleVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getScdReadRoleTree", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}
	

	/**
	 * @brief 조직 조회 권한 저장 
	 * @param OrgReadRoleVO
	 * @return int
	 * @throws Exception
	 */
	public int insertScdReadRole(OrgReadRoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "insertScdReadRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 하위조직 리스트 조회
	 * @param OrgReadRoleVO
	 * @return List<OrgReadRoleVO>
	 * @throws Exception
	 */
	public List<OrgReadRoleVO> selectScdUnderList(OrgReadRoleVO paramvo) throws Exception {
		try {
			return sqlSession.selectList(SQL_PREFIX + "selectScdUnderList", paramvo);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/**
	 * @brief 조직 조회 삭제 
	 * @param OrgReadRoleVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteScdReadRole(OrgReadRoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteScdReadRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 인사정보 조회  
	 * @param InSaVO
	 * @return List<InSaVO>
	 * @throws Exception
	 */
	public List<InSaVO> selectInsaList(InSaVO paramvo) throws Exception {
		List<InSaVO> reulstList = new ArrayList<InSaVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectInsaList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}
	
	
	/**
	 * @brief 사용자 권한 메핑 리스트 조회  
	 * @param OrgReadRoleVO
	 * @return List<OrgReadRoleVO>
	 * @throws Exception
	 */
	public List<OrgReadRoleVO> getUserRoleMapList(OrgReadRoleVO paramvo) throws Exception {
		List<OrgReadRoleVO> reulstList = new ArrayList<OrgReadRoleVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getUserRoleMapList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}
	

	/**
	 * @brief 사용자 권한 메핑 등록  
	 * @param OrgReadRoleVO
	 * @return int
	 * @throws Exception
	 */
	public int insertUserRoleMap(OrgReadRoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "insertUserRoleMap", paramvo);
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	/**
	 * @desc   : 사용자 권한 메핑 등록  
	 * @author : choiys
	 * @date   : 2016-04-22
	 * @param  : OrgReadRoleVO
	 * @return : int 
	 * @throws : Exception
	 */
	public int updateUserRoleMap(OrgReadRoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "updateUserRoleMap",
					paramvo);
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 사용자 권한 메핑 삭제  
	 * @param OrgReadRoleVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteUserRoleMap(OrgReadRoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteUserRoleMap", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 사용자 권한 메핑 삭제 (사원코드이용) 
	 * @param OrgReadRoleVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteUserRoleMapByUserId(OrgReadRoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteUserRoleMapByUserId", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

}
