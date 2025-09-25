package com.medico.webapp.services;

import com.medico.webapp.config.JWTUtil;
import com.medico.webapp.dto.JWTResponse;
import com.medico.webapp.dto.Response;
import com.medico.webapp.entity.Users;
import com.medico.webapp.exception.NotFound;
import com.medico.webapp.repository.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

  private final AuthenticationManager authManager;
  private final JWTUtil jwtUtil;
  private final UsersRepository repo;
  private final PasswordEncoder encoder;

  public AuthService(AuthenticationManager authManager, JWTUtil jwtUtil,
                     UsersRepository repo, PasswordEncoder encoder) {
    this.authManager = authManager;
    this.jwtUtil = jwtUtil;
    this.repo = repo;
    this.encoder = encoder;
  }

  public ResponseEntity<Response> register(Users user) {
    user.setPassword(encoder.encode(user.getPassword()));
    repo.save(user);
    return new ResponseEntity<>(
      new Response("User registered successfully"),
      HttpStatus.OK
    );
  }

  public ResponseEntity<JWTResponse> login(Users user) {

    Optional<Users> userDetails = repo.findByUsername(user.getUsername());

    if (userDetails.isPresent()) {
      // set au manager
      authManager.authenticate(
        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

      return new ResponseEntity<JWTResponse>(
        new JWTResponse("User logged in successfully",
          jwtUtil.generateToken(user.getUsername())
        ), HttpStatus.OK);
    } else {
      throw new NotFound("User not found: " + user.getUsername());
    }

  }
}
