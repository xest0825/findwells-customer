package kr.co.fw.system.role;
/*
 * Copyright GENEXON (c) 2014.
 */

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

/**
 * 권한 관리 DAO
 *
 */
@Repository(value = "RoleDAO")
public class RoleDAO extends BaseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleDAO.class);
	
	private static final String SQL_PREFIX = "Role.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/**
	 * @brief 권한 그룹 조회   
	 * @param RoleVO
	 * @return List<RoleVO>
	 * @throws Exception
	 */
	public List<RoleVO> getRoleList(RoleVO paramvo) throws Exception {
		List<RoleVO> reulstList = new ArrayList<RoleVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getRoleList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	
	/**
	 * @brief 권한 그룹 저장
	 * @param RoleVO
	 * @return int
	 * @throws Exception
	 */
	public int insertRole(RoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "insertRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 권한 그룹 수정
	 * @param RoleVO
	 * @return int
	 * @throws Exception
	 */
	public int updateRole(RoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "updateRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	
	
	/**
	 * @brief 권한 그룹 삭제
	 * @param RoleVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteRole(RoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 권한 그룹 계층조회
	 * @param RoleVO
	 * @return List<RoleVO>
	 * @throws Exception
	 */
	public List<RoleVO> getRoleHieraList(RoleVO paramvo) throws Exception {
		List<RoleVO> reulstList = new ArrayList<RoleVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getRoleHieraList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}


	/**
	 * @brief 권한 그룹 계층 입력
	 * @param RoleVO
	 * @return int
	 * @throws Exception
	 */
	public int insertRoleHiera(RoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "insertRoleHiera", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 권한 그룹 계층 수정
	 * @param RoleVO
	 * @return int
	 * @throws Exception
	 */
	public int updateRoleHiera(RoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "updateRoleHiera", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	
	
	/**
	 * @brief 권한 그룹 계층 삭제
	 * @param RoleVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteRoleHiera(RoleVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteRoleHiera", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 권한 트리조회
	 * @param RoleVO
	 * @return List<RoleVO>
	 * @throws Exception
	 */
	public List<RoleVO> getRoleTree(RoleVO paramvo) throws Exception {
		List<RoleVO> reulstList = new ArrayList<RoleVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getRoleTree", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

}
