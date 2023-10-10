package com.review.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private static TestService service;

    public TestController(TestService service) {
        this.service = service;
    }

    @RequestMapping("/test")
    public String RandomHistoryTest(Model model) {
        int question = service.RandomNum();
        model.addAttribute("question", question);
        return "test";
    }
}
