package kr.co.fw.system.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kr.co.fw.base.BaseController;
import kr.co.fw.system.security.model.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController extends BaseController {
	
	/**
	 * 사용자 조회
	 * 
	 * @param UserVO
	 * @return ResponseEntity<List<HashMap>>
	 */
	@GetMapping("/admin/users")
	public ResponseEntity<List<HashMap<String, Object>>> getUserList(UserVO paramvo) {
		log.info("geUserList");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	
		list = getUserService().getUserList(paramvo);

		ResponseEntity<List<HashMap<String, Object>>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 사용자 수 조회
	 * 
	 * @param UserVO
	 * @return ResponseEntity<List<HashMap>>
	 */
	@GetMapping("/admin/users-cnt")
	public ResponseEntity<HashMap<String, Object>> getUserListCnt(UserVO paramvo) {
		log.info("getUserListCnt");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		
		int ret = getUserService().getUserListCnt(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("user_cnt", ret);
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 사용자 입력
	 * 
	 * @param User
	 * @return ResponseEntity<HashMap>
	 */
	@PostMapping("/admin/users")
	public ResponseEntity<HashMap<String, Object>> insertUser(HttpServletRequest req, @RequestBody User paramvo) {
		log.info("insertUser");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		getUserService().insertUser(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("msg", "사용자 입력 성공");
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 메뉴 수정
	 * 
	 * @param User
	 * @return ResponseEntity<HashMap>
	 */
	@PutMapping("/admin/users/{user_id}")
	public ResponseEntity<HashMap<String, Object>> updateUser(HttpServletRequest req, @PathVariable("user_id") String user_id, @RequestBody User paramvo) {
		log.info("updateUser");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		paramvo.setUser_id(user_id);
		getUserService().updateUser(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("msg", "사용자 수정 성공");
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 메뉴 삭제
	 * 
	 * @param User
	 * @return ResponseEntity<HashMap>
	 */
	@DeleteMapping("/admin/users/{user_id}")
	public ResponseEntity<HashMap<String, Object>> deleteUser(HttpServletRequest req, @PathVariable("user_id") String user_id, @RequestBody User paramvo) {
		log.info("deleteUser");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		paramvo.setUser_id(user_id);
		getUserService().deleteUser(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("msg", "사용자 삭제 성공");
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}

	
	
	
	
	/* ==========================   [사용자 기기 정보]  =========================== */
	
	/**
	 * 사용자 - 기기 매핑정보 조회
	 * 
	 * @param UserVO
	 * @return ResponseEntity<List<HashMap>>
	 */
	@GetMapping("/admin/users/devc/{fc_id}")
	public ResponseEntity<HashMap<String, Object>> getDevcInfoList(HttpServletRequest req,
			@PathVariable("fc_id") String fc_id, UserVO paramvo) {
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		log.info("test");
		paramvo.setUser_id(fc_id);
		retMap = getUserService().getDevcList(paramvo);
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 사용자 - 기기 매핑정보 입력
	 * 
	 * @param User
	 * @return ResponseEntity<HashMap>
	 */
	@PostMapping("/user/devc")
	public ResponseEntity<HashMap<String, Object>> insertDevc(HttpServletRequest req, @RequestBody User paramvo) {
		log.info("insertDevc");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		getUserService().insertDevc(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("msg", "사용자-기기 매핑정보 입력 성공");
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	

	
	/**
	 * 사용자 - 기기 매핑정보 수정
	 * 
	 * @param User
	 * @return ResponseEntity<HashMap>
	 */
	@PutMapping("/user/devc/{user_id}")
	public ResponseEntity<HashMap<String, Object>> updateDevc(HttpServletRequest req, @PathVariable("user_id") String user_id, @RequestBody User paramvo) {
		log.info("updateDevc");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		paramvo.setUser_id(user_id);
		getUserService().updateDevc(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("msg", "사용자-기기 매핑정보 수정 성공");
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}
	
	/**
	 * 사용자 - 기기 매핑정보 삭제
	 * 
	 * @param User
	 * @return ResponseEntity<HashMap>
	 */
	@DeleteMapping("/user/devc/{user_id}")
	public ResponseEntity<HashMap<String, Object>> deleteDevc(HttpServletRequest req, @PathVariable("user_id") String user_id, @RequestBody User paramvo) {
		log.info("deleteUser");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		paramvo.setUser_id(user_id);
		getUserService().deleteDevc(paramvo);
		retMap.put("res_cd", "OK");
		retMap.put("msg", "사용자-기기 매핑정보 삭제 성공");
		
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}

}
