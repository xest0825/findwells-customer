package kr.co.fw.system.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.system.security.model.User;

@Service
public class UserService extends BaseService {
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param User
	 * @return int
	 */
	public List<HashMap<String, Object>> getUserList(UserVO paramap) {
		return getUserDAO().getUserList(paramap);
	}
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param User
	 * @return int
	 */
	public HashMap<String, Object> getUser(UserVO paramap) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		list = getUserDAO().getUserList(paramap);
		if (list.size() > 0) {
			retMap = list.get(0);
		}
		return retMap;
	}
	
	/**
	 * 사용자 목록 개수 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int getUserListCnt(UserVO paramap) {
		return getUserDAO().getUserListCnt(paramap);
	}
	
	/**
	 * 사용자 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertUser(User paramap) {
		paramap.setUser_id(CommUtil.getUUIDExceptDash());
		return getUserDAO().insertUser(paramap);
	}
	
	/**
	 * 사용자 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateUser(User paramap) {
		return getUserDAO().updateUser(paramap);
	}

	/**
	 * 사용자 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteUser(User paramap) {
		return getUserDAO().deleteUser(paramap);
	}

	
	
	
	
	/* ==========================   [사용자 기기 정보]  =========================== */
	
	/**
	 * 사용자 - 기기 매핑정보 조회
	 * 
	 * @param User
	 * @return int
	 */
	public HashMap<String, Object> getDevcList(UserVO paramap) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		list = getUserDAO().getDevcList(paramap);
		if (list.size() > 0) {
			retMap = list.get(0);
		}
		return retMap;
	}
	
	/**
	 * 사용자 - 기기 매핑정보 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertDevc(User paramap) {
		paramap.setUser_id(CommUtil.getUUIDExceptDash());
		return getUserDAO().insertDevc(paramap);
	}
	
	/**
	 * 사용자 - 기기 매핑정보 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateDevc(User paramap) {
		return getUserDAO().updateDevc(paramap);
	}

	/**
	 * 사용자 - 기기 매핑정보 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteDevc(User paramap) {
		return getUserDAO().deleteDevc(paramap);
	}
	

}
