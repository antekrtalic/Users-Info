package com.user.example.createuser.service;

import com.user.example.createuser.api.service.UserServiceLayer;
import com.user.example.createuser.dto.UserDTO;
import com.user.example.createuser.entity.User;
import com.user.example.createuser.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceLayerImpl implements UserServiceLayer {

    private ModelMapper modelMapper;

    private UserRepository userRepository;

    @Autowired
    public UserServiceLayerImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(Long id) {

        Optional<User> result = userRepository.findById(id);
        User theUser = null;

        if (result.isPresent()) {
            theUser = result.get();
        } else {
            throw new RuntimeException("Did not find employee with id " + id);
        }
        return modelMapper.map(theUser, UserDTO.class);
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {

        User userRequest = modelMapper.map(userDTO, User.class);

        User user = userRepository.save(userRequest);

        UserDTO userResponse = modelMapper.map(user, UserDTO.class);

        return userResponse;
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {

        userDTO.setId(id);

        User userRequest = modelMapper.map(userDTO, User.class);

        User user = userRepository.save(userRequest);

        UserDTO userResponse = modelMapper.map(user, UserDTO.class);

        return userResponse;
    }

    @Override
    public UserDTO deleteUser(Long id) {

        User user = userRepository.getById(id);

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        userRepository.deleteById(id);

        return userDTO;
    }
}
