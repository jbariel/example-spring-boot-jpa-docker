package com.jbariel.example.jpaswapping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.vendor.Database;

@Configuration
// @Profile({ "!mysql", "!redis" })
@Profile("default")
public class H2Config extends AbstractConfig {

    @Override
    protected SourceInfo getInfo() {
        SourceInfo info = new SourceInfo();
        info.driverName = "org.h2.Driver";
        info.url = "jdbc:h2:mem:test";
        info.username = "SA";
        info.password = "";
        return info;
    }

    @Override
    protected Database getDb() {
        return Database.H2;
    }

}