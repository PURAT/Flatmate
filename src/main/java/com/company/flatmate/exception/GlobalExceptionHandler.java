package com.company.flatmate.exception;

import com.company.flatmate.security.payload.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleException(NoSuchDataException e) {
        MessageResponse mes = new MessageResponse(e.getMessage());
        return new ResponseEntity<>(mes, HttpStatus.NOT_FOUND);
    }
}
