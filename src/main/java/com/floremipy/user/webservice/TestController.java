package com.floremipy.user.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/index")
	public ModelAndView test(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/identification")
	public ModelAndView identification(){
		return new ModelAndView("identification");
	}
}
