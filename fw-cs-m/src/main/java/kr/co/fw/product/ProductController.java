package kr.co.fw.product;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.fw.base.BaseController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ProductController extends BaseController {

	@GetMapping("/products/{prod_id}/premium-amount")
	public ResponseEntity<HashMap<String, Object>> getPremiumAmt(@RequestBody ProductVO productvo) {
		log.info("list");
		HashMap<String, Object> retMap = new HashMap<String, Object>();
		ResponseEntity<HashMap<String, Object>> entity = new ResponseEntity<>(retMap, HttpStatus.OK);
		return entity;
	}

}
