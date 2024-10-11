package com.reto.tecnico.wilmer.smart.service;

import com.reto.tecnico.wilmer.smart.model.request.UserRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.reto.tecnico.wilmer.smart.model.Users;

import java.util.UUID;

public class IUserServiceTest {

    private IUserService userService;
    private Users user;
    private UserRequest userRequest;

    @BeforeEach
    public void setup() {
        userService = Mockito.mock(IUserService.class);
        userRequest = new UserRequest();
        userRequest.setName("Wilmer Palomino");
        userRequest.setEmail("wilmer_palomino@gmail.com");
        userRequest.setPassword("elmaestro");
    }

    @Test
    public void testRegisterUserSuccess() {
        Users expectedUser = new Users();
        expectedUser.setId(UUID.randomUUID());
        expectedUser.setName("Wilmer Palomino");
        expectedUser.setEmail("wilmer_palomino@gmail.com");
        expectedUser.setPassword("elmaestro");

        Mockito.when(userService.registerUser(userRequest)).thenReturn(expectedUser);

        Users actualUser = userService.registerUser(userRequest);

        Assertions.assertEquals(expectedUser.getId(), actualUser.getId());
        Assertions.assertEquals(expectedUser.getName(), actualUser.getName());
        Assertions.assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(), actualUser.getPassword());
    }

    @Test
    public void testUpdateUserSuccess() {
        String email = "wilmer_palomino@gmail.com";
        Boolean state = true;
        Users expectedUser = new Users();
        expectedUser.setId(UUID.randomUUID());
        expectedUser.setName("Wilmer Palomino");
        expectedUser.setEmail("wilmer_palomino@gmail.com");
        expectedUser.setPassword("elmaestro");
        expectedUser.setIsActive(state);

        Mockito.when(userService.updateUser(email, state)).thenReturn(expectedUser);

        Users actualUser = userService.updateUser(email, state);

        Assertions.assertEquals(expectedUser.getId(), actualUser.getId());
        Assertions.assertEquals(expectedUser.getName(), actualUser.getName());
        Assertions.assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(), actualUser.getPassword());
        Assertions.assertEquals(expectedUser.getIsActive(), actualUser.getIsActive());
    }

    @Test
    public void testGetUserByEmailSuccess() {
        String email = "wilmer_palomino@gmail.com";
        Users expectedUser = new Users();
        expectedUser.setId(UUID.randomUUID());
        expectedUser.setName("Wilmer Palomino");
        expectedUser.setEmail("wilmer_palomino@gmail.com");
        expectedUser.setPassword("elmaestro");

        Mockito.when(userService.getUserByEmail(email)).thenReturn(expectedUser);

        Users actualUser = userService.getUserByEmail(email);

        Assertions.assertEquals(expectedUser.getId(), actualUser.getId());
        Assertions.assertEquals(expectedUser.getName(), actualUser.getName());
        Assertions.assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        Assertions.assertEquals(expectedUser.getPassword(), actualUser.getPassword());
    }
}