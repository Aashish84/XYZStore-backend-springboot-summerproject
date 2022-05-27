package com.asish.ecom.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String logIn() {
		return "/admin/login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public RedirectView setLogIn(@RequestParam("user") String userString, @RequestParam("pwd") String pwString,
			HttpServletRequest request) {
		if (userString.equals(pwString) && userString.equals("admin")) {

			HttpSession session = request.getSession();
			session.setAttribute("admin", "helloadmin");
		}
		return new RedirectView("/admin");
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public RedirectView logInLogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return new RedirectView("/admin");
	}
}
