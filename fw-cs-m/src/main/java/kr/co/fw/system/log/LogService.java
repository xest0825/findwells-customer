package kr.co.fw.system.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

@Service
public class LogService extends BaseService {

	public int insertConnectionLog(HashMap<String, String> paramap) {
		return getLogDAO().insertConnectionLog(paramap);
	}

	public int insertLoginLog(HashMap<String, Object> paramap) {
		return getLogDAO().insertLoginLog(paramap);
	}

	public String getLoginDtm(HashMap<String, Object> paramap) {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		List<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
		resultList = getLogDAO().getLoginLogList(paramap);
		if (resultList.size() > 0) {
			resultMap = resultList.get(0);
		}
		String result = "";
		if (resultMap.get("login_dtm") != null) {
			result = resultMap.get("login_dtm");
		}
		return result;
	}

	public int insertAppLoginLog(HashMap<String, String> paramap) {
		return getLogDAO().insertAppLoginLog(paramap);
	}

	public int insertActionLog(HashMap<String, String> paramap) {
		return getLogDAO().insertActionLog(paramap);
	}

	public int insertErrorLog(HashMap<String, String> paramap) {
		return getLogDAO().insertErrorLog(paramap);
	}
}
