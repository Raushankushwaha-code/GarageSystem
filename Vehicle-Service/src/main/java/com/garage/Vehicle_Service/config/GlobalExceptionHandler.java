package com.garage.Vehicle_Service.config;

import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // --- JPA EXCEPTIONS ---
    /*@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJPAException(EntityNotFoundException ex, WebRequest request) {
        return buildResponse(HttpStatus.NOT_FOUND, "Resource not found in Database: " + ex.getMessage(), request);
    }*/

    //---- FEIGN CLIENT EXCEPTIONS -----
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignStatusException(FeignException e, WebRequest request) {
        // Extracts the status code from the microservice that failed

        ErrorResponse errorResponse=new ErrorResponse(LocalDateTime.now(),500,"Resource Not found", e.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
