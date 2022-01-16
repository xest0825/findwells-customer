package kr.co.fw.system.auth;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

/**
 * 즐겨찾기 서비스
 */
@Service(value = "AuthService")
public class AuthService extends BaseService {

	@Autowired
	private AuthDAO authDao;

	/**
	 * @desc 인증 이력 조회
	 * @param AuthVO
	 * @return ArrayList<HashMap>
	 * @throws Exception
	 */
	public List<HashMap<String, Object>> selectAuthLogList(AuthVO paramvo) throws Exception {
		return authDao.selectAuthLogList(paramvo);
	}

	/**
	 * @desc 인증 이력 입력
	 * @param AuthVO
	 * @return int
	 * @throws Exception
	 */
	public int insertAuthLog(AuthVO paramvo) throws Exception {
		return authDao.insertAuthLog(paramvo);
	}

	/**
	 * @desc 인증 이력 수정
	 * @param AuthVO
	 * @return int
	 * @throws Exception
	 */
	public int updateAuthLog(AuthVO paramvo) throws Exception {
		return authDao.updateAuthLog(paramvo);
	}

	/**
	 * @desc 인증 이력 삭제
	 * @param AuthVO
	 * @return int
	 * @throws Exception
	 */
	public int deleteAuthLog(AuthVO paramvo) throws Exception {
		return authDao.deleteAuthLog(paramvo);
	}

}
