package com.example.springex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {
    //http://localhost:8000/blog/temp/home
    @GetMapping("/temp/home")
    public String tempHome() {
        System.out.println("tempHOME()");
        // 파일리턴 기본경로: src/main/resources/static
        // 리턴명: /home.html
        // 풀경로: src/main/resources/static/home.html
        // static에서 jsp를 이해 못함, 정적파일인데 이는 브라우저에서 인식할 수 있는 파일을 의미함 -> 컴파일이 필요없는 파일
        return "/home.html";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        // prefix : /WEB-INF/views/
        // suffix : .jsp
        // full name : /WEB-INF/views/test.jsp
        return "test";
    }

}
