package com.example.web.controller;

import com.example.dto.TheaterDto;
import com.example.service.TheaterDetailService;
import com.example.service.TheaterService;
import com.example.vo.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;
    @Autowired
    TheaterDetailService theaterDetailService;

    @GetMapping("/list")
    public String theaterlist(Model model) {

        Map<String, List<Theater>> theaters = theaterService.getAllTheaters();

        model.addAttribute("theaters", theaters);
        return "/theater/list";
    }

    @GetMapping("/detail")
    public String detail(int no, @RequestParam(name = "showDate", required = false) String showDate, Model model) {

        if (showDate == null) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            showDate = sdf.format(date);
        }
        TheaterDto theaterDto = theaterDetailService.getTheaterDto(no, showDate);
        model.addAttribute("dto", theaterDto);
        return "/theater/detail";
    }
}
