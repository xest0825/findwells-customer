package kr.co.fw.system.menu;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 공통코드 관리 service
 */
@Service(value = "MenuService")
public class MenuService {

	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

	@Autowired
	private MenuDAO menuDao;

	
	/**
	 * @brief 메뉴 리스트 트리 조회  
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenuList(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> resultList = new ArrayList<ResourcesVO>();

		try {
			resultList = menuDao.getMenuList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
	
	/**
	 * @brief 링크 리스트 트리 조회  
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getLinkList(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> resultList = new ArrayList<ResourcesVO>();

		try {
			resultList = menuDao.getLinkList(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
	
	/**
	 * @brief 메뉴 리스트 조회  
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenu(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> resultList = new ArrayList<ResourcesVO>();

		try {
			resultList = menuDao.getMenu(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
	
	
	/**
	 * @brief 메뉴관리 화면에서 하위 리스트 조회
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getResources(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> resultList = new ArrayList<ResourcesVO>();

		try {
			resultList = menuDao.getResources(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}

	
	/**
	 * @brief 메뉴 저장 
	 * @param ArrayList<ResourcesVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertMenu(ArrayList<ResourcesVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ResourcesVO paramvo = models.get(i);

				result = menuDao.insertMenu(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 메뉴 수정
	 * @param ArrayList<ResourcesVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateMenu(ArrayList<ResourcesVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ResourcesVO paramvo = models.get(i);

				result = menuDao.updateMenu(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @brief 메뉴 삭제
	 * @param ArrayList<ResourcesVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteMenu(ArrayList<ResourcesVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ResourcesVO paramvo = models.get(i);

				menuDao.deleteMenuRole(paramvo);
				result = menuDao.deleteMenu(paramvo);

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @brief 메뉴 롤메핑 리스트 조회
	 * @param ResourcesVO
	 * @return List<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenuRole(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> resultList = new ArrayList<ResourcesVO>();

		try {
			resultList = menuDao.getMenuRole(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
	

	/**
	 * @breif 메뉴 롤메핑 저장  
	 * @param ArrayList<ResourcesVO>
	 * @return int
	 * @throws Exception
	 */
	public int insertMenuRole(ArrayList<ResourcesVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ResourcesVO paramvo = models.get(i);

				result = menuDao.insertMenuRole(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @breif 메뉴 롤메핑 수정 
	 * @param ArrayList<ResourcesVO>
	 * @return int
	 * @throws Exception
	 */
	public int updateMenuRole(ArrayList<ResourcesVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ResourcesVO paramvo = models.get(i);

				result = menuDao.updateMenuRole(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	

	/**
	 * @breif 메뉴 롤메핑 삭제
	 * @param ArrayList<ResourcesVO>
	 * @return int
	 * @throws Exception
	 */
	public int deleteMenuRole(ArrayList<ResourcesVO> models) throws Exception {
		int result = 0;

		try {
			for (int i = 0; i < models.size(); i++) {
				ResourcesVO paramvo = models.get(i);

				menuDao.deleteMenuRole(paramvo);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}
	
	
	/**
	 * @breif 롤마스터조회
	 * @param ResourcesVO
	 * @return ArrayList<ResourcesVO>
	 * @throws Exception
	 */
	public List<ResourcesVO> getMenuRoleMaster(ResourcesVO paramvo) throws Exception {
		List<ResourcesVO> resultList = new ArrayList<ResourcesVO>();

		try {
			resultList = menuDao.getMenuRoleMaster(paramvo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return resultList;
	}
	
	
}
