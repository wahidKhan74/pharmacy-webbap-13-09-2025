package com.medico.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
  private String message;
  private Object payload; // actual data
  private int status = HttpStatus.OK.value();
  private LocalDateTime timestamp = LocalDateTime.now();

  public Response(String message){
    this.message = message;
  }

  public Response(String message, Object payload){
    this.message = message;
    this.payload = payload;
  }
}
