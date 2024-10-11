package com.reto.tecnico.wilmer.smart.service;

import com.reto.tecnico.wilmer.smart.model.Users;
import com.reto.tecnico.wilmer.smart.model.request.UserRequest;

public interface IUserService {
    Users registerUser(UserRequest userRequest);
    Users updateUser(String email, Boolean state);
    Users getUserByEmail(String email);
}