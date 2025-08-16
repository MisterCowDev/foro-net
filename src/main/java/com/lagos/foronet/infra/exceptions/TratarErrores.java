package com.lagos.foronet.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
}
