package com.example.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.annotation.LoginedUser;
import com.example.exception.ErrorException;
import com.example.service.QnaService;
import com.example.vo.Customer;
import com.example.vo.Qna;
import com.example.vo.QnaImage;
import com.example.web.form.QnaInsertForm;

@Controller
public class QnaController {

	@Autowired
	QnaService qnaService;
	
	@PostMapping("/qna")
	public String addQna(@LoginedUser Customer customer, QnaInsertForm form) throws IOException {
		
		String saveDirectory = "D:\\HTA\\final-project\\hta-cinema\\src\\main\\webapp\\resources\\images";
		
		if (customer == null) {
			throw new ErrorException("로그인 후 사용 가능한 서비스입니다.");
		}
		
		List<MultipartFile> files = form.getUpfiles();
		List<QnaImage> images = new ArrayList<>();
		
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				QnaImage image = new QnaImage();
				String fileName = System.currentTimeMillis() + file.getOriginalFilename();
				
				image.setImageUrl(fileName);
				images.add(image);
				
				InputStream in = file.getInputStream();
				FileOutputStream out = new FileOutputStream(new File(saveDirectory, fileName));
				FileCopyUtils.copy(in, out);
			}
		}
		
		Qna qna = new Qna();
		BeanUtils.copyProperties(form, qna);
		qna.setCustomerNo(customer.getNo());
		
		qnaService.addQna(qna, images);
		
		return "redirect:/";
	}
}
