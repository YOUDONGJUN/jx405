package com.example.web.controller;

import com.example.service.ReviewService;
import com.example.vo.ReviewPointType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/movie/list")
    public String movieList() {
        return "/movie/list";
    }

    @GetMapping("/movie/detail")
    public String movieDetail(int no, Model model) {
        List<ReviewPointType> pointTypes = reviewService.getAllPointTypes();

        model.addAttribute("pointTypes", pointTypes);

        return "/movie/detail";
    }
}
