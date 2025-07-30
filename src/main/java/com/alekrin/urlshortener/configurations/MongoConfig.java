package com.alekrin.urlshortener.configurations;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class MongoConfig {


    @Value("${spring.data.mongodb.uri}")
    private String MongoURI;

    @Value("{spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create(
                MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(MongoURI))
                        .build()
        );
    }


    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), database);
    }


}
