package com.alekrin.urlshortener.utils;


import java.security.SecureRandom;
import java.util.Random;

public class RandomIdGenerator {

    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int TAMANHO = 8;
    private static final Random RANDOM = new SecureRandom();


    public static String generate() {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i < TAMANHO; i++){
            builder.append(ALPHANUMERIC.charAt(RANDOM.nextInt(ALPHANUMERIC.length())));
        }
        return builder.toString();
    }


}
