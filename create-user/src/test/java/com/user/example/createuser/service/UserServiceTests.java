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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceLayerImpl userService;

    private User user;
    private User userTwo;
    private UserDTO userDTO;
    @Spy
    private ModelMapper modelMapper;

    @BeforeEach
    public void setup() {
//         userRepository = Mockito.mock(UserRepository.class);
//         userService = new UserServiceLayerImpl(userRepository);
        user = new User(1L, "ceki", "starTroopers96#", "etna96@hotmail.com");
        userTwo = new User(2L, "ante", "starWars96$", "starwars@hotmail.com");
        userDTO = new UserDTO(1L, "ceki", "starTroopers96#", "etna96@hotmail.com");

    }

    // JUnit test for addUser method
    @DisplayName("JUnit test for addUser method")
    @Test
    public void givenUserObject_whenAddUser_thenReturnUserObject() {

//        given(userRepository.save(user)).willReturn(user);

        when(userRepository.save(user)).thenReturn(user);

        // when - action or the behaviour that we are going to test
        UserDTO savedUser = userService.addUser(userDTO);

        assertThat(savedUser).isNotNull();
    }

    @DisplayName("JUnit test for findAll method")
    @Test
    public void givenUsersList_whenFindAll_thenReturnUsersList() {

        when(userRepository.findAll()).thenReturn(List.of(user, userTwo));

        List<User> userList = userRepository.findAll();

        assertThat(userList).isNotNull();

        assertThat(userList.size()).isEqualTo(2);

    }

    @DisplayName("JUnit test for findUserById method")
    @Test
    public void givenUserID_whenFindUserById_thenReturnUser() {

        when(userRepository.findById(userDTO.getId())).thenReturn(Optional.of(user));

        UserDTO actual = userService.findUserById(user.getId());

        assertThat(actual).usingRecursiveComparison().isEqualTo(userDTO);
        verify(userRepository, times(1)).findById(userDTO.getId());
        verifyNoMoreInteractions(userRepository);
    }

    @DisplayName("JUnit test for updateUser method")
    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUpdatedUser() {
        given(userRepository.save(user)).willReturn(user);
        user.setEmail("darkspace@gmail.com");
        user.setUsername("Darth Vader");
        userDTO.setEmail(user.getEmail());
        userDTO.setUsername(user.getUsername());


        UserDTO updatedUser = userService.updateUser(user.getId(), userDTO);

        assertThat(updatedUser.getEmail()).isEqualTo("darkspace@gmail.com");
        assertThat(updatedUser.getUsername()).isEqualTo("Darth Vader");

    }

    @DisplayName("JUnit test for deleteUser method")
    @Test
    public void givenUserId_whenDeleteUser_thenReturnDeletedUser() {

        when(userRepository.getById(user.getId())).thenReturn(user);

        userService.deleteUser(user.getId());

        verify(userRepository, times(1)).deleteById(user.getId());
        verifyNoMoreInteractions(userRepository);
    }
}