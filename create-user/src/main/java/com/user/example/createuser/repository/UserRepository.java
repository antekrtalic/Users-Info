package com.user.example.createuser.repository;

import com.user.example.createuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
