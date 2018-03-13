package com.equifax.ren.legal_agreement.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.equifax.ren.legal_agreement.repository")
@EnableMongoAuditing
public class MongoConfig {
//    extends AbstractMongoConfiguration
//    @Override
//    protected String getDatabaseName() {
//        return "ForNowDB";
//    }
//
//    @Override
//    public MongoClient mongoClient() {
//        return new Fongo(getDatabaseName()).getMongo();
//    }
}