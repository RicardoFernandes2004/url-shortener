package com.alekrin.urlshortener.infra;

import com.alekrin.urlshortener.dtos.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { ExistingIdException.class })
    private ResponseEntity<RestErrorMessage> ExistingIdExceptionHandler(ExistingIdException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(value = { ExistingOriginalUrlException.class })
    private ResponseEntity<RestErrorMessage> ExistingOriginalUrlExceptionHandler(Exception e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(value = {InvalidUrlException.class})
    private ResponseEntity<RestErrorMessage> InvalidUrlExceptionHandler(InvalidUrlException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.BAD_REQUEST,e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(value = {UrlNotFoundException.class})
    private ResponseEntity<RestErrorMessage> UrlNotFoundExceptionHandler(UrlNotFoundException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(value = {RateLimitReachedException.class})
    private ResponseEntity<RestErrorMessage> RateLimitReachedExceptionHandler(RateLimitReachedException e){
        RestErrorMessage errorMessage = new RestErrorMessage(HttpStatus.TOO_MANY_REQUESTS,e.getMessage());
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(errorMessage);
    }

}
