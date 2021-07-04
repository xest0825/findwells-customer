package kr.co.fw.consultant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.fw.base.BaseController;

@Controller
public class ConsultantController extends BaseController {
	
	@RequestMapping("/fc/getFCInfoList.ajax")
	public ModelAndView getFCInfoList(HttpServletRequest req, @RequestBody ConsultantVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getConsultantService().getFCInfoList(paramvo));
		return mv;
	}
	
	@RequestMapping("/fc/insertFCInfo.ajax")
	public ModelAndView insertFCInfo(HttpServletRequest req, @RequestBody ConsultantVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getConsultantService().insertFCInfo(paramvo));
		return mv;
	}
	
	@RequestMapping("/fc/updateFCInfo.ajax")
	public ModelAndView updateFCInfo(HttpServletRequest req, @RequestBody ConsultantVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getConsultantService().updateFCInfo(paramvo));
		return mv;
	}
	
	@RequestMapping("/fc/deleteFCInfo.ajax")
	public ModelAndView deleteFCInfo(HttpServletRequest req, @RequestBody ConsultantVO paramvo) {
		ModelAndView mv = new ModelAndView("jsonView");
		mv.addObject("results", getConsultantService().deleteFCInfo(paramvo));
		return mv;
	}

	
}
