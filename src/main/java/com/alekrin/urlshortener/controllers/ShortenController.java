package com.alekrin.urlshortener.controllers;


import com.alekrin.urlshortener.dtos.UrlRequestDTO;
import com.alekrin.urlshortener.dtos.UrlResponseDTO;
import com.alekrin.urlshortener.services.UrlGetService;
import com.alekrin.urlshortener.services.UrlPostShortenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/urls")
public class ShortenController {

    private final UrlPostShortenService shortenService;
    private final UrlGetService UrlGetService;

    public ShortenController(UrlPostShortenService shortenService, UrlGetService getService) {
        this.shortenService = shortenService;
        this.UrlGetService = getService;
    }

    // HTTP post requisition
    @PostMapping("/posturl")
    public ResponseEntity<UrlResponseDTO> postUrl(@RequestBody @Valid UrlRequestDTO url) {
        return shortenService.shorten(url);
    }

    // HTTP get requisition
    @GetMapping("/{id}")
    public ResponseEntity<Void> getUrl(@PathVariable String id) {

        UrlResponseDTO originalUrl = UrlGetService.retrieveUrl(id);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(originalUrl.getUrl())).build();

    }

}
