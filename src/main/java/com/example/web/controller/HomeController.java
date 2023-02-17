package com.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.annotation.LoginedUser;
import com.example.utils.SessionUtils;
import com.example.vo.Customer;
import com.example.web.form.InsertTicketForm;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "HTA CINEMA 방문을 환영합니다.");
		
		return "home";	// prefix="/WEB-INF/views/" viewName="home" suffix=".jsp"
	}

	@GetMapping("/logout")
	public String logout() {
		SessionUtils.sessionInvalidate();
		
		return "redirect:/";
	}

	@GetMapping("/timeTable/timeTable")
	public String timeTable() {
		return "/timeTable/timeTable";
	}
}