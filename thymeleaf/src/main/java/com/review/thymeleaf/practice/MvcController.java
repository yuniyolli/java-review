package com.review.thymeleaf.practice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

@Controller
public class MvcController {
    private final MvcService mvcService;
    // RequiredArgsConstruct 없을 때
    public MvcController(MvcService mvcService) {
        this.mvcService = mvcService;
    }

    // Return "home" 이라는 String 을 반환했는데 html이 나온다? ViewResolver가 작동하기 때문
    // DispatcherServlet을 통해 요청을 주고 받음
    // 반환형에 따라 데이터 또는 HTML을 응답
    // 문자형(String)을 반환하며 View라고 판단하여, 문자열과 일치하는 View 반환을 요청함

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    //------------------------------------

    // Model 인자 : DispatcherServlet이 메소드를 실행할 때 전달
    // 메소드 반환 시 home.html ViewResolver에게 전달
    // -> Thymeleaf가 home.html을 변환하는데 사용. Thymeleaf가 활용할 수 있도록 model.addAttribute메소드 사용
    // -> message라는 이름을 붙인 데이터 전달

    // th:text

    @RequestMapping("/model")
    public String model(Model model) {
        model.addAttribute("message",
                mvcService.modelMessage(
                        "th:text=\"${message}\", \n" +
                                "message should be defined at the controller as an attribute name. \n" +
                                "And the contents could be declared as an attribute value.\n " +
                                "Writing on html file doesn't work anymore."));
        // MvcService에 입력했던 내용이 왜 안나가고 여기서 또 쓰는거야?
        // return이 서비스가 아니라 html.
        return  "model";
    }

    //-----------------------------------
    // [[${}]]

    @RequestMapping("/student")
    public String student(Model model) {
        model.addAttribute("object", new StudentEntity("Penguin", "pingu@ice.com"));
        return "student";
    }

    //-----------------------------------
    // th:if - unless

    @RequestMapping("/login")
    public String login(Model model) {
        // html 에서 if - unless logged in 으로 설정해놓았음
        // -> if true, unless fail -> boolean값으로 설정
        model.addAttribute("isLoggedIn", false);
        return "login";
    }

    //------------------------------------
    // th:each

    @RequestMapping("/each")
    public String each(Model model) {
        List<String> listOfStrings = Arrays.asList("foo", "bar", "baz");
        model.addAttribute("itemList", listOfStrings);
        return "each";
    }

    //------------------------------------
    // th:each with students
    // th:each="student: ${studentList}"
    // add empty boolean
    // <div th:if="${studentList.isEmpty()}">
    // <div th:unless="${studentList.isEmpty()}" th:each="student: ${studentList}">
    @RequestMapping("/students")
    public String students(Model model) {
        // List<String> studentList = Arrays.asList(
        // 입력된 값이 단순한 Stringdl 아니라 StudentEntity에서 가지고 온 값
        // 제네릭 설정 똑바로 하기
        List<StudentEntity> studentList = Arrays.asList(
                new StudentEntity("Alex", "alex@gmail.com"),
                new StudentEntity("Pipi", "pipi@gmail.com"),
                new StudentEntity("Chad", "chad@gmail.com")
        );
        model.addAttribute("studentList", studentList);
        return "students";
    }

}
