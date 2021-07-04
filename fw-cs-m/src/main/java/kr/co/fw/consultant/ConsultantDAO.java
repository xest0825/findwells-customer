package kr.co.fw.consultant;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class ConsultantDAO extends BaseDAO {

	/**
	 * FC 정보 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getFCInfoList(ConsultantVO paramvo) {
		return getSqlSession().selectList(getConsultantMapper() + "getFCInfoList", paramvo);
	}

	/**
	 * FC 정보 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertFCInfo(ConsultantVO paramvo) {
		return getSqlSession().insert(getConsultantMapper() + "insertFCInfo", paramvo);
	}

	/**
	 * FC 정보 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateFCInfo(ConsultantVO paramvo) {
		return getSqlSession().update(getConsultantMapper() + "updateFCInfo", paramvo);
	}

	/**
	 * FC 정보 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteFCInfo(ConsultantVO paramvo) {
		return getSqlSession().delete(getConsultantMapper() + "deleteFCInfo", paramvo);
	}
	
	
	/**
	 * FC 고객 매핑 목록 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getFcCustomerMappingList(ConsultantVO paramvo) {
		return getSqlSession().selectList(getConsultantMapper() + "getFcCustomerMappingList", paramvo);
	}
	
	/**
	 * FC 고객 매핑 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertFcCustomerMapping(ConsultantVO paramvo) {
		return getSqlSession().insert(getConsultantMapper() + "insertFcCustomerMapping", paramvo);
	}
	
	/**
	 * FC 고객 매핑 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateFcCustomerMapping(ConsultantVO paramvo) {
		return getSqlSession().update(getConsultantMapper() + "updateFcCustomerMapping", paramvo);
	}
	
	
	/**
	 * FC 고객 매핑 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteFcCustomerMapping(ConsultantVO paramvo) {
		return getSqlSession().delete(getConsultantMapper() + "deleteFcCustomerMapping", paramvo);
	}

}
