package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException exception){
        FruitErrorResponse response = new FruitErrorResponse(exception.getMessage(), exception.getHttpStatus().value(),  System.currentTimeMillis());
        log.error("Fruit exception", exception);
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(Exception exception) {
        FruitErrorResponse response = new FruitErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), System.currentTimeMillis());
        log.error("exception", exception);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<VegetableErrorResponse> handleException(VegetableException exception){
        VegetableErrorResponse response = new VegetableErrorResponse(exception.getMessage(), exception.getHttpStatus().value(),  System.currentTimeMillis());
        log.error("Vegetable exception", exception);
        return new ResponseEntity<>(response, exception.getHttpStatus());
    }


}
