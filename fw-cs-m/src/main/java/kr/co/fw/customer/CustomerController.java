package kr.co.fw.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fw.base.BaseController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController extends BaseController {

	@RequestMapping("/cs/getCustomerList.ajax")
	public ModelAndView getCustomerList(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		log.info("");
		mv.addObject("results", getCustomerService().getCustomerList(paramvo));
		return mv;
	}

	@RequestMapping("/cs/insertCustomer.ajax")
	public ModelAndView insertCustomer(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().insertCustomer(paramvo));
		return mv;
	}

	@RequestMapping("/cs/updateCustomer.ajax")
	public ModelAndView updateCustomer(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().updateCustomer(paramvo));
		return mv;
	}

	@RequestMapping("/cs/deleteCustomer.ajax")
	public ModelAndView deleteCustomer(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().deleteCustomer(paramvo));
		return mv;
	}

	@RequestMapping("/cs/getCustomerAccountList.ajax")
	public ModelAndView getCustomerAccountList(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().getCustomerAccountList(paramvo));
		return mv;
	}

	@RequestMapping("/cs/insertCustomerAccount.ajax")
	public ModelAndView insertCustomerAccount(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().insertCustomerAccount(paramvo));
		return mv;
	}

	@RequestMapping("/cs/updateCustomerAccount.ajax")
	public ModelAndView updateCustomerAccount(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().updateCustomerAccount(paramvo));
		return mv;
	}

	@RequestMapping("/cs/deleteCustomerAccount.ajax")
	public ModelAndView deleteCustomerAccount(HttpServletRequest req, @RequestBody CustomerVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getCustomerService().deleteCustomerAccount(paramvo));
		return mv;
	}

}
