package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class VegetableException extends RuntimeException{
    private HttpStatus httpStatus;

    public VegetableException(String message,  HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
