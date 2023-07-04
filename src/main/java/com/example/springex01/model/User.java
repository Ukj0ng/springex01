package com.example.springex01.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User 클래스가 MYSQL에 테이블이 생성
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // numbering 전략. 프로젝트에 연결된 DB의 넘버링 전략을 따라간다. 오라클 => sequence, mysql => auto_increment

    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30)
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 123456 => 해쉬 (비밀번호 암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault(" 'user' ")
    private String role; // Enum을 쓰는게 좋음, admin, user, manager

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;

}
