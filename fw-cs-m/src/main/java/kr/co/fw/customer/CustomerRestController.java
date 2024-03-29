package kr.co.fw.customer;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import kr.co.fw.board.BoardItemVO;
import kr.co.fw.common.file.FileVO;
import kr.co.fw.common.msg.MessageVO;
import kr.co.fw.common.util.CommUtil;
import kr.co.fw.common.util.CryptoUtil;
import kr.co.fw.common.util.FCMSendUtil;
import kr.co.fw.system.app.MobileAppVO;
import kr.co.fw.system.auth.AuthVO;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class CustomerRestController extends BaseController {

	/**
	 * 푸시 테스트
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value= {"/cs/push-test"})
	public ResponseEntity<HashMap<String, Object>> testpush(@RequestBody MobileAppVO vo) throws Exception {
		log.debug("test api");
		HashMap<String, Object> resultvo = new HashMap<String, Object>();
		String token[] = new String[10];
		//token[0] = "fEpepkUXyEx4jxOUxju0yp:APA91bHbGF7DNAjR0VGGR1aUTQgPInhVpBXLJG1_XQSrWmJrCah2T2_6ioQF98_y3y2JBV517PK4nY0vsDI1fe8Z3JysS5D_92gYELdW_Upvua4-7_Z8SYpRtqLCO3B7c3vstg-d8LSe";
		token[0] = vo.getPush_token();
		log.debug("/////////// TEST :"+ vo.getPush_token());
		log.debug("/////////// TEST :"+ token[0]);
		FCMSendUtil.pushFCMNotification(token,"푸시알림 테스트","testpush");
		ResponseEntity<HashMap<String, Object>> ret = new ResponseEntity<HashMap<String, Object> >(resultvo, HttpStatus.OK);
		return ret;
	}
	
	/**
	 * 사용자 디바이스 정보 조회
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value= {"/cs/user-device"})
	public ResponseEntity<HashMap<String, Object>> getUserDeviceList(MobileAppVO vo) throws Exception {
		log.debug("getUserDevice");
		HashMap<String, Object> result = new HashMap<String, Object>();
		result = getUserService().getUserDevice(vo);
		ResponseEntity<HashMap<String, Object>> ret = new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);
		return ret;
	}

	@GetMapping(value= {"/cs/login-info"})
	public ResponseEntity<HashMap<String, Object>> getUserLoginInfo(CustomerVO vo) throws Exception {
		log.debug("getUserLoginInfo");
		vo.setCust_id(vo.getUser_id());
		HashMap<String, Object> result = getUserService().getCustomerLoginInfo(vo);
		if (CommUtil.isNotEmpty(result)){
			result.put("res_cd", "OK");
		} else {
			result.put("res_cd", "FAIL");
		}
		ResponseEntity<HashMap<String, Object>> ret = new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);
		return ret;
	}
	
	/**
	 * 사용자 디바이스 정보 입력
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value= {"/cs/user-device"})
	public ResponseEntity<HashMap<String, Object>> insertAppConnectionLog(@RequestBody MobileAppVO vo) throws Exception {
		log.debug("insertAppConnectionLog");
		HashMap<String, Object> resultvo = new HashMap<String, Object>();
		getUserService().insertUserDevice(vo);
		ResponseEntity<HashMap<String, Object>> ret = new ResponseEntity<HashMap<String, Object> >(resultvo, HttpStatus.OK);
		return ret;
	}
	

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
	@PostMapping("/cs/join/join-customer2")
	public ResponseEntity<HashMap<String, Object>> joinCustomer2(@RequestBody CustomerVO paramvo) {
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
		retMap.put("user_id", cust_id);

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
		String contact_no = paramvo.getCust_cell();
		String mo_cd = paramvo.getMo_cd();
		log.info("cust_nm : " + cust_nm + ", cust_cell : " + contact_no + ", mo_cd : " + mo_cd);
		String resi_reg_no = "";
		String approved_yn = "N";
		String cust_id = "";
		String login_pw = "";
		
		// 1. 주민번호와 이름으로 고객을 검색한다. -> 이름과 휴대폰번호로 고객을 검색한다. (23.04.07)
		// cust_nm, cust_cell
		// paramvo.setCust_cell(null);
		log.info("고객명과 휴대폰 번호로 조회");
		List<HashMap<String, Object>> customerList = getCustomerService().getCustomerList(paramvo);
		if (customerList.size() == 0) {
			// 등록된 고객 없음.
			retMap.put("res_cd", "FAIL");
			retMap.put("msg", "등록된 고객 정보가 없습니다. 소개인에게 문의해주세요.");
			retMap.put("user_id", "");

		} else if (customerList.size() > 1) {
			// 동일 고객이 2명이상 등록됨.
			retMap.put("res_cd", "FAIL");
			retMap.put("msg", "동일한 고객명, 휴대전화 번호로 등록된 고객이 2명 이상입니다. 소개인에게 문의해주세요.");
			retMap.put("user_id", "");

		} else {
			custMap = customerList.get(0);

			// 업데이트 불필요
			//log.info("기존 고객 업데이트 CASE 2");
			//paramvo.setCust_cell(contact_no);
			cust_id = custMap.get("CUST_ID").toString();
			resi_reg_no = custMap.get("SSN").toString();
			//paramvo.setCust_id(cust_id);
			//getCustomerService().updateCustomer(paramvo);

			if (CommUtil.isEmpty(cust_id)) {
				log.info("cust_id is null, logical Error!!!!!!");
			}

			// cust_id 에 따라 cust_mobile과 cust_login을 입력하거나 수정한다.
			// paramvo.setCust_nm(cust_nm);
			// paramvo.setCust_cell(contact_no);
			paramvo.setSsn(resi_reg_no);
			paramvo.setCust_id(cust_id);

			// tbcs_customer_mobile list 조회
			List<HashMap<String, Object>> custUserMapList = getUserService().getCustomerUserList(paramvo);
			HashMap<String, Object> custUserMap = new HashMap<String, Object>();
			if (custUserMapList.size() > 1) {
				// tbcs_customer_mobile 정보가 2개이상 존재함.
				retMap.put("res_cd", "FAIL");
				retMap.put("msg", "동일한 고객명, 휴대전화 번호로 등록된 고객이 2명 이상입니다. 소개인에게 문의해주세요.");
				// retMap.put("msg", "동일한 고객명, 휴대전화 번호로 등록된 로그인 정보가 2명 이상입니다. 소개인에게 문의해주세요.");
				retMap.put("user_id", cust_id);
			} else {
				if (custUserMapList.size() == 0) {
					//HashMap<String, Object> custUserMap = getUserService().getCustomerUser(paramvo);
					// if (CommUtil.isEmpty(custUserMap)) {
					// 모바일 계정정보 입력
					// cust_id, cust_nm, ssn, cust_cell, mo_cd, approved_yn, data_dcd, in_emp_cd, in_dtm, up_emp_cd, up_dtm
					log.info("INSERT CustomerUser");
					paramvo.setApproved_yn(approved_yn);
					getUserService().insertCustomerUser(paramvo); // 모바일 고객 사용자 정보 입력

				} else if (custUserMapList.size() == 1) {
					// 모바일 계정정보 수정
					// cust_id, cust_nm, ssn, cust_cell, mo_cd, approved_yn, data_dcd, in_emp_cd, in_dtm, up_emp_cd, up_dtm
					log.info("UPDATE CustomerUser");
					paramvo.setApproved_yn(approved_yn);
					getUserService().updateCustomerUser(paramvo); // 모바일 고객 사용자 정보 수정
				}

				List<HashMap<String, Object>> custLoginList = getUserService().getCustomerLoginInfoList(paramvo);
				if (custLoginList.size() > 1) {
					retMap.put("res_cd", "FAIL");
					retMap.put("msg", "동일한 고객명, 휴대전화 번호로 등록된 로그인 정보가 2명 이상입니다. 소개인에게 문의해주세요.");
					retMap.put("user_id", cust_id);
				} else {
					if (custLoginList.size() == 0) {
						// custUserMap = getUserService().getCustomerLoginInfo(paramvo);
						// if (CommUtil.isEmpty(custUserMap)) {
						//paramvo.setApproved_yn(approved_yn);
						// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
						log.info("INSERT CustomerLogin");
						paramvo.setLogin_id(cust_id);
						try {
							paramvo.setLogin_pw(CryptoUtil.encrypt("0000"));
							paramvo.setSimpl_pw(CryptoUtil.encrypt("0000"));
						} catch (UnsupportedEncodingException | GeneralSecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						getUserService().insertCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보
						retMap.put("res_cd", "OK");
						retMap.put("msg", "고객 로그인 정보 입력");
						retMap.put("user_id", cust_id);

					} else {
						// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
						log.info("UPDATE CustomerLogin");
						//try {
						//paramvo.setSimpl_pw(CryptoUtil.encrypt(login_pw));
						//} catch (UnsupportedEncodingException | GeneralSecurityException e) {
						// TODO Auto-generated catch block
						//	e.printStackTrace();
						//}
						paramvo.setLogin_id(custLoginList.get(0).get("LOGIN_ID").toString());
						getUserService().updateCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보
						retMap.put("res_cd", "OK");
						retMap.put("msg", "고객 로그인 정보 수정");
						retMap.put("user_id", cust_id);

					}
				}
			}
		}

		log.info(retMap.toString());
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 간편 비밀번호 수정
	 * @param paramvo
	 * @return
	 */
	@PutMapping("/cs/simple-pw")
	public ResponseEntity<HashMap<String, Object>> updateSimplePassword(@RequestBody CustomerVO paramvo) {
		log.info("[PUT] /cs/simple-pw");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		HashMap<String, Object> custMap = new HashMap<String, Object>();
		
		String user_id = paramvo.getUser_id();
		String simpl_pw = paramvo.getSimpl_pw();
		
		// 로그인 ID 조회 
		MobileAppVO mvo = new MobileAppVO();
		mvo.setUser_id(user_id);
		// custMap = getUserService().getUserDevice(mvo);
		// log.info(custMap.toString());

		paramvo.setCust_id(user_id);
		custMap = getUserService().getCustomerLoginInfo(paramvo);
		String login_id = custMap.get("LOGIN_ID").toString(); // 대문자로 조회해야함.
		
		// 로그인 ID 설정 
		log.info(simpl_pw);
		log.info(login_id);
		paramvo.setLogin_id(login_id);
		
		// login_id, cust_id, devc_id, login_pw, simpl_pw, accnt_sts, expr_dt, in_dtm, up_dtm
		try {
			paramvo.setSimpl_pw(CryptoUtil.encrypt(simpl_pw));
		} catch (UnsupportedEncodingException | GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("UPDATE CustomerLogin");
		log.info(paramvo.toString());
		getUserService().updateCustomerLoginInfo(paramvo); // 모바일 고객 사용자 로그인 정보 

		retMap.put("res_cd","OK");

		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	

	/**
	 * 고객 계약 목록 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/customer-info")
	public ResponseEntity<HashMap<String, Object>> getCustomerInfo(CustomerVO paramvo) {
		log.info("getCustomerInfo");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		HashMap<String, Object> csMap = new HashMap<String, Object>();
		
		csMap = getUserService().getCustomerUser(paramvo);
		if (CommUtil.isNotEmpty(csMap)) {
			retMap.put("res_cd","OK");
			retMap.put("result", csMap);
		} else {
			retMap.put("res_cd","FAIL");
			retMap.put("result", "");
		}

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
	 * 게시글 목록 조회
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
	 * 게시글 조회
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
	
	/**
	 * 자산 인출 내역 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/asset-withdrawal-log")
	public ResponseEntity<HashMap<String, Object>> getAssetWithdrawalLogList(CustomerVO paramvo) {
		log.info("getMessageLogList");
		List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			retList = getCustomerService().getAssetWithdrawalLogList(paramvo);
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
	 * 자산 사용 계획 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/asset-plans")
	public ResponseEntity<HashMap<String, Object>> getAssetPlanList(CustomerVO paramvo) {
		log.info("getMessageLogList");
		List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			retList = getCustomerService().getAssetPlanList(paramvo);
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
	 * 금융사 비번 목록 조회
	 * @param paramvo
	 * @return
	 */
	@GetMapping("/cs/account-info-list")
	public ResponseEntity<HashMap<String, Object>> getAccountInfoList(CustomerAssetVO paramvo) {
		log.info("getAccountInfoList");
		List<HashMap<String, Object>> retList = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			retList = getCustomerService().getAccountInfoList(paramvo);
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
	 * 금융사 비번 목록 입력
	 * @param paramvo
	 * @return
	 */
	@PostMapping("/cs/account-info")
	public ResponseEntity<HashMap<String, Object>> insertAccountInfo(@RequestBody CustomerAssetVO paramvo) {
		log.info("insertAccountInfo");
		int ret = 0;
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			ret = getCustomerService().saveAccountInfo(paramvo);
			retMap.put("res_cd","OK");
			retMap.put("result", ret);
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
	 * 금융사 비번 목록 수정
	 * @param paramvo
	 * @return
	 */
	@PutMapping("/cs/account-info")
	public ResponseEntity<HashMap<String, Object>> updateAccountInfo(@RequestBody CustomerAssetVO paramvo) {
		log.info("insertAccountInfo");
		int ret = 0;
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			ret = getCustomerService().updateAccountInfo(paramvo);
			retMap.put("res_cd","OK");
			retMap.put("result", ret);
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
	 * 금융사 비번 목록 삭제 
	 * @param paramvo
	 * @return
	 */
	@DeleteMapping("/cs/account-info")
	public ResponseEntity<HashMap<String, Object>> deleteAccountInfo(@RequestBody CustomerAssetVO paramvo) {
		log.info("insertAccountInfo");
		int ret = 0;
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		try {
			ret = getCustomerService().deleteAccountInfo(paramvo);
			retMap.put("res_cd","OK");
			retMap.put("result", ret);
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
