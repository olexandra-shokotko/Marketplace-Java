package com.example.marketplace.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = NotEnoughMoneyException.class)
    public ResponseEntity<Object> exception(NotEnoughMoneyException exception) {
        return new ResponseEntity<>("You don't have enough money for this product!", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = InternalServerException.class)
    public ResponseEntity<Object> internalServerException(InternalServerException exception) {
        return new ResponseEntity<>("There is no element with this id", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
