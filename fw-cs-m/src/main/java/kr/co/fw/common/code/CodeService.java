package kr.co.fw.common.code;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

@Service
public class CodeService extends BaseService {

	/**
	 * 그룹 코드 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getGroupCodeList(CodeVO paramvo) {
		return getCodeDAO().getGroupCodeList(paramvo);
	}

	/**
	 * 그룹 코드 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertGroupCode(CodeVO paramvo) {
		return getCodeDAO().insertGroupCode(paramvo);
	}

	/**
	 * 그룹 코드 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateGroupCode(CodeVO paramvo) {
		return getCodeDAO().updateGroupCode(paramvo);
	}

	/**
	 * 그룹 코드 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteGroupCode(CodeVO paramvo) {
		return getCodeDAO().deleteGroupCode(paramvo);
	}

	/**
	 * 코드 조회
	 * 
	 * @param paramvo
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getCodeList(CodeVO paramvo) {
		return getCodeDAO().getCodeList(paramvo);
	}

	/**
	 * 코드 입력
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int insertCode(CodeVO paramvo) {
		return getCodeDAO().insertCode(paramvo);
	}

	/**
	 * 코드 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateCode(CodeVO paramvo) {
		return getCodeDAO().updateCode(paramvo);
	}

	/**
	 * 코드 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteCode(CodeVO paramvo) {
		return getCodeDAO().deleteCode(paramvo);
	}
}
