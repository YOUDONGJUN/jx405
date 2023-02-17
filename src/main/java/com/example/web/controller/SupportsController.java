package com.example.web.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.FaqService;
import com.example.service.QnaService;
import com.example.service.TheaterService;
import com.example.vo.QnaType;
import com.example.vo.Region;

@Controller
public class SupportsController {

	@Autowired
	private TheaterService theaterService;
	@Autowired
	private QnaService qnaService;
	
	static final Logger logger = LogManager.getLogger(SupportsController.class);
	
	@GetMapping("/supports")
	public String supports() {
		return "/supports/faq";
	}
	
	@GetMapping("/supports/inquiry")
	public String inquiry(Model model) {
		
		List<Region> regions = theaterService.getAllRegion();
		List<QnaType> categories = qnaService.getAllCategories();
		
		model.addAttribute("regions", regions);
		model.addAttribute("categories", categories);
		
		return "/supports/inquiry";
	}
}
