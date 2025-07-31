package com.alekrin.urlshortener.services;


import com.alekrin.urlshortener.dtos.UrlResponseDTO;
import com.alekrin.urlshortener.dtos.exceptions.UrlNotFoundException;
import com.alekrin.urlshortener.entities.UrlEntity;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class UrlGetService {

    private final MongoTemplate mongoTemplate;

    public UrlGetService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public UrlResponseDTO retrieveUrl(String id) {
        UrlEntity urlEntity = mongoTemplate.findById(id, UrlEntity.class);
        if (urlEntity == null) {
            throw new UrlNotFoundException();
        }
        return new UrlResponseDTO(urlEntity.getUrl(),urlEntity.getId());
    }


}
