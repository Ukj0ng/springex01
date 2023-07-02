package com.example.springex01.controller;

import org.springframework.web.bind.annotation.*;

// 사용자의 요청 -> 응답(controller임, data를 응답하면 Restcontroller)

// 사용자의 요청 -> 응답(controller임, html 파일을 응답하면 Controller)
@RestController
public class HttpController {

    private static final String TAG = "HttpController";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder().username("Ssar").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG + "getter : " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG + "getter : " + m.getUsername());
        return "lombok 테스트 완료";
    }
    // 인터넷 브라우저 요청은 무조건 get 요청만 가능
    // http://localhost:8080/http/get (select)
    @GetMapping("/http/get")
    public String getTest(Member m) { // 자동으로 파싱해서 object에 넣어주는 애: MessageConverter(스프링 부트)
        return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }
    // http://localhost:8080/http/post (insert)
    @PostMapping("/http/post") // text/plain, application/json
    public String postTest(@RequestBody Member m) { // 자동으로 파싱해서 object에 넣어주는 애: MessageConverter(스프링 부트)
        return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }
    // http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }
    // http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }

}
