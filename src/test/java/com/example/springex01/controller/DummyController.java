package com.example.springex01.controller;

import com.example.springex01.model.RoleType;
import com.example.springex01.model.User;
import com.example.springex01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyController {

    @Autowired // 의존성 주입(DI)
    private UserRepository userRepository;

    // http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/user")
    public List<User> list() {
        return userRepository.findAll();
    }

    // 한 페이지당 2건에 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user/page")
    public Page<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users;
    }

    // {id} 주소로 파라미터를 전달 받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // user/4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 USER가 NULL이 될 것 아냐?
        // 그럼 return null이 리턴 되잖아.. 그럼 프로그램에 문제가 있지 않겠니?
        // Optional로 너의 user객체를 감싸서 가져올테니, null인지 아닌지 판단해서 return해!

        /* 람다식
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>(() -> {
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });
         */
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다. id : " + id);
            }
        });
        // 요청 : 웹브라우저
        // user 객체 = 자바 오브젝트
        // 변환 (웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
        // 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
        // 만약 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서,
        // user 오브젝트를 json으로 변환해서 브라우저에게 던져줌
        return user;
    }

    // http://localhost:8000/blog/dummy/join (요청)
    // http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(User user) { // key = value (약속된 규칙)
        System.out.println("id : " + user.getId());
        System.out.println("username : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        System.out.println("role : " + user.getRole());
        System.out.println("createdate : " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
