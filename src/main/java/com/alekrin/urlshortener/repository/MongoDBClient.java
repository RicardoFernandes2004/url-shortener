package com.alekrin.urlshortener.repository;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MongoDBClient {

    private final MongoClient mongoClient;

    public MongoDBClient(@Value("${spring.data.mongodb.uri}") String uri) {
        this.mongoClient = MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(uri))
                        .build()
        );
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
