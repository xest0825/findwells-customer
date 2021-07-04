package kr.co.fw.system.orgReadRole;
/*
 * Copyright GENEXON (c) 2014.
 */

import kr.co.fw.insa.InSaVO;
import kr.co.fw.system.orgReadRole.OrgReadRoleVO;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 조직 조회 권한 관리 service
 */
@Service(value = "ScdReadRoleService")
public class OrgReadRoleService {

	private static final Logger logger = LoggerFactory.getLogger(OrgReadRoleService.class);

	@Autowired
	private OrgReadRoleDAO scdReadRoleDao;


	/**
	 * @brief 조직 조회 권한 트리뷰 조회 
	 * @param OrgReadRoleVO
	 * @return List<OrgReadRoleVO>
	 * @throws Exception
	 */
	public List<OrgReadRoleVO> getScdReadRoleTree(OrgReadRoleVO paramvo) throws Exception {
		List<OrgReadRoleVO> resultList = new ArrayList<OrgReadRoleVO>();

		try {
			resultList = scdReadRoleDao.getScdReadRoleTree(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}

	
	/**
	 * @brief 조직 조회 권한 등록  
	 * @param ArrayList<OrgReadRoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertScdReadRole(ArrayList<OrgReadRoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				OrgReadRoleVO paramvo = models.get(i);

				if (result == 0) {
					scdReadRoleDao.deleteScdReadRole(paramvo);
					// 체크된 데이타가 없을시 삭제후 리턴
					if ("Y".equals(paramvo.getDELETE_YN())) {
						break;
					}
				}
				result += scdReadRoleDao.insertScdReadRole(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	
	/**
	 * @desc 하위조직 리스트 조회
	 * @param OrgReadRoleVO
	 * @return List<OrgReadRoleVO>
	 * @throws Exception
	 */
	public List<OrgReadRoleVO> selectScdUnderList(OrgReadRoleVO paramvo) throws Exception {
		try {
			return scdReadRoleDao.selectScdUnderList(paramvo);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
	}
	

	/**
	 * @brief 조직 조회 권한 삭제  
	 * @param ArrayList<OrgReadRoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteScdReadRole(ArrayList<OrgReadRoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				OrgReadRoleVO paramvo = models.get(i);

				scdReadRoleDao.deleteScdReadRole(paramvo);

			}
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
		List<InSaVO> resultList = new ArrayList<InSaVO>();

		try {
			resultList = scdReadRoleDao.selectInsaList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}


	/**
	 * @desc 사용자 권한 메핑 목록 조회    
	 * @param OrgReadRoleVO
	 * @return List<OrgReadRoleVO>
	 * @throws Exception
	 */
	public List<OrgReadRoleVO> getUserRoleMapList(OrgReadRoleVO paramvo) throws Exception {
		List<OrgReadRoleVO> resultList = new ArrayList<OrgReadRoleVO>();

		try {
			resultList = scdReadRoleDao.getUserRoleMapList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
		

	/**
	 * @brief 사용자 권한 메핑 등록  
	 * @param ArrayList<OrgReadRoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertUserRoleMap(ArrayList<OrgReadRoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				OrgReadRoleVO paramvo = models.get(i);
				if (scdReadRoleDao.getUserRoleMapList(paramvo).size() > 0) {
					result += scdReadRoleDao.updateUserRoleMap(paramvo);
				} else {
					result += scdReadRoleDao.insertUserRoleMap(paramvo);
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 사용자 권한 메핑 삭제   
	 * @param ArrayList<OrgReadRoleVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteUserRoleMap(ArrayList<OrgReadRoleVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				OrgReadRoleVO paramvo = models.get(i);

				scdReadRoleDao.deleteUserRoleMap(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
}
