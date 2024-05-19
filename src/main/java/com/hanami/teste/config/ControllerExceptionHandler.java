package com.hanami.teste.config;

import com.hanami.teste.dto.ExceptionDTO;
import com.hanami.teste.exception.InvalidFieldExcpection;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity invalidParamException(MethodArgumentTypeMismatchException e){
        ExceptionDTO exception = new ExceptionDTO("O ID é invalido.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity teste3(EntityNotFoundException e){
        ExceptionDTO exception = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(InvalidFieldExcpection.class)
    public  ResponseEntity invalidFields(InvalidFieldExcpection e){
        ExceptionDTO exception = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception);
    }

}
