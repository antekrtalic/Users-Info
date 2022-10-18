package com.user.example.createuser.service;


import com.user.example.createuser.dto.UserDTO;
import com.user.example.createuser.entity.User;
import com.user.example.createuser.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceLayerImpl userService;

    private User user;
    private UserDTO userDTO;
    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
//         userRepository = Mockito.mock(UserRepository.class);
//         userService = new UserServiceLayerImpl(userRepository);
        user = new User(1L, "ceki", "starTroopers96#", "etna96@hotmail.com");
        userDTO = new UserDTO(1L, "ceki", "starTroopers96#", "etna96@hotmail.com");
    }

    // JUnit test for addUser method
    @DisplayName("Junit test for addUser method")
    @Test
    public void givenUserObject_whenAddUser_thenReturnUserObject() {

//        given(userRepository.save(user)).willReturn(user);

        when(userRepository.save(user)).thenReturn(user);

        // when - action or the behaviour that we are going to test
        UserDTO savedUser = userService.addUser(userDTO);

        assertThat(savedUser).isNotNull();
    }
}