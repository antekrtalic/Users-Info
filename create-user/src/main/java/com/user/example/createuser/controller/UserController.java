package com.user.example.createuser.controller;

import com.user.example.createuser.api.service.UserServiceLayer;
import com.user.example.createuser.dto.UserDTO;
import com.user.example.createuser.entity.User;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public UserDTO getUserById(@PathVariable("id") Long id) {

        return userServiceLayer.findUserById(id);
    }

    @PostMapping("/users")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {

        return userServiceLayer.addUser(userDTO);
    }

    @PutMapping("/users/{id}")
    public UserDTO updateUser(@PathVariable("id") Long id, UserDTO userDTO) {
        return userServiceLayer.updateUser(id, userDTO);
    }

    @DeleteMapping("/users/{id}")
    public UserDTO deleteUser(@PathVariable("id") Long id) {
        return userServiceLayer.deleteUser(id);
    }
}
