package com.bookapp.book.app.rest.api.exceptions;


import com.bookapp.book.app.rest.api.models.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler({ResourceNotFoundException.class,BookDoseNotFoundException.class})
//    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
//        String messages = ex.getMessage();
//        ApiResponse apiResponse = new ApiResponse(messages,false);
//
//        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
//    }
//
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handelMethodArgsNotValidException(
//            MethodArgumentNotValidException ex
//    ){
//
//        Map<String, String> resp = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error)->{
//            String fieldName = ((FieldError)error).getField();
//            String message = error.getDefaultMessage();
//            resp.put(fieldName,message);
//        });
//
//        return new ResponseEntity< Map<String, String>>(resp,HttpStatus.BAD_REQUEST);
//
//    }
//
//
//}

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BookDoseNotFoundException.class,
            ResourceNotFoundException.class,
            InvalidUserException.class
            })
    public ResponseEntity<Object> returnNotFoundException(Exception ex) {
        if(ex instanceof BookDoseNotFoundException) {
            // Some operation
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } else if(ex instanceof ResourceNotFoundException) {
            // Some operation for candidate not found
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else if(ex instanceof InvalidUserException) {
            // Some operation for candidate not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
//            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
        else {
            // Some other operation
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}