package com.example.springex01.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // exception이 발생하면 모두 여기서 처리
@RestController
public class GlobalExceptionHandler {

    // "IllegalArgumentException"만 잡음 이 class에 뭘 넣냐에 따라 잡는게 다름
    @ExceptionHandler(value = IllegalArgumentException.class)
    public String handleArgumentException(IllegalArgumentException e) {
        return "<h1>" + e.getMessage() + "</h1>";
    }
}
