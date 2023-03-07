package controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import util.SessionUtils;

@Data
public class HomeController {

//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("message", "동준 CINEMA 방문을 환영합니다.");
//
//        return "home";    // prefix="/WEB-INF/views/" viewName="home" suffix=".jsp"
//    }

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