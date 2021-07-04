package kr.co.fw.common.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RestCodeController extends BaseController {

	@GetMapping("/groupCodes")
	public ResponseEntity<List<HashMap<String, Object>>> listGroupCode() {
		log.info("list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		CodeVO codevo = new CodeVO();
		list = getCodeService().getGroupCodeList(codevo);
		
		ResponseEntity<List<HashMap<String, Object>>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}
	
	@PostMapping("/groupCodes")
	public ResponseEntity<String> registerGroupCode(@RequestBody CodeVO codevo) {
		log.info("register");
		log.info(codevo.toString());
		int result = 0;
		result = getCodeService().insertGroupCode(codevo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		if (result > 0) {
			
		} else {
			entity = new ResponseEntity<>("FAIL", HttpStatus.OK);
		}
		return entity;
	}
	
	@PutMapping("/groupCodes/{grp_cd}")
	public ResponseEntity<String> modifyGroupCode(@PathVariable String grp_cd, @RequestBody CodeVO codevo) {
		log.info("modify");
		log.info(codevo.toString());
		int result = 0;
		codevo.setGrp_cd(grp_cd);
		result = getCodeService().updateCode(codevo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		if (result > 0) {
			
		} else {
			entity = new ResponseEntity<>("FAIL", HttpStatus.OK);
		}
		return entity;
	}
	
	@DeleteMapping("/groupCodes/{grp_cd}")
	public ResponseEntity<String> removeGroupCode(@PathVariable String grp_cd) {
		log.info("remove / " + grp_cd);
		CodeVO codevo = new CodeVO();
		codevo.setGrp_cd(grp_cd);
		int result = getCodeService().updateCode(codevo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		if (result > 0) {
			
		} else {
			entity = new ResponseEntity<>("FAIL", HttpStatus.OK);
		}
		return entity;
	}
	
	
	@GetMapping("/codes")
	public ResponseEntity<List<HashMap<String, Object>>> list() {
		log.info("list");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		CodeVO codevo = new CodeVO();
		list = getCodeService().getCodeList(codevo);

		ResponseEntity<List<HashMap<String, Object>>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}

	@PostMapping("/codes")
	public ResponseEntity<String> register(@RequestBody CodeVO codevo) {
		log.info("register");
		log.info(codevo.toString());
		int result = 0;
		result = getCodeService().insertCode(codevo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		if (result > 0) {

		} else {
			entity = new ResponseEntity<>("FAIL", HttpStatus.OK);
		}
		return entity;
	}

	@PutMapping("/codes/{grp_cd}/{cd}")
	public ResponseEntity<String> modify(@PathVariable String grp_cd, @PathVariable String cd,
			@RequestBody CodeVO codevo) {
		log.info("modify");
		log.info(codevo.toString());
		int result = 0;
		codevo.setGrp_cd(grp_cd);
		codevo.setCd(cd);
		result = getCodeService().updateCode(codevo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		if (result > 0) {

		} else {
			entity = new ResponseEntity<>("FAIL", HttpStatus.OK);
		}
		return entity;
	}

	@DeleteMapping("/codes/{grp_cd}/{cd}")
	public ResponseEntity<String> remove(@PathVariable String grp_cd, @PathVariable String cd) {
		log.info("remove / " + grp_cd + " / " + cd);
		CodeVO codevo = new CodeVO();
		codevo.setGrp_cd(grp_cd);
		codevo.setCd(cd);
		int result = getCodeService().updateCode(codevo);
		ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		if (result > 0) {

		} else {
			entity = new ResponseEntity<>("FAIL", HttpStatus.OK);
		}
		return entity;
	}

}
