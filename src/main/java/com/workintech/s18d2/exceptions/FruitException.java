package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class FruitException extends RuntimeException{
    private HttpStatus httpStatus;

    public FruitException(String message,  HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
