package com.user.example.createuser.repository;

import com.user.example.createuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u JOIN FETCH u.roles WHERE u.username = :username")
    Optional<User> findByUsername(@Param("username")String username);
    Optional<User> findByEmail(String email);
}
