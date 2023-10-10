package com.review.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HitController {

    private final HitService service;

    public HitController(HitService service) {
        this.service = service;
    }

    @RequestMapping("/hits")
    public String hit(Model model) {
        int hit = service.countHit();
        model.addAttribute("hits", hit);
        return "hits";
    }

}
