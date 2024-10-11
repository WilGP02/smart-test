package com.reto.tecnico.wilmer.smart.controller;

import com.reto.tecnico.wilmer.smart.model.request.AuthRequest;
import com.reto.tecnico.wilmer.smart.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

  @Autowired
  IAuthService authService;

  @PostMapping
  @Operation(
          summary = "Autenticación de usuarios",
          description = "Permite la autenticación de usuarios y generación de jwt.",
          responses = {
                  @ApiResponse(responseCode = "200", description = "Recurso obtenido con éxito")
          }
  )
  public ResponseEntity<?> authentication(@RequestBody @Valid AuthRequest authRequest) {
    return ResponseEntity.ok(authService.authenticate(authRequest));
  }

}
