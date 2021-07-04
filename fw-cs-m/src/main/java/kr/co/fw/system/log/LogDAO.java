package kr.co.fw.system.log;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class LogDAO extends BaseDAO {

	public int insertConnectionLog(HashMap<String, String> paramap) {
		return getSqlSession().insert(getLogMapper() + "insertConnectionLog", paramap);
	}

	public int insertLoginLog(HashMap<String, Object> paramap) {
		return getSqlSession().insert(getLogMapper() + "insertLoginLog", paramap);
	}

	public List<HashMap<String, String>> getLoginLogList(HashMap<String, Object> paramap) {
		return getSqlSession().selectList(getLogMapper() + "getLoginLogList", paramap);
	}

	public int insertAppLoginLog(HashMap<String, String> paramap) {
		return getSqlSession().insert(getLogMapper() + "insertAppLoginLog", paramap);
	}

	public int insertActionLog(HashMap<String, String> paramap) {
		return getSqlSession().insert(getLogMapper() + "insertActionLog", paramap);
	}

	public int insertErrorLog(HashMap<String, String> paramap) {
		return getSqlSession().insert(getLogMapper() + "insertErrorLog", paramap);
	}

}
