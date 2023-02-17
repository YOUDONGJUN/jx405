package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.CustomerCriteria;
import com.example.service.CustomerService;
import com.example.utils.SessionUtils;
import com.example.vo.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/findIdPassword")
	public String findIdPassword() {
		return "/customer/findIdPassword";
	}
	
	@PostMapping("/resetPasswordForm")
	public String findPassword(CustomerCriteria criteria) {
		Customer customer = customerService.findIdPassword(criteria);
		SessionUtils.addAttribute("CUSTOMER_ID", customer.getId());
		
		return "/customer/resetPasswordForm";
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "/customer/signUp";
	}
}
