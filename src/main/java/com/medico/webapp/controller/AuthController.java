package com.medico.webapp.controller;

import com.medico.webapp.dto.JWTResponse;
import com.medico.webapp.dto.Response;
import com.medico.webapp.entity.Users;
import com.medico.webapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService authService;


  @PostMapping("/register")
  public ResponseEntity<Response> register(@RequestBody Users user) {
    return authService.register(user);
  }

  @PostMapping("/login")
  public ResponseEntity<JWTResponse> login(@RequestBody Users user) {
    return authService.login(user);
  }
}
