package kr.co.fw.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.fw.base.BaseService;

@Service
public class CustomerService extends BaseService {

	public List<HashMap<String, Object>> getCustomerList(CustomerVO paramvo) {
		return getCustomerDAO().getCustomerList(paramvo);
	}
	
	public HashMap<String, Object> getCustomer(CustomerVO paramvo) {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		list = getCustomerDAO().getCustomerList(paramvo);
		if (list.size() > 0) {
			retMap = list.get(0);
		}
		return retMap;
	}
	
	public String selectNewNo() {
		return getCustomerDAO().selectNewNo();
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
	
	public HashMap<String, Object> saveAndGetCustomer(CustomerVO paramvo) {
		CustomerVO retCS = new CustomerVO();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> customerList = new ArrayList<HashMap<String, Object>>();
		if (customerList.size() > 0) {
			getCustomerDAO().updateCustomer(paramvo);
		} else {
			getCustomerDAO().insertCustomer(paramvo);
		}
		customerList = getCustomerDAO().getCustomerList(paramvo);
		if (customerList.size() > 0) {
			retMap = customerList.get(0);
		}
		
		return retMap;
	}
	
	public List<HashMap<String, Object>> getContractListByCustomer(CustomerVO paramvo) {
		return getCustomerDAO().getContractListByCustomer(paramvo);
	}
	
	public List<HashMap<String, Object>> getAssetWithdrawalLogList(CustomerVO paramvo) {
		return getCustomerDAO().getAssetWithdrawalLogList(paramvo);
	}
	
	public List<HashMap<String, Object>> getAssetPlanList(CustomerVO paramvo) {
		return getCustomerDAO().getAssetPlanList(paramvo);
	}
	
}
