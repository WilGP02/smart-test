package com.reto.tecnico.wilmer.smart.service.impl;

import com.reto.tecnico.wilmer.smart.exceptions.CustomException;
import com.reto.tecnico.wilmer.smart.model.Users;
import com.reto.tecnico.wilmer.smart.model.request.AuthRequest;
import com.reto.tecnico.wilmer.smart.model.response.AuthResponse;
import com.reto.tecnico.wilmer.smart.repository.IUserRepository;
import com.reto.tecnico.wilmer.smart.security.services.JwtUtilService;
import com.reto.tecnico.wilmer.smart.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

  @Autowired
  IUserRepository userRepository;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserDetailsService userDetailsService;

  @Autowired
  JwtUtilService jwtUtilService;

  @Override
  public AuthResponse authenticate (AuthRequest authRequest) {

    Optional<Users> optionalUsers = userRepository.findByEmail(authRequest.getEmail());

    if(!optionalUsers.isPresent()) {
      throw new CustomException("Credenciales inválidas.");
    }

    Users users = optionalUsers.get();

    if(!users.getPassword().equals(authRequest.getPassword())) {
      throw new CustomException("Credenciales inválidas.");
    }

    if(!users.getIsActive()) {
      throw new CustomException("El usuario se encuentra inactivo, contacta con el administrador.");
    }

    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
    UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
    AuthResponse authResponse = jwtUtilService.generateToken(userDetails);

    users.setLastLogin(LocalDateTime.now());
    users.setToken(authResponse.getAccess_token());
    userRepository.save(users);
    authResponse.setName(users.getName());
    authResponse.setEmail(users.getEmail());

    return authResponse;
  }
}
