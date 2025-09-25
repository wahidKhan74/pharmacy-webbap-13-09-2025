package com.medico.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTResponse {
  private String message;
  private String token; // actual data
  private int status = HttpStatus.OK.value();
  private LocalDateTime timestamp = LocalDateTime.now();

  public JWTResponse(String message, String token) {
    this.message = message;
    this.token = token;
  }
}
