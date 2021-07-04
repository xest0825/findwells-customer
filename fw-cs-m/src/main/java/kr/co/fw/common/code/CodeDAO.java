package kr.co.fw.common.code;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class CodeDAO extends BaseDAO {

	/**
	 * 그룹 코드 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getGroupCodeList(CodeVO paramvo) {
		return getSqlSession().selectList(getCodeMapper() + "getGroupCodeList", paramvo);
	}

	/**
	 * 그룹 코드 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertGroupCode(CodeVO paramvo) {
		return getSqlSession().insert(getCodeMapper() + "insertGroupCode", paramvo);
	}

	/**
	 * 그룹 코드 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateGroupCode(CodeVO paramvo) {
		return getSqlSession().update(getCodeMapper() + "updateGroupCode", paramvo);
	}

	/**
	 * 그룹 코드 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteGroupCode(CodeVO paramvo) {
		return getSqlSession().delete(getCodeMapper() + "deleteGroupCode", paramvo);
	}

	/**
	 * 코드 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getCodeList(CodeVO paramvo) {
		return getSqlSession().selectList(getCodeMapper() + "getCodeList", paramvo);
	}

	/**
	 * 코드 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertCode(CodeVO paramvo) {
		return getSqlSession().insert(getCodeMapper() + "insertCode", paramvo);
	}

	/**
	 * 코드 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateCode(CodeVO paramvo) {
		return getSqlSession().update(getCodeMapper() + "updateCode", paramvo);
	}

	/**
	 * 코드 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteCode(CodeVO paramvo) {
		return getSqlSession().delete(getCodeMapper() + "deleteCode", paramvo);
	}

}
