package com.alekrin.urlshortener.dtos.exceptions;

public class InvalidUrlException extends RuntimeException {

    public InvalidUrlException(){ super("Invalid Url"); }

    public InvalidUrlException(String message) {
        super(message);
    }
}
