package kr.co.fw.common.file;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class FileDAO extends BaseDAO {

	/**
	 * 파일 정보 목록 조회
	 * 
	 * @param FileVO
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getFileInfoList(FileVO paramvo) {
		return getSqlSession().selectList(getFileMapper() + "getFileInfoList", paramvo);
	}
	
	/**
	 * 파일 정보 입력
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int insertFileInfo(FileVO paramvo) {
		return getSqlSession().insert(getFileMapper() + "insertFileInfo", paramvo);
	}
	
	/**
	 * 파일 정보 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateFileInfo(FileVO paramvo) {
		return getSqlSession().update(getFileMapper() + "updateFileInfo", paramvo);
	}
	
	/**
	 * 파일 정보 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteFileInfo(FileVO paramvo) {
		return getSqlSession().delete(getFileMapper() + "deleteFileInfo", paramvo);
	}
	
	
	/**
	 * 파일 사용 목록 조회
	 * 
	 * @param FileVO
	 * @return List<HashMap<String, Object>>
	 */
	public List<HashMap<String, Object>> getFileUsageList(FileVO paramvo) {
		return getSqlSession().selectList(getFileMapper() + "getFileUsageList", paramvo);
	}
	
	/**
	 * 파일 사용 정보 입력
	 * 
	 * @param FileVO
	 * @return integer
	 */
	public int insertFileUsage(FileVO paramvo) {
		return getSqlSession().insert(getFileMapper() + "insertFileUsage", paramvo);
	}
	
	/**
	 * 파일 사용 정보 수정
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int updateFileUsage(FileVO paramvo) {
		return getSqlSession().update(getFileMapper() + "updateFileUsage", paramvo);
	}
	
	/**
	 * 파일 사용 정보 삭제
	 * 
	 * @param paramvo
	 * @return integer
	 */
	public int deleteFileUsage(FileVO paramvo) {
		return getSqlSession().delete(getFileMapper() + "deleteFileUsage", paramvo);
	}

}
