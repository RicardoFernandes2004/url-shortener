package com.alekrin.urlshortener.controllers;


import com.alekrin.urlshortener.dtos.UrlResponseDTO;
import com.alekrin.urlshortener.services.UrlGetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping
public class RedirectController {

    private final UrlGetService urlGetService;
    public RedirectController(UrlGetService urlGetService) {
        this.urlGetService = urlGetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getUrl(@PathVariable String id) {

        UrlResponseDTO originalUrl = urlGetService.retrieveUrl(id);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl.getUrl())).build();

    }

}
