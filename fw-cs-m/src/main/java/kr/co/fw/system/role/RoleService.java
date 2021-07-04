package kr.co.fw.system.role;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 권한 관리 service
 */
@Service(value = "RoleService")
public class RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

	@Autowired
	private RoleDAO roleDao;

	
	/**
	 * @brief 권한 그룹 조회 
	 * @param RoleVO
	 * @return List<RoleVO>
	 * @throws Exception
	 */
	public List<RoleVO> getRoleList(RoleVO paramvo) throws Exception {
		List<RoleVO> resultList = new ArrayList<RoleVO>();

		try {
			resultList = roleDao.getRoleList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}

	
	/**
	 * @brief 권한 그룹 저장  
	 * @param ArrayList<RoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertRole(ArrayList<RoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				RoleVO paramvo = models.get(i);

				result = roleDao.insertRole(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 권한 그룹 수정  
	 * @param ArrayList<RoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateRole(ArrayList<RoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				RoleVO paramvo = models.get(i);

				result = roleDao.updateRole(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 권한 그룹 삭제   
	 * @param ArrayList<RoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteRole(ArrayList<RoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				RoleVO paramvo = models.get(i);

				roleDao.deleteRole(paramvo);

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @brief 권한 그룹 계층조회   
	 * @param RoleVO
	 * @return ArrayList<RoleVO>
	 * @throws Exception
	 */
	public List<RoleVO> getRoleHieraList(RoleVO paramvo) throws Exception {
		List<RoleVO> resultList = new ArrayList<RoleVO>();

		try {
			resultList = roleDao.getRoleHieraList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}


	/**
	 * @brief 권한 그룹 계층저장
	 * @param ArrayList<RoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertRoleHiera(ArrayList<RoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				RoleVO paramvo = models.get(i);

				result = roleDao.insertRoleHiera(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}


	/**
	 * @brief 권한 그룹 계층 수정  
	 * @param ArrayList<RoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateRoleHiera(ArrayList<RoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				RoleVO paramvo = models.get(i);

				result = roleDao.updateRoleHiera(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}


	/**
	 * @brief 권한 그룹 계층 삭제
	 * @param ArrayList<RoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteRoleHiera(ArrayList<RoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				RoleVO paramvo = models.get(i);

				roleDao.deleteRoleHiera(paramvo);

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 권한 트리 조회
	 * @param RoleVO
	 * @return ArrayList<RoleVO>
	 * @throws Exception
	 */
	public List<RoleVO> getRoleTree(RoleVO paramvo) throws Exception {
		List<RoleVO> resultList = new ArrayList<RoleVO>();

		try {
			resultList = roleDao.getRoleTree(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
	
	
	
}
