package com.user.example.createuser.service;

import com.user.example.createuser.api.service.UserServiceLayer;
import com.user.example.createuser.dto.UserDTO;
import com.user.example.createuser.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceLayerImpl extends UserServiceLayer {

    private ModelMapper modelMapper;

    private UserRepository userRepository;

    public UserServiceLayerImpl(ModelMapper modelMapper)

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public void addUser(UserDTO userDTO) {

    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO deleteUser(Long id) {
        return null;
    }
}
