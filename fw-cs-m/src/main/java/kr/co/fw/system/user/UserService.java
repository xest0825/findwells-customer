package kr.co.fw.system.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;
import kr.co.fw.customer.CustomerVO;
import kr.co.fw.system.app.MobileAppVO;

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
	 * 사용자 목록 조회
	 * 
	 * @param User
	 * @return int
	 */
	public List<HashMap<String, Object>> getCustomerUserList(CustomerVO paramap) {
		return getUserDAO().getCustomerUserList(paramap);
	}
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param User
	 * @return int
	 */
	public HashMap<String, Object> getCustomerUser(CustomerVO paramap) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		list = getUserDAO().getCustomerUserList(paramap);
		if (list.size() > 0) {
			retMap = list.get(0);
		}
		return retMap;
	}
	
	/**
	 * 사용자 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertCustomerUser(CustomerVO paramap) {
		return getUserDAO().insertCustomerUser(paramap);
	}
	
	/**
	 * 사용자 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateCustomerUser(CustomerVO paramap) {
		return getUserDAO().updateCustomerUser(paramap);
	}

	/**
	 * 사용자 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteCustomerUser(CustomerVO paramap) {
		return getUserDAO().deleteCustomerUser(paramap);
	}
	
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param User
	 * @return int
	 */
	public List<HashMap<String, Object>> getCustomerLoginInfoList(CustomerVO paramap) {
		return getUserDAO().getCustomerLoginInfoList(paramap);
	}
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param User
	 * @return int
	 */
	public HashMap<String, Object> getCustomerLoginInfo(CustomerVO paramap) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		list = getUserDAO().getCustomerLoginInfoList(paramap);
		if (list.size() > 0) {
			retMap = list.get(0);
		}
		return retMap;
	}
	/**
	 * 사용자 로그인 정보 입력
	 * 
	 * @param User
	 * @return int
	 * @note login_id가 PK
	 */
	public int insertCustomerLoginInfo(CustomerVO paramap) {
		return getUserDAO().insertCustomerLoginInfo(paramap);
	}
	
	/**
	 * 사용자 로그인 정보 수정
	 * 
	 * @param User
	 * @return int
	 * @note login_id가 PK
	 */
	public int updateCustomerLoginInfo(CustomerVO paramap) {
		return getUserDAO().updateCustomerLoginInfo(paramap);
	}
	
	/**
	 * 사용자 로그인 정보 삭제
	 * 
	 * @param User
	 * @return int
	 * @note login_id가 PK
	 */
	public int deleteCustomerLoginInfo(CustomerVO paramap) {
		return getUserDAO().deleteCustomerLoginInfo(paramap);
	}
	
	/**
	 * 사용자 기기 목록 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getUserDeviceList(MobileAppVO paramap) {
		return getUserDAO().getUserDeviceList(paramap);	
	}
	
	/**
	 * 사용자 기기 조회
	 * 
	 * @param UserVO
	 * @return HashMap<String, String>
	 */
	public HashMap<String, Object> getUserDevice(MobileAppVO paramap) {
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String, Object>>();
		resultList = getUserDAO().getUserDeviceList(paramap);	
		if (resultList.size() > 0) {
			resultMap = resultList.get(0);
		}
		
		return resultMap;	
	}
	
	/**
	 * 사용자 기기 입력
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int insertUserDevice(MobileAppVO paramap) {
		return getUserDAO().insertUserDevice(paramap);			
	}
	
	
	/**
	 * 사용자 기기 수정
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int updateUserDevice(MobileAppVO paramap) {
		return getUserDAO().updateUserDevice(paramap);			
	}
	
	/**
	 * 사용자 기기 삭제
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int deleteUserDevice(MobileAppVO paramap) {
		return getUserDAO().deleteUserDevice(paramap);			
	}

}
