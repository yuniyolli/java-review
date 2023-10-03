package com.review1.requestHTML;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHTMLController {
    @RequestMapping("home")
    public String index() {
        return "home.html";
    }


    @RequestMapping("integer")
    public String integerTest() {
        return "integer.html";
    }

    @RequestMapping("blog")
    public String blog() {
        return "blog.html";
    }

    @RequestMapping("profile")
    public String profile() {
        return "profile.html";
    }
}
