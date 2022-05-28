package kr.co.fw.system.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
import kr.co.fw.customer.CustomerVO;
import kr.co.fw.system.app.MobileAppVO;
import kr.co.fw.system.security.model.User;

@Repository
public class UserDAO extends BaseDAO {
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getUserList(UserVO paramap) {
		if (paramap.isPagination()) {
			return getSqlSession().selectList(getUserMapper() + "getUserListPaging", paramap);			
		} else {
			return getSqlSession().selectList(getUserMapper() + "getUserList", paramap);			
		}
	}
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getUserListPaging(User paramap) {
		return getSqlSession().selectList(getUserMapper() + "getUserListPaging", paramap);
	}
	
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getCustomerUserList(CustomerVO paramap) {
		return getSqlSession().selectList(getUserMapper() + "getCustomerUserList", paramap);			
	}
	
	/**
	 * 사용자 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertCustomerUser(CustomerVO paramap) {
		return getSqlSession().insert(getUserMapper() + "insertCustomerUser", paramap);
	}
	
	/**
	 * 사용자 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateCustomerUser(CustomerVO paramap) {
		return getSqlSession().update(getUserMapper() + "updateCustomerUser", paramap);
	}

	/**
	 * 사용자 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteCustomerUser(CustomerVO paramap) {
		return getSqlSession().delete(getUserMapper() + "deleteCustomerUser", paramap);
	}
	
	
	/**
	 * 사용자 목록 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getCustomerLoginInfoList(CustomerVO paramap) {
		return getSqlSession().selectList(getUserMapper() + "getCustomerLoginInfoList", paramap);			
	}
	
	/**
	 * 사용자 로그인 정보 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertCustomerLoginInfo(CustomerVO paramap) {
		return getSqlSession().insert(getUserMapper() + "insertCustomerLoginInfo", paramap);
	}
	
	/**
	 * 사용자 로그인 정보 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateCustomerLoginInfo(CustomerVO paramap) {
		return getSqlSession().update(getUserMapper() + "updateCustomerLoginInfo", paramap);
	}

	/**
	 * 사용자 로그인 정보 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteCustomerLoginInfo(CustomerVO paramap) {
		return getSqlSession().delete(getUserMapper() + "deleteCustomerLoginInfo", paramap);
	}
	
	/**
	 * 사용자 기기 목록 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getUserDeviceList(MobileAppVO paramap) {
		return getSqlSession().selectList(getUserMapper() + "getUserDeviceList", paramap);			
	}
	
	/**
	 * 사용자 기기 입력
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int insertUserDevice(MobileAppVO paramap) {
		return getSqlSession().insert(getUserMapper() + "insertUserDevice", paramap);			
	}
	
	
	/**
	 * 사용자 기기 수정
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int updateUserDevice(MobileAppVO paramap) {
		return getSqlSession().update(getUserMapper() + "updateUserDevice", paramap);			
	}
	
	/**
	 * 사용자 기기 삭제
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int deleteUserDevice(MobileAppVO paramap) {
		return getSqlSession().update(getUserMapper() + "deleteUserDevice", paramap);			
	}
	

}
