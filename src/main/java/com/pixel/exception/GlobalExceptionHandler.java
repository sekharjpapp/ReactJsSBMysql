package com.pixel.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> handleUserException(UserNotFoundException exception) {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("error message is: " , exception.getMessage());
        return errorMap;
    }
}
