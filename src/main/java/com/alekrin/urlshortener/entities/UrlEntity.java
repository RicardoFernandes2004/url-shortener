package com.alekrin.urlshortener.entities;


import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UrlEntity {


    @EqualsAndHashCode.Include
    private String code;

    private String url;
    private LocalDateTime created_at;

}
