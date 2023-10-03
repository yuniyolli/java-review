package com.review.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hitController {

    private final hitService service;

    public hitController(hitService service) {
        this.service = service;
    }

    @RequestMapping("/hits")
    public String hit(Model model) {
        int hit = service.countHit();
        model.addAttribute("hits", hit);
        return "hits";
    }

}
