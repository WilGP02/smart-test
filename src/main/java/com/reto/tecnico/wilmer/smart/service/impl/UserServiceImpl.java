package com.reto.tecnico.wilmer.smart.service.impl;

import com.reto.tecnico.wilmer.smart.exceptions.CustomException;
import com.reto.tecnico.wilmer.smart.model.Users;
import com.reto.tecnico.wilmer.smart.model.request.UserRequest;
import com.reto.tecnico.wilmer.smart.repository.IUserRepository;
import com.reto.tecnico.wilmer.smart.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Users registerUser(UserRequest userRequest) {
        Optional<Users> optionalUsers = userRepository.findByEmail(userRequest.getEmail());
        if (optionalUsers.isPresent()) {
            throw new CustomException("El correo ya está registrado");
        }

        Users user = new Users();
        user.setId(UUID.randomUUID());
        user.setName(userRequest.getName());
        user.setCreated(LocalDateTime.now());
        user.setModified(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhones(userRequest.getPhones());
        user.setIsActive(true);

        return userRepository.save(user);
    }

    @Override
    public Users updateUser (String email, Boolean state) {
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if (!optionalUsers.isPresent()) {
            throw new CustomException("El correo no se encuentra registrado");
        }
        Users updateUser = optionalUsers.get();

        return userRepository.save(updateUser);
    }

    @Override
    public Users getUserByEmail (String email) {
        Optional<Users> optionalUsers = userRepository.findByEmail(email);
        if (!optionalUsers.isPresent()) {
            throw new CustomException("El correo no se encuentra registrado");
        }


        return optionalUsers.get();
    }

}