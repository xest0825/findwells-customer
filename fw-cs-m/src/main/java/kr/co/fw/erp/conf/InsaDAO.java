package kr.co.fw.erp.conf;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.fw.insa.InSaVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class InsaDAO {

	private static final String SQL_PREFIX = "Insa.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	/**
	 * @Description : 사원정보 조회
	 * @author : lakhyun.kim
	 * @since : 2018. 05. 23
	 * @return : Map
	 * @throws : Exception
	 */
	public HashMap<String, Object> selectEmpInfo(InSaVO paramvo) throws Exception {
		HashMap<String, Object> empInfoMap = new HashMap<String, Object>();
		try {
			empInfoMap = sqlSession.selectOne(SQL_PREFIX + "selectEmpInfo", paramvo);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return empInfoMap;
	}

}
