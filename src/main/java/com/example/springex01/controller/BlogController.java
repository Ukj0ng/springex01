package com.example.springex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class BlogController {

    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>현정아 드디어 블로그 만들 준비 세팅을 다했어</h1>";
    }
}
