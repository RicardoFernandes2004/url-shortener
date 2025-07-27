package com.alekrin.urlshortener.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UrlEntity {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private UUID uuid;

    private String code;
    private String url;
    private LocalDateTime created_at;

}
