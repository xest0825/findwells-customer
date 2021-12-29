package kr.co.fw.insa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InsaController extends BaseController {
	
	@Autowired
	InsaService insaService;
	
	@GetMapping("/fc/introducers")
	public ResponseEntity<List<HashMap<String, Object>>> getIntroducers() {
		log.info("[GET] /fc/introducers");
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		InSaVO insavo = new InSaVO();
		insavo.setMB_ID("YNG");
		try {
			list = insaService.getEmpList(insavo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseEntity<List<HashMap<String, Object>>> entity = new ResponseEntity<>(list, HttpStatus.OK);
		return entity;
	}

}
