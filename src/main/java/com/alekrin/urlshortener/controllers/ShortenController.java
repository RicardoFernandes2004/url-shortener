package com.alekrin.urlshortener.controllers;


import com.alekrin.urlshortener.entities.UrlEntity;
import com.alekrin.urlshortener.services.shortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/urls")
public class ShortenController {

    @Autowired
    private shortenService shortenService;

    // HTTP get requisition
    @PostMapping("/posturl")
    public String shorten(@RequestBody UrlEntity url) {

        return "200";
    }

    @GetMapping("/geturl")
    public String geturl() {

        return "";
    }

}
