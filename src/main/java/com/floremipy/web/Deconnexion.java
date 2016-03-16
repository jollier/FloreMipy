package com.floremipy.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Deconnexion {

		@RequestMapping(value = "/Deconnexion", method = RequestMethod.GET)
		public String deconnexion(HttpSession session) {
			session.setAttribute("login", null);
			session.setAttribute("id", null);
			session.invalidate();
			return "accueil";
		}
}
