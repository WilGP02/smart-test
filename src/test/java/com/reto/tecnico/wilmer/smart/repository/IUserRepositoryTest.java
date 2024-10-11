package com.reto.tecnico.wilmer.smart.repository;

import com.reto.tecnico.wilmer.smart.model.Users;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Optional;

public class IUserRepositoryTest {

    @Test
    public void testFindByEmail() {
        IUserRepository userRepository = Mockito.mock(IUserRepository.class);
        String email = "john.doe@example.com";
        Users user = new Users();
        user.setEmail(email);
        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        Optional<Users> result = userRepository.findByEmail(email);
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(email, result.get().getEmail());
    }

    @Test
    public void testFindByEmailNotFound() {
        IUserRepository userRepository = Mockito.mock(IUserRepository.class);
        String email = "john.doe@example.com";
        Mockito.when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        Optional<Users> result = userRepository.findByEmail(email);
        Assertions.assertFalse(result.isPresent());
    }
}