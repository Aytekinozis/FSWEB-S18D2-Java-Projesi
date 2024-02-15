package com.workintech.s18d2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VegetableErrorResponse {
    private String message;
    private long status;
    private long timestamp;
}
