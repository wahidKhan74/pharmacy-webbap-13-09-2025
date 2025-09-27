package com.medico.webapp.exception.handler;

import com.medico.webapp.dto.ErrorResponse;
import com.medico.webapp.exception.BadRequest;
import com.medico.webapp.exception.Forbidden;
import com.medico.webapp.exception.NotFound;
import com.medico.webapp.exception.Unauthorised;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.security.SignatureException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private ResponseEntity<ErrorResponse> buildErrorResponse(
    HttpStatus httpStatus, String message, String details) {
    ErrorResponse errorResponse = new ErrorResponse(
      message,
      details,
      httpStatus.value(),
      LocalDateTime.now()
    );
    return new ResponseEntity<ErrorResponse>(errorResponse, httpStatus);
  }

  // Wrong username/password
  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ErrorResponse> handleBadCredentials(BadCredentialsException ex, WebRequest request) {
    return  buildErrorResponse(HttpStatus.UNAUTHORIZED, "Invalid username or password", ex.getMessage());
  }

  // User not found
  @ExceptionHandler(UsernameNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UsernameNotFoundException ex, WebRequest request) {
    return  buildErrorResponse(HttpStatus.NOT_FOUND, "User not found", ex.getMessage());
  }

  //JWT errors
  @ExceptionHandler({ExpiredJwtException.class, MalformedJwtException.class, SignatureException.class, IllegalArgumentException.class})
  public ResponseEntity<ErrorResponse> handleUserNotFound(RuntimeException ex, WebRequest request) {
    return  buildErrorResponse(HttpStatus.UNAUTHORIZED, "Invalid or expired JWT token", ex.getMessage());
  }

  // Generic Exception
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGlobal(Exception ex, WebRequest request) {
    return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", ex.getMessage());
  }

  // Mapping Not Found
  @ExceptionHandler(NotFound.class)
  public ResponseEntity<ErrorResponse> handleNotFound(NotFound ex, WebRequest request) {
    return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
  }

  // Mapping Forbidden
  @ExceptionHandler(Forbidden.class)
  public ResponseEntity<ErrorResponse> handleForbidden(Forbidden ex, WebRequest request) {
    return buildErrorResponse(HttpStatus.FORBIDDEN, ex.getMessage(), request.getDescription(false));
  }


  // Mapping BadRequest
  @ExceptionHandler(BadRequest.class)
  public ResponseEntity<ErrorResponse> handleBadRequest(BadRequest ex, WebRequest request) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
  }


  // Mapping Unauthorised
  @ExceptionHandler(Unauthorised.class)
  public ResponseEntity<ErrorResponse> handleUnauthorised(Unauthorised ex, WebRequest request) {
    return buildErrorResponse(HttpStatus.UNAUTHORIZED, ex.getMessage(), request.getDescription(false));
  }

}
