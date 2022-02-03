package kr.co.fw.customer;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
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
import kr.co.fw.board.BoardItemVO;
import kr.co.fw.common.file.FileVO;
import kr.co.fw.common.msg.MessageVO;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.common.util.CryptoUtil;
import kr.co.fw.system.auth.AuthVO;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerRestController extends BaseController {

	/**
	 * 로그인 계정 중복 확인
	 * @param paramvo
	 * @return
	 */
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
	
	/**
	 * 인증번호 확인
	 * @param paramvo
	 * @return
	 */
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
	
	/**
	 * 고객 가입 
	 * @param paramvo
	 * @return
	 */
	@PostMapping("/cs/join/join-customer")
	public ResponseEntity<HashMap<String, Object>> checkAuthNo(@RequestBody CustomerVO paramvo) {
		log.info("[POST] /cs/join/join-customer");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		HashMap<String, Object> custMap = new HashMap<String, Object>();
		
		String cust_nm = paramvo.getCust_nm();
		String resi_reg_no = paramvo.getSsn();
		String contact_no = paramvo.getCust_cell();
		String approved_yn = "N";
		String cust_id = "";
		String login_pw = paramvo.getLogin_pw();
		
		// 1. 주민번호와 이름으로 고객을 검색한다. 
		// cust_nm, resi_reg_no
		paramvo.setCust_cell(null);
		log.info("고객명과 주민번호로 조회");
		custMap = getCustomerService().getCustomer(paramvo);
		if (CommUtil.isEmpty(custMap)) {
			
			// 2. 휴대폰번호와 이름으로 고객을 검색한다. 
			// cust_nm, contact_no
			paramvo.setCust_cell(contact_no);
			paramvo.setSsn(null);
			log.info("고객명과 휴대폰번호로 조회");
			custMap = getCustomerService().getCustomer(paramvo);
			
			// 3. 고객을 업데이트 하거나 생성한다. 
			if (CommUtil.isEmpty(custMap)) {
				
				// insertCustomer
				// 새로운 cust_id
				log.info("새로운 고객으로 입력 CASE 1-1");
				paramvo.setCust_nm(cust_nm);
				paramvo.setSsn(resi_reg_no);
				paramvo.setCust_cell(contact_no);
				//cust_id = getCustomerService().selectNewNo();
				getCustomerService().insertCustomer(paramvo);
				cust_id = paramvo.getCust_id();
				
			} else {
				
				// updateCustomer
				// cust_nm, contact_no, resi_reg_no
				log.info("기존 고객 업데이트 CASE 1-2");
				paramvo.setCust_nm(cust_nm);
				paramvo.setSsn(resi_reg_no);
				paramvo.setCust_cell(contact_no);
				cust_id = custMap.get("CUST_ID").toString();
				paramvo.setCust_id(cust_id);
				getCustomerService().updateCustomer(paramvo);
			}
		} else {
			
			// 업데이트 
			log.info("기존 고객 업데이트 CASE 2");
			paramvo.setCust_cell(contact_no);
			cust_id = custMap.get("CUST_ID").toString();
			paramvo.setCust_id(cust_id);
			getCustomerService().updateCustomer(paramvo);
			
		}
		
		HashMap<String, Object> custUserMap = new HashMap<String, Object>();	
		if (CommUtil.isEmpty(cust_id)) {
			log.info("cust_id : " + cust_id);	
			log.info("logic Error!!!!!!");
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
			log.info("INSERT CustomerUser");
			paramvo.setApproved_yn(approved_yn);
			getUserService().insertCustomerUser(paramvo); // 모바일 고객 사용자 정보 
			
		} else {
			// 모바일 계정정보 수정
			// cust_id, cust_nm, ssn, cust_cell, mo_cd, approved_yn, data_dcd, in_emp_cd, in_dtm, up_emp_cd, up_dtm
			log.info("UPDATE CustomerUser");
			paramvo.setApproved_yn(approved_yn);
			getUserService().updateCustomerUser(paramvo); // 모바일 고객 사용자 정보 
			
		}
		
		
		custUserMap = getUserService().getCustomerLoginInfo(paramvo);
		if (CommUtil.isEmpty(custUserMap)) {
			//paramvo.setApproved_yn(approved_yn);
			// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
			log.info("INSERT CustomerLogin");
			try {
				paramvo.setLogin_pw(CryptoUtil.encrypt(login_pw));
			} catch (UnsupportedEncodingException | GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getUserService().insertCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보 
			
		} else {
			// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
			log.info("UPDATE CustomerLogin");
			try {
				paramvo.setLogin_pw(CryptoUtil.encrypt(login_pw));
			} catch (UnsupportedEncodingException | GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getUserService().updateCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보 
			
		}
		


		retMap.put("res_cd","OK");

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 고객 계약 목록 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/contracts")
	public ResponseEntity<HashMap<String, Object>> getContractListByCustomer(CustomerVO paramvo) {
		log.info("getContractListByCustomer");
		List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		retList = getCustomerService().getContractListByCustomer(paramvo);
		if (CommUtil.isNotEmpty(retList)) {
			retMap.put("res_cd","OK");
			retMap.put("result", retList);
		} else {
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 계약 파일 목록 조회 
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/contract/files")
	public ResponseEntity<HashMap<String, Object>> getContractFileList(CustomerVO paramvo) {
		log.info("getContractListByCustomer");
		List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		FileVO file  = new FileVO();
		//retList = getFileService().getFileInfoList(file);
		if (CommUtil.isNotEmpty(retList)) {
			retMap.put("res_cd","OK");
			retMap.put("result", retList);
		} else {
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 메시지 이력 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/messages")
	public ResponseEntity<HashMap<String, Object>> getMessageLogList(MessageVO paramvo) {
		log.info("getMessageLogList");
		List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		retList = getMessageService().getMessageLogList(paramvo);
		if (retList.size() > 0) {
			retMap.put("res_cd","OK");
			retMap.put("result", retList);
		} else {
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 메시지 이력 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/notice-items")
	public ResponseEntity<HashMap<String, Object>> getNoticeItemList(BoardItemVO paramvo) {
		log.info("getMessageLogList");
		List<BoardItemVO> retList = new ArrayList<BoardItemVO>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			retList = getBoardService().selectBoardItemList2(paramvo);
			retMap.put("res_cd","OK");
			retMap.put("result", retList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 메시지 이력 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/notice-item")
	public ResponseEntity<HashMap<String, Object>> getNoticeItem(BoardItemVO paramvo) {
		log.info("getMessageLogList");
		BoardItemVO retvo = new BoardItemVO();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			retvo = getBoardService().selectBoardItem(paramvo);
			retMap.put("res_cd","OK");
			retMap.put("result", retvo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}



}
