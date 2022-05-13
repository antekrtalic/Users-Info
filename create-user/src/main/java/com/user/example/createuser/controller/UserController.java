package com.user.example.createuser.controller;

import com.user.example.createuser.api.service.UserServiceLayer;
import com.user.example.createuser.dto.UserDTO;
import com.user.example.createuser.entity.User;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceLayer userServiceLayer;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userServiceLayer.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id) {
        Optional<User> result = userServiceLayer.getUserById(id);

    }
}
