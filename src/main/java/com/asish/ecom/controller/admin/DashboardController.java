package com.asish.ecom.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewDashBoard(Model m) {
		m.addAttribute("olo", "hello");
		return "admin/index";
	}
}
