package kr.co.fw.consultant;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

@Service
public class ConsultantService extends BaseService {
	
	public List<HashMap<String, Object>> getFCInfoList(ConsultantVO paramvo) {
		return getConsultantDAO().getFCInfoList(paramvo);
	}

	public int insertFCInfo(ConsultantVO paramvo) {
		return getConsultantDAO().insertFCInfo(paramvo);
	}

	public int updateFCInfo(ConsultantVO paramvo) {
		return getConsultantDAO().updateFCInfo(paramvo);
	}

	public int deleteFCInfo(ConsultantVO paramvo) {
		return getConsultantDAO().deleteFCInfo(paramvo);
	}

}
