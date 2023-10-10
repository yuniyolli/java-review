package com.review.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LottoController {
    // 왜 static?
    private static LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    // public, private 차이
    @RequestMapping("/lotto")
    public String lotto(Model model) {
        String result = lottoService.result();
        model.addAttribute("lotto", result);
        return "lotto";
    }

}
