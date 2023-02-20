package com.example.web.controller;

import com.example.utils.SessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "CINEMA 방문을 환영합니다.");

        return "home";    // prefix="/WEB-INF/views/" viewName="home" suffix=".jsp"
    }

    @GetMapping("/logout")
    public String logout() {
        SessionUtils.sessionInvalidate();

        return "redirect:/";
    }

    @GetMapping("/timeTable/timeTable")
    public String timeTable() {
        return "/timeTable/timeTable";
    }
}