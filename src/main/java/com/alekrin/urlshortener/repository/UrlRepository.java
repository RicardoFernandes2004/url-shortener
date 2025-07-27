package com.alekrin.urlshortener.repository;

import com.alekrin.urlshortener.entities.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, UUID> {
    Optional<UrlEntity> findByCode(String code);
    Optional<UrlEntity> findByUrl(String url);
    List<UrlEntity> findByUrlContaining(String fragment);
    void deleteByUrl(String url);
    void deleteByCode(String code);
}
