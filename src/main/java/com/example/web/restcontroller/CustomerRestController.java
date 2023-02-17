package com.example.web.restcontroller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CustomerCriteria;
import com.example.dto.ResponseDto;
import com.example.exception.ErrorException;
import com.example.service.CustomerService;
import com.example.utils.SHA256Utils;
import com.example.utils.SessionUtils;
import com.example.vo.Customer;
import com.example.web.form.CustomerLoginForm;
import com.example.web.form.CustomerSignUpForm;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/login")
	public ResponseDto<?> login(@RequestBody CustomerLoginForm form) throws NoSuchAlgorithmException {
		ResponseDto<?> response = new ResponseDto<>();
		
		Customer customer = customerService.login(form);
		SessionUtils.addAttribute("LOGIN_USER", customer);
		
		response.setStatus(true);
		
		return response;
	}
	
	@PostMapping("/findIdPassword")
	public ResponseDto<Customer> findIdPassword(@RequestBody CustomerCriteria criteria) {
		ResponseDto<Customer> response = new ResponseDto<Customer>();
		
		Customer customer = customerService.findIdPassword(criteria);
		
		if ("id".equals(criteria.getFind())) {
			String id = customer.getId();
			String partiallyEncryptedId = id.substring(0, id.length() - 2) + "**";
			
			Customer customerToSend = Customer.builder()
					.id(partiallyEncryptedId)
					.createdDate(customer.getCreatedDate())
					.build();
			
			response.setStatus(true);
			response.setItems(customerToSend);
			
			return response;
		}
		response.setStatus(true);
		
		return response;
	}
	
	@PostMapping("/resetPassword")
	public ResponseDto<String> restPassword(@RequestBody HashMap<String, String> request) throws NoSuchAlgorithmException {
		ResponseDto<String> response = new ResponseDto<>();
		
		if (SessionUtils.getAttribute("CUSTOMER_ID") == null) {
			throw new ErrorException("잘못된 접근입니다.");
		}
		
		String id = (String)SessionUtils.getAttribute("CUSTOMER_ID");
		customerService.updatePassword(id, SHA256Utils.encrypt(request.get("newPassword")));
		SessionUtils.sessionInvalidate();
		
		response.setStatus(true);
		response.setItems("비밀번호 변경이 완료되었습니다.<br>"
				+ "재로그인해주세요.");
		
		return response;
	}
	
	@PostMapping("/checkIdDuplicate")
	public ResponseDto<HashMap<String, Object>> checkIdDuplicate(String id) {
		ResponseDto<HashMap<String, Object>> response = new ResponseDto<>();
		HashMap<String, Object> items = new HashMap<>();
		
		if (customerService.isIdDuplicate(id)) {
			items.put("isIdDuplicate", true);
			items.put("message", "이미 사용중인 ID입니다.");
		} else {
			items.put("isIdDuplicate", false);
			items.put("message", "사용가능한 ID입니다.");
		}
		response.setItems(items);
		response.setStatus(true);
		
		return response;
	}
	
	@PostMapping("/signUp")
	public ResponseDto<String> signUp(@RequestBody CustomerSignUpForm form) throws NoSuchAlgorithmException {
		ResponseDto<String> response = new ResponseDto<>();
		
		form.setPassword(SHA256Utils.encrypt(form.getPassword()));
		customerService.insertCustomer(form);
		
		response.setStatus(true);
		response.setItems("회원가입이 완료되었습니다.");
		
		return response;
	}
}
