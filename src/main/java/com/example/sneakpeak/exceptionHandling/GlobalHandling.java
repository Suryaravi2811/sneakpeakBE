package com.example.sneakpeak.exceptionHandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandling {
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(IllegalArgumentException e){
        return "illegal exception";
    }
}
