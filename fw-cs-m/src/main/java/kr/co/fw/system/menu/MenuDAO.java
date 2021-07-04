package kr.co.fw.system.menu;
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
 * 메뉴 관리 DAO
 */
@Repository(value = "MenuDAO")
public class MenuDAO extends BaseDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuDAO.class);
	
	private static final String SQL_PREFIX = "Menu.";

	@Autowired
	private SqlSessionTemplate sqlSession;
	

	/**
	 * @brief  메뉴 리스트 트리 조회   
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenuList(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> reulstList = new ArrayList<ResourcesVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getResourcesList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}
	
	/**
	 * @brief  링크 리스트 트리 조회   
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getLinkList(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> reulstList = new ArrayList<ResourcesVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "selectInscoHomeUrlList", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}


	/**
	 * @brief 메뉴관리 화면에서 하위 리스트 조회
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getResources(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> reulstList = new ArrayList<ResourcesVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getResources", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}
	
	
	/**
	 * @brief 메뉴 리스트  조회   
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenu(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> reulstList = new ArrayList<ResourcesVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getMenu", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	
	/**
	 * @brief 메뉴 저장
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public int insertMenu(ResourcesVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "insertMenu", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 메뉴 수정  
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public int updateMenu(ResourcesVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "updateMenu", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	

	/**
	 * @brief 메뉴 삭제  
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteMenu(ResourcesVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteMenu", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
			
	
	/**
	 * @brief 메뉴 롤매핑 목록 조회  
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenuRole(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> reulstList = new ArrayList<ResourcesVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getMenuRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	
	/**
	 * @brief 메뉴 롤매핑 저장
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public int insertMenuRole(ResourcesVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.insert(SQL_PREFIX + "insertMenuRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief  메뉴 롤메핑 수정  
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public int updateMenuRole(ResourcesVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "updateMenuRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}
	
			
	/**
	 * @brief  메뉴 롤메핑 삭제 
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteMenuRole(ResourcesVO paramvo) throws Exception {
		int result = 0;

		try {
			result = sqlSession.update(SQL_PREFIX + "deleteMenuRole", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
			
	
	/**
	 * @brief 롤마스터 조회 
	 * @param ResourcesVO
	 * @return int
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenuRoleMaster(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> reulstList = new ArrayList<ResourcesVO>();

		try {
			reulstList = sqlSession.selectList(SQL_PREFIX + "getMenuRoleMaster", paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return reulstList;
	}

	
}
