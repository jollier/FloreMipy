package com.floremipy.user.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.floremipy.model.customer.dto.CustomerDto;
import com.floremipy.model.customer.service.ICustomerService;

@Controller
public class IdentController {
	
	@Autowired
	ICustomerService monService;
	
	
	@RequestMapping("/index")
	
	public ModelAndView test(){
		return new ModelAndView("index");
	}
	
	 @RequestMapping(value = "/identification", method = RequestMethod.GET)
	public ModelAndView identification(Model model,HttpServletRequest request){
//		 String login = request.getParameter("Email"); 
//		 System.out.print("XXXXXXXXXXXXXXX" +login);
//	     message
		return new ModelAndView("identification");
	}
	 
	 
	 @RequestMapping(value = "/identification", method = RequestMethod.POST)
		public ModelAndView identification2(Model model,HttpServletRequest request){
			 String login = request.getParameter("Email"); 
			 String pwd = request.getParameter("Password"); 
			 //
			 System.out.print("XXXXXXXXXXXXXXX" +login);
			 System.out.print("yyyyyyyyyyyyyy" + pwd);
		      // model.addAttribute("message", "Login ou mot de passe incorrect");
		    CustomerDto monCus= monService.getCustomerByLoginAndPassword(login, pwd);
		// monCus.getId()
		return new ModelAndView("index");
		}
}
