package kr.co.fw.system.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;
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
	public List<HashMap<String, Object>> getUserListPaging(UserVO paramap) {
		return getSqlSession().selectList(getUserMapper() + "getUserListPaging", paramap);
	}
	
	/**
	 * 사용자 목록 개수 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public int getUserListCnt(UserVO paramap) {
		return getSqlSession().selectOne(getUserMapper() + "getUserListCnt", paramap);
	}
	
	/**
	 * 사용자 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertUser(User paramap) {
		return getSqlSession().insert(getUserMapper() + "insertUser", paramap);
	}
	
	/**
	 * 사용자 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateUser(User paramap) {
		return getSqlSession().update(getUserMapper() + "updateUser", paramap);
	}

	/**
	 * 사용자 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteUser(User paramap) {
		return getSqlSession().delete(getUserMapper() + "deleteUser", paramap);
	}
	
	
	
	
	
	/* ==========================   [사용자 기기 정보]  =========================== */
	
	/**
	 * 사용자 - 기기 매핑정보 조회
	 * 
	 * @param UserVO
	 * @return List<HashMap<String, String>>
	 */
	public List<HashMap<String, Object>> getDevcList(UserVO paramap) {
		return getSqlSession().selectList(getDevcMapper() + "getDevcList", paramap);			
	}
	
	/**
	 * 사용자 - 기기 매핑정보 입력
	 * 
	 * @param User
	 * @return int
	 */
	public int insertDevc(User paramap) {
		return getSqlSession().insert(getDevcMapper() + "insertDevc", paramap);
	}
	
	/**
	 * 사용자 - 기기 매핑정보 수정
	 * 
	 * @param User
	 * @return int
	 */
	public int updateDevc(User paramap) {
		return getSqlSession().update(getDevcMapper() + "updateDevc", paramap);
	}

	/**
	 * 사용자 - 기기 매핑정보 삭제
	 * 
	 * @param User
	 * @return int
	 */
	public int deleteDevc(User paramap) {
		return getSqlSession().delete(getDevcMapper() + "deleteDevc", paramap);
	}

}
