package com.alekrin.urlshortener.dtos.exceptions;

public class RateLimitReachedException extends RuntimeException {
    public RateLimitReachedException(String message) {
        super(message);
    }

    public RateLimitReachedException(){super("Too many requests"); }
}
