package com.alekrin.urlshortener.services;

import com.alekrin.urlshortener.dtos.UrlRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UrlPostShortenService {

    public String shorten(@RequestBody UrlRequestDTO url) {

        return "";
    }

}
