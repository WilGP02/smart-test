package com.reto.tecnico.wilmer.smart.controller;

import com.reto.tecnico.wilmer.smart.model.Users;
import com.reto.tecnico.wilmer.smart.model.request.UserRequest;
import com.reto.tecnico.wilmer.smart.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private IUserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerValidUserReturnsOK() {
        // Arrange
        Users user = new Users();
        UserRequest userRequest = new UserRequest();
        when(userService.registerUser(userRequest)).thenReturn(user);

        // Act
        ResponseEntity<?> response = userController.registerUser(userRequest);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).registerUser(userRequest);
    }

    @Test
    void updateValidStateEmailReturnsOK() {
        // Arrange
        String email = "wilmer_palomino@gmail.com";
        Boolean state = true;
        Users user = new Users();
        when(userService.updateUser(email, state)).thenReturn(user);

        // Act
        ResponseEntity<?> response = userController.updateState(email, state);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).updateUser(email, state);
    }
}