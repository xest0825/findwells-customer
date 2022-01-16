package kr.co.fw.system.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
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
	
}
