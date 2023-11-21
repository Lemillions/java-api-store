package com.nextboom.storeapi.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardError> notFound(NotFoundException e, HttpServletRequest request) {
    String error = "Not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {
    String error = "Bad request";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<StandardError>> handle(MethodArgumentNotValidException e, HttpServletRequest request) {
    String error = "Bad request";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    List<StandardError> erros = e.getBindingResult().getAllErrors().stream()
        .map(erro -> new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI()))
        .collect(Collectors.toList());

    return ResponseEntity.badRequest().body(erros);
  }
}
