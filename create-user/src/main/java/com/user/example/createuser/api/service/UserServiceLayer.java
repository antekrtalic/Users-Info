package com.user.example.createuser.api.service;

import com.user.example.createuser.dto.UserDTO;

import java.util.List;

public interface UserServiceLayer {

    List<UserDTO> findAll();
    UserDTO getUserById(Long id);
    void addUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO deleteUser(Long id);


}
