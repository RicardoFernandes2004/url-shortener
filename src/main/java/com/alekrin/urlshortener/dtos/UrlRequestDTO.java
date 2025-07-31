package com.alekrin.urlshortener.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class UrlRequestDTO {

    @NotNull
    @NotBlank
    @URL(message = "Invalid URL")
    public String url;

}
