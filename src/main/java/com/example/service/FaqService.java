package com.example.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.FaqDto;
import com.example.mapper.FaqMapper;
import com.example.web.form.FaqCriteria;

@Service
@Transactional
public class FaqService {

	static final Logger logger = LogManager.getLogger(FaqService.class);
	
	@Autowired
	private FaqMapper faqMapper;
	
	public int getFaqRows(FaqCriteria criteria) {
		return faqMapper.getFaqTotalRows(criteria);
	}
	
	public List<FaqDto> getAllFaq(FaqCriteria criteria) {
		logger.info("조건"+criteria);
		return faqMapper.getAllFaq(criteria);
	}
}
