package com.reto.tecnico.wilmer.smart.service;

import com.reto.tecnico.wilmer.smart.model.request.AuthRequest;
import com.reto.tecnico.wilmer.smart.model.response.AuthResponse;

public interface IAuthService {

  AuthResponse authenticate(AuthRequest authRequest);
}
