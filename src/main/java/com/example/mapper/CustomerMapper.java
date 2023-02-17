package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.CustomerCriteria;
import com.example.vo.Customer;
import com.example.web.form.CustomerSignUpForm;

@Mapper
public interface CustomerMapper {
	Customer getCustomerById(String id);
	Customer getCustomerByCriteria(CustomerCriteria criteria);
	void updateCustomer(Customer customer);
	void insertCustomer(CustomerSignUpForm form);
}
