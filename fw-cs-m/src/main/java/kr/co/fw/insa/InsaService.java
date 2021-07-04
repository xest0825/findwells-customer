package kr.co.fw.insa;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.fw.erp.conf.InsaDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InsaService {

	@Autowired
	private InsaDAO dao;

	/**
	 * @Description : 사원정보 조회
	 * @author : lakhyun.kim
	 * @since : 2018. 05. 30
	 * @return : Map
	 * @throws : Exception
	 */
	public HashMap<String, Object> selectEmpInfo(InSaVO parametervo) throws Exception {
		HashMap<String, Object> empInfoMap = new HashMap<String, Object>();
		try {
			empInfoMap = dao.selectEmpInfo(parametervo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return empInfoMap;
	}
}
