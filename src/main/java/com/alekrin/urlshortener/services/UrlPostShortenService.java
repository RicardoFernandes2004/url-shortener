package com.alekrin.urlshortener.services;

import com.alekrin.urlshortener.dtos.UrlRequestDTO;
import com.alekrin.urlshortener.dtos.UrlResponseDTO;
import com.alekrin.urlshortener.entities.UrlEntity;
import com.alekrin.urlshortener.utils.RandomIdGenerator;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UrlPostShortenService {

    private final MongoTemplate mongoTemplate;

    public UrlPostShortenService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public ResponseEntity<UrlResponseDTO> shorten(UrlRequestDTO url) {
        if (mongoTemplate.exists(Query.query(Criteria.where("url").is(url.getUrl())), UrlEntity.class)) {
            UrlEntity entity = mongoTemplate.findOne(Query.query(Criteria.where("url").is(url.getUrl())), UrlEntity.class
            );
            if (entity != null) {
                UrlResponseDTO res = new UrlResponseDTO();
                res.setUrl(entity.getUrl());
                res.setId(entity.getId());
                return ResponseEntity.status(HttpStatus.OK).body(res);
            }
        }
        UrlEntity urlEntity = new UrlEntity();
        urlEntity.setUrl(url.getUrl());
        String id = RandomIdGenerator.generate();
        while (mongoTemplate.exists(Query.query(Criteria.where("id").is(id)), UrlEntity.class)) {
            id = RandomIdGenerator.generate();
        }

        urlEntity.setId(id);
        mongoTemplate.save(urlEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UrlResponseDTO(urlEntity.getUrl(),urlEntity.getId()));
    }

}
