package com.example.springex01.repository;

import com.example.springex01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO
// 자동으로 bean에 등록이 됨
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {
}
