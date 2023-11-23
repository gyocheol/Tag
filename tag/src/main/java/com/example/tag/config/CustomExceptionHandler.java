package com.example.tag.config;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Validation Exception 처리하는 method
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponseEntity> handleValidationException(MethodArgumentNotValidException e) {
        return ErrorResponseEntity.toResponseEntity(e);
    }

    /**
     * Request Body 가 누락되었을 때 발생하는 Exception 처리 method
     *
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity<ErrorResponseEntity> handleMissingRequestBodyException(HttpMessageNotReadableException e) {
        return ErrorResponseEntity.toResponseEntity(e);
    }
}
