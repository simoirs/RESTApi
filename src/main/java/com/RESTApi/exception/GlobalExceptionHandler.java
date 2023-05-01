package com.RESTApi.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(UserNotFoundException ex) {
        
        List<String> details = new ArrayList<String>();
        details.add(ex.getMessage());
        ApiError err = new ApiError(
            LocalDateTime.now(), 
            "Employee Not Found" ,
            details);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
