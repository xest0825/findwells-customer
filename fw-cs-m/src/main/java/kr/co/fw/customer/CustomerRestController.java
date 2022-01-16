package kr.co.fw.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.system.auth.AuthVO;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerRestController extends BaseController {

	@GetMapping("/cs/join/login-accounts")
	public ResponseEntity<HashMap<String, Object>> checkLoginIdDuplicated(CustomerVO paramvo) {
		log.info("checkLoginIdDuplicated");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		HashMap<String, Object> userMap = new HashMap<String, Object>();
		
		User user = new User();
		user.setLogin_id(paramvo.getLogin_id());
		userMap = getLoginService().getUserMap(user);
		if (CommUtil.isNotEmpty(userMap)) {
			retMap.put("res_cd","OK");
			retMap.put("result", userMap);
		} else {
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/cs/auth/check-auth-no")
	public ResponseEntity<HashMap<String, Object>> joinCustomer(@RequestBody AuthVO paramvo) {
		log.info("[POST] /cs/auth/check-auth-no");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		List<HashMap<String, Object>> authList = new ArrayList<HashMap<String, Object>>();
		log.info(paramvo.getAuth_no());
		log.info(paramvo.getSeq());
		try {
			authList = getAuthService().selectAuthLogList(paramvo);
			if (authList.size() == 1) {
				retMap.put("res_cd","OK");
			} else {
				retMap.put("res_cd","FAIL");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retMap.put("res_cd","ERROR");
		}


		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/cs/join/join-customer")
	public ResponseEntity<HashMap<String, Object>> checkAuthNo(@RequestBody CustomerVO paramvo) {
		log.info("[POST] /cs/join/join-customer");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		String cust_nm = paramvo.getCust_nm();
		String resi_reg_no = paramvo.getSsn();
		String contact_no = paramvo.getCust_cell();
		String approved_yn = "N";
		String cust_id = "";
		
		// 1. 주민번호와 이름으로 고객을 검색한다. 
		// cust_nm, resi_reg_no
		paramvo.setCust_cell(null);
		retMap = getCustomerService().getCustomer(paramvo);
		if (CommUtil.isEmpty(paramvo)) {
			
			// 2. 휴대폰번호와 이름으로 고객을 검색한다. 
			// cust_nm, contact_no
			paramvo.setCust_cell(contact_no);
			paramvo.setSsn(null);
			retMap = getCustomerService().getCustomer(paramvo);
			
			// 3. 고객을 업데이트 하거나 생성한다. 
			if (CommUtil.isEmpty(retMap)) {
				
				// insertCustomer
				// 새로운 cust_id
				cust_id = getCustomerService().selectNewNo();
				paramvo.setCust_nm(cust_nm);
				paramvo.setSsn(resi_reg_no);
				paramvo.setCust_cell(contact_no);
				paramvo.setCust_id(cust_id);
				getCustomerService().insertCustomer(paramvo);
				
			} else {
				
				// updateCustomer
				// cust_nm, contact_no, resi_reg_no
				paramvo.setCust_nm(cust_nm);
				paramvo.setSsn(resi_reg_no);
				paramvo.setCust_cell(contact_no);
				getCustomerService().updateCustomer(paramvo);
			}
		} else {
			
			// 업데이트 
			paramvo.setCust_cell(contact_no);
			getCustomerService().updateCustomer(paramvo);
			
		}
		
		HashMap<String, Object> custUserMap = new HashMap<String, Object>();	
		custUserMap = getCustomerService().getCustomer(paramvo);
		if (CommUtil.isNotEmpty(custUserMap)) {
			cust_id = custUserMap.get("CUST_ID").toString();
		}
		
		// cust_id 에 따라 cust_mobile과 cust_login을 입력하거나 수정한다. 
		paramvo.setCust_nm(cust_nm);
		paramvo.setSsn(resi_reg_no);
		paramvo.setCust_cell(contact_no);
		paramvo.setCust_id(cust_id);
		custUserMap = getUserService().getCustomerUser(paramvo);
		if (CommUtil.isEmpty(custUserMap)) {
			// 모바일 계정정보 입력
			// cust_id, cust_nm, ssn, cust_cell, mo_cd, approved_yn, data_dcd, in_emp_cd, in_dtm, up_emp_cd, up_dtm
			paramvo.setApproved_yn(approved_yn);
			getUserService().insertCustomerUser(paramvo); // 모바일 고객 사용자 정보 
			
		} else {
			// 모바일 계정정보 수정
			// cust_id, cust_nm, ssn, cust_cell, mo_cd, approved_yn, data_dcd, in_emp_cd, in_dtm, up_emp_cd, up_dtm
			paramvo.setApproved_yn(approved_yn);
			getUserService().updateCustomerUser(paramvo); // 모바일 고객 사용자 정보 
			
		}
		
		
		custUserMap = getUserService().getCustomerLoginInfo(paramvo);
		if (CommUtil.isEmpty(custUserMap)) {
			//paramvo.setApproved_yn(approved_yn);
			// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
			getUserService().insertCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보 
			
		} else {
			// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
			getUserService().updateCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보 
			
		}
		


		retMap.put("res_cd","OK");

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}



}
