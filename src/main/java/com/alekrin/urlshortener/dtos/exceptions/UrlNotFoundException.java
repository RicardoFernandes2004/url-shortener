package com.alekrin.urlshortener.dtos.exceptions;

public class UrlNotFoundException extends RuntimeException{

    public UrlNotFoundException(){ super("Url Not Found"); }
    public UrlNotFoundException(String message){ super(message); }

}
