package kr.co.fw.customer;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

@Service
public class CustomerService extends BaseService {

	public List<HashMap<String, Object>> getCustomerList(CustomerVO paramvo) {
		return getCustomerDAO().getCustomerList(paramvo);
	}
	
	public int insertCustomer(CustomerVO paramvo) {
		return getCustomerDAO().insertCustomer(paramvo);
	}
	
	public int updateCustomer(CustomerVO paramvo) {
		return getCustomerDAO().updateCustomer(paramvo);
	}
	
	public int deleteCustomer(CustomerVO paramvo) {
		return getCustomerDAO().deleteCustomer(paramvo);
	}
	
	public List<HashMap<String, Object>> getCustomerAccountList(CustomerVO paramvo) {
		return getCustomerDAO().getCustomerAccountList(paramvo);
	}
	
	public int insertCustomerAccount(CustomerVO paramvo) {
		return getCustomerDAO().insertCustomerAccount(paramvo);
	}
	
	public int updateCustomerAccount(CustomerVO paramvo) {
		return getCustomerDAO().updateCustomerAccount(paramvo);
	}
	
	public int deleteCustomerAccount(CustomerVO paramvo) {
		return getCustomerDAO().deleteCustomerAccount(paramvo);
	}
	
}
