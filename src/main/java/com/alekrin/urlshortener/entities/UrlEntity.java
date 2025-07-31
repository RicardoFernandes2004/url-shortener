package com.alekrin.urlshortener.entities;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;



@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "urls")
public class UrlEntity {

    @Id
    @EqualsAndHashCode.Include
    @Setter
    private String id;

    @Setter
    private String url;

    private LocalDateTime createdAt;

    public UrlEntity(){
        this.createdAt = LocalDateTime.now();
    }

}
