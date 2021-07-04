package kr.co.fw.api;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class ApiDAO extends BaseDAO {
	
	public int updateProcessDetail(HashMap<String, Object> paramMap) {
		return 1;
	}

}
