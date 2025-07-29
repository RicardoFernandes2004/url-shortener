package com.alekrin.urlshortener.controllers;


import com.alekrin.urlshortener.dtos.IdRequestDTO;
import com.alekrin.urlshortener.dtos.UrlRequestDTO;
import com.alekrin.urlshortener.services.UrlPostShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/urls")
public class ShortenController {

    @Autowired
    private UrlPostShortenService shortenService;

    // HTTP post requisition
    @PostMapping("/posturl")
    public String shorten(@RequestBody UrlRequestDTO url) {

        return "200";
    }

    // HTTP get requisition
    @GetMapping("/{id}")
    public String geturl(@RequestBody IdRequestDTO id) {

        return "200";
    }

}
