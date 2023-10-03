package com.review.thymeleaf.practice;

import org.springframework.stereotype.Service;

@Service
public class MvcService {
    public String modelMessage(String message) {
        message = "th:text=\"${message}\", message should be defined at the controller as an attribute name. And the contents could be declared as an attribute value. writing on html file doesn't work anymore.";
        return message;
    }
}
