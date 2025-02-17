package com.f1rst.registryapi.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {

   @ExceptionHandler(AgencyException.class)
    public ResponseEntity<ResponseError> featureException(AgencyException ex){

       ResponseError response = new ResponseError(
               ex.getMessage(),
               HttpStatus.BAD_REQUEST,
               LocalDateTime.now());

       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> tratarException(Exception ex){

        ResponseError response = new ResponseError(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
