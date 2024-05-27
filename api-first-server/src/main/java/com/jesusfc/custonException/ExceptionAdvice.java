package com.jesusfc.custonException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author Jesús Fdez. Caraballo
 * jesus.fdez.caraballo@gmail.com
 * Created on may - 2024
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Data not found")  // 404
    @ExceptionHandler(NotFoundException.class)
    public void notFount() {
        System.out.println("Not found exception");
    }

}
