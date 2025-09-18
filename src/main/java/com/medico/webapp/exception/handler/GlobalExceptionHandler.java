package com.medico.webapp.exception.handler;

import com.medico.webapp.dto.ErrorResponse;
import com.medico.webapp.exception.BadRequest;
import com.medico.webapp.exception.Forbidden;
import com.medico.webapp.exception.NotFound;
import com.medico.webapp.exception.Unauthorised;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

  // Mapping Not Found
  @ExceptionHandler(NotFound.class)
  public ResponseEntity<ErrorResponse> handleNotFound(NotFound ex, WebRequest request) {
    ErrorResponse response = new ErrorResponse(
      ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND.value(), LocalDateTime.now()
    );
    return  new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
  }

  // Mapping Forbidden
  @ExceptionHandler(Forbidden.class)
  public ResponseEntity<ErrorResponse> handleForbidden(Forbidden ex, WebRequest request) {
    ErrorResponse response = new ErrorResponse(
      ex.getMessage(), request.getDescription(false), HttpStatus.FORBIDDEN.value(), LocalDateTime.now()
    );
    return  new ResponseEntity<ErrorResponse>(response, HttpStatus.FORBIDDEN);
  }


  // Mapping BadRequest
  @ExceptionHandler(BadRequest.class)
  public ResponseEntity<ErrorResponse> handleBadRequest(BadRequest ex, WebRequest request) {
    ErrorResponse response = new ErrorResponse(
      ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now()
    );
    return  new ResponseEntity<ErrorResponse>(response, HttpStatus.BAD_REQUEST);
  }


  // Mapping Unauthorised
  @ExceptionHandler(Unauthorised.class)
  public ResponseEntity<ErrorResponse> handleUnauthorised(Unauthorised ex, WebRequest request) {
    ErrorResponse response = new ErrorResponse(
      ex.getMessage(), request.getDescription(false), HttpStatus.UNAUTHORIZED.value(), LocalDateTime.now()
    );
    return  new ResponseEntity<ErrorResponse>(response, HttpStatus.UNAUTHORIZED);
  }

}
