package com.example.web.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.FaqDto;
import com.example.dto.ResponseDto;
import com.example.pagination.Pagination;
import com.example.service.FaqService;
import com.example.web.form.FaqCriteria;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest")
public class SupportsRestController {

	@Autowired
	private FaqService faqService;
	
	@GetMapping("/supports/faq")
	public ResponseDto<Map<String, Object>> faq(FaqCriteria criteria, Model model) {
		
		if (criteria.getPage() < 1) {
			criteria.setPage(1);
		}
		
		ResponseDto<Map<String, Object>> response = new ResponseDto<>();
		
		int totalRecords = faqService.getFaqRows(criteria);
		
		Pagination pagination = new Pagination(criteria.getPage(), totalRecords);
		criteria.setBeginIndex(pagination.getBegin());
		criteria.setEndIndex(pagination.getEnd());
		String option = criteria.getOption();
		
		List<FaqDto> faqList = faqService.getAllFaq(criteria);
		
		log.info("페이지: "+criteria.getPage());
		log.info("조건: "+criteria);
		
		response.setStatus(true);
		response.setItems(Map.of("pagination", pagination, "faqList", faqList, "option", option));
		
		return response;
	}
}
