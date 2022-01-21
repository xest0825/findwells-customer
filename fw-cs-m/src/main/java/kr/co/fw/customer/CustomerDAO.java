package kr.co.fw.customer;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.fw.base.BaseDAO;

@Repository
public class CustomerDAO extends BaseDAO {

	public List<HashMap<String, Object>> getCustomerList(CustomerVO paramvo) {
		return getSqlSession().selectList(getCustomerMapper() + "getCustomerList", paramvo);
	}
	
	public String selectNewNo() {
		return getSqlSession().selectOne(getCustomerMapper(), "selectNewNo");
	}
	
	public int insertCustomer(CustomerVO paramvo) {
		return getSqlSession().insert(getCustomerMapper() + "insertCustomer", paramvo);
	}
	
	public int updateCustomer(CustomerVO paramvo) {
		return getSqlSession().update(getCustomerMapper() + "updateCustomer", paramvo);
	}
	
	public int deleteCustomer(CustomerVO paramvo) {
		return getSqlSession().delete(getCustomerMapper() + "deleteCustomer", paramvo);
	}
	
	public List<HashMap<String, Object>> getContractListByCustomer(CustomerVO paramvo) {
		return getSqlSession().selectList(getCustomerMapper() + "getContractListByCustomer", paramvo);
	}
	
	/* user-mapper */
	/* 
	public List<HashMap<String, Object>> getCustomerAccountList(CustomerVO paramvo) {
		return getSqlSession().selectList(getCustomerMapper() + "getCustomerAccountList", paramvo);
	}
	
	public int insertCustomerAccount(CustomerVO paramvo) {
		return getSqlSession().insert(getCustomerMapper() + "insertCustomerAccount", paramvo);
	}
	
	public int updateCustomerAccount(CustomerVO paramvo) {
		return getSqlSession().update(getCustomerMapper() + "updateCustomerAccount", paramvo);
	}
	
	public int deleteCustomerAccount(CustomerVO paramvo) {
		return getSqlSession().delete(getCustomerMapper() + "deleteCustomerAccount", paramvo);
	}
	*/
	
}
