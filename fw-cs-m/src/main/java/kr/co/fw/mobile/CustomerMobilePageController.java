package kr.co.fw.mobile;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**
 * 메인
 */
@Slf4j
@Controller(value = "CustomerMobilePageController")
public class CustomerMobilePageController {
	
	/**
	 * @description 모바일 페이지로 이동
	 */
	@GetMapping(value = "/")
	public ModelAndView root(HttpServletRequest req) throws Exception {
		log.info("/");
		ModelAndView mav = new ModelAndView("customer/P00");
		return mav;
	}

	/**
	 * @description 모바일 페이지로 이동
	 */
	@GetMapping(value = "/m/{page_id}")
	public ModelAndView gopage(HttpServletRequest req, @PathVariable("page_id") String page_id) throws Exception {
		log.info("/m/page_id");
		ModelAndView mav = new ModelAndView("customer/"+page_id);
		return mav;
	}
	
	
	/**
	 * @description 어플 잠금비밀번호
	 */
	@GetMapping(value = "/m/P01/{user_id}")
	public ModelAndView p01(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/P01");
		ModelAndView mav = new ModelAndView("customer/P01");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 회원가입 약관동의
	 */
	@GetMapping(value = "/m/P02/{user_id}")
	public ModelAndView p02(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/P02");
		ModelAndView mav = new ModelAndView("customer/P02");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 회원가입
	 */
	@GetMapping(value = "/m/P03/{user_id}")
	public ModelAndView p03(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/P03");
		ModelAndView mav = new ModelAndView("customer/P03");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 잠금비밀번호 입력
	 */
	@GetMapping(value = "/m/P04/{user_id}")
	public ModelAndView p04(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/P04");
		ModelAndView mav = new ModelAndView("customer/P04");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 로딩 중
	 */
	@GetMapping(value = "/m/P05/{user_id}")
	public ModelAndView p05(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/P05");
		ModelAndView mav = new ModelAndView("customer/P05");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 패스워드 찾기
	 */
	@GetMapping(value = "/m/PE01/{user_id}")
	public ModelAndView pe01(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PE01");
		ModelAndView mav = new ModelAndView("customer/PE01");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 메인화면
	 */
	@GetMapping(value = "/m/PM01/{user_id}")
	public ModelAndView pm01(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM01");
		ModelAndView mav = new ModelAndView("customer/PM01");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 공지사항
	 */
	@GetMapping(value = "/m/PM02/{user_id}")
	public ModelAndView pm02(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM02");
		ModelAndView mav = new ModelAndView("customer/PM02");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @description 공지사항 내용보기
	 */
	@GetMapping(value = "/m/PM03/{user_id}/{item_no}")
	public ModelAndView pm03(HttpServletRequest req, @PathVariable("user_id") String user_id, @PathVariable("item_no") String item_no) throws Exception {
		log.info("/m/PM03");
		ModelAndView mav = new ModelAndView("customer/PM03");
		mav.addObject("user_id", user_id);
		mav.addObject("item_no", item_no);
		return mav;
	}
	
	/**
	 * @descriptio 가입내역
	 */
	@GetMapping(value = "/m/PM04/{user_id}")
	public ModelAndView pm04(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM04");
		ModelAndView mav = new ModelAndView("customer/PM04");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 가입내역 상세
	 */
	@GetMapping(value = "/m/PM05/{user_id}")
	public ModelAndView pm05(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM05");
		ModelAndView mav = new ModelAndView("customer/PM05");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 가입내역 상세
	 */
	@GetMapping(value = "/m/PM05/{user_id}/{seq}")
	public ModelAndView pm05(HttpServletRequest req, @PathVariable("user_id") String user_id, @PathVariable("seq") String seq) throws Exception {
		log.info("/m/PM05");
		ModelAndView mav = new ModelAndView("customer/PM05");
		mav.addObject("user_id", user_id);
		mav.addObject("cont_seq", seq);
		return mav;
	}
	
	/**
	 * @descriptio 메시지함
	 */
	@GetMapping(value = "/m/PM06/{user_id}")
	public ModelAndView pm06(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM06");
		ModelAndView mav = new ModelAndView("customer/PM06");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 인출내역
	 */
	@GetMapping(value = "/m/PM07/{user_id}")
	public ModelAndView pm07(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM07");
		ModelAndView mav = new ModelAndView("customer/PM07");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 인출내역 상세 
	 */
	@GetMapping(value = "/m/PM07_1/{user_id}")
	public ModelAndView pm07_1(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM07_1");
		ModelAndView mav = new ModelAndView("customer/PM07_1");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 자산사용계획 
	 */
	@GetMapping(value = "/m/PM08/{user_id}")
	public ModelAndView pm08(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM08");
		ModelAndView mav = new ModelAndView("customer/PM08");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 자산사용계획 상세 
	 */
	@GetMapping(value = "/m/PM08_1/{user_id}")
	public ModelAndView pm08_1(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM08_1");
		ModelAndView mav = new ModelAndView("customer/PM08_1");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 회사소개
	 */
	@GetMapping(value = "/m/PM09/{user_id}")
	public ModelAndView pm09(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM09");
		ModelAndView mav = new ModelAndView("customer/PM09");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 제휴사링크
	 */
	@GetMapping(value = "/m/PM10/{user_id}")
	public ModelAndView pm10(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM10");
		ModelAndView mav = new ModelAndView("customer/PM10");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 헬스케어
	 */
	@GetMapping(value = "/m/PM11/{user_id}")
	public ModelAndView pm11(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM11");
		ModelAndView mav = new ModelAndView("customer/PM11");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 헬스케어2
	 */
	@GetMapping(value = "/m/PM11_1/{user_id}")
	public ModelAndView pm11_1(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM11_1");
		ModelAndView mav = new ModelAndView("customer/PM11_1");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 패스워드 관리
	 */
	@GetMapping(value = "/m/PM12/{user_id}")
	public ModelAndView pm12(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM12");
		ModelAndView mav = new ModelAndView("customer/PM12");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 리포트 
	 */
	@GetMapping(value = "/m/PM13/{user_id}")
	public ModelAndView pm13(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM13");
		ModelAndView mav = new ModelAndView("customer/PM13");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 리포트2 
	 */
	@GetMapping(value = "/m/PM14/{user_id}/{item_no}")
	public ModelAndView pm14(HttpServletRequest req, @PathVariable("user_id") String user_id, @PathVariable("item_no") String item_no) throws Exception {
		log.info("/m/PM14");
		ModelAndView mav = new ModelAndView("customer/PM14");
		mav.addObject("user_id", user_id);
		mav.addObject("item_no", item_no);
		return mav;
	}
	
	/**
	 * @descriptio 유학서비스
	 */
	@GetMapping(value = "/m/PM15/{user_id}")
	public ModelAndView pm15(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM15");
		ModelAndView mav = new ModelAndView("customer/PM15");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 유학서비스 - 미국
	 */
	@GetMapping(value = "/m/PM15_1/{user_id}")
	public ModelAndView pm15_1(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM15_1");
		ModelAndView mav = new ModelAndView("customer/PM15_1");
		mav.addObject("user_id", user_id);
		return mav;
	}
	
	/**
	 * @descriptio 유학서비스 - 미국
	 */
	@GetMapping(value = "/m/PM17/{user_id}")
	public ModelAndView pm17(HttpServletRequest req, @PathVariable("user_id") String user_id) throws Exception {
		log.info("/m/PM15_1");
		ModelAndView mav = new ModelAndView("customer/PM17");
		mav.addObject("user_id", user_id);
		return mav;
	}

	

}
