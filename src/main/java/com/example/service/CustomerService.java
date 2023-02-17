package com.example.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CustomerCriteria;
import com.example.exception.ErrorException;
import com.example.mapper.CustomerMapper;
import com.example.utils.SHA256Utils;
import com.example.vo.Customer;
import com.example.web.form.CustomerLoginForm;
import com.example.web.form.CustomerSignUpForm;

@Service
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	
	public Customer login(CustomerLoginForm form) throws NoSuchAlgorithmException {
		Customer customer = customerMapper.getCustomerById(form.getId());
		
		if (customer == null) {
			throw new ErrorException("아이디 또는 비밀번호가 맞지 않습니다.<br>"
					+ "로그인 정보를 다시 확인바랍니다.");
		}
		if ("Y".equals(customer.getDeleted())) {
			throw new ErrorException("탈퇴 처리된 회원입니다.");
		}
		
		String CustomerPassword = customer.getPassword();
		String formPassword = form.getPassword();
		String encryptedFormPassword;
		
		if (CustomerPassword.length() == 64) {
			encryptedFormPassword = SHA256Utils.encrypt(formPassword);
		} else {
			encryptedFormPassword = formPassword;
		}
		
		if (!CustomerPassword.equals(encryptedFormPassword)) {
			throw new ErrorException("아이디 또는 비밀번호가 맞지 않습니다.<br>"
					+ "로그인 정보를 다시 확인바랍니다.");
		}
		
		return customer;
	}
	
	public Customer findIdPassword(CustomerCriteria criteria) {
		Customer customer = customerMapper.getCustomerByCriteria(criteria);
		
		if (customer == null) {
			 throw new ErrorException("해당정보로 가입된 사용자를 찾을 수 없습니다.");
		}
		
		return customer;
	}
	
	public void updatePassword(String id, String password) {
		Customer customer = customerMapper.getCustomerById(id);
		
		if (customer == null) {
			throw new ErrorException("해당정보로 가입된 사용자를 찾을 수 없습니다.");
		}
		customer.setPassword(password);
		customerMapper.updateCustomer(customer);
	}
	
	// 같은 아이디가 존재하면 true를 반환한다.
	public boolean isIdDuplicate(String id) {
		Customer customer = customerMapper.getCustomerById(id);
		
		return customer != null;
	}
	
	public void insertCustomer(CustomerSignUpForm form) {
		customerMapper.insertCustomer(form);
	}
}
