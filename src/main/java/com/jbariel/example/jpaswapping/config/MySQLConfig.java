package com.jbariel.example.jpaswapping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.vendor.Database;

@Configuration
@Profile("mysql")
public class MySQLConfig extends AbstractConfig {

    @Autowired
    Environment env;

    @Override
    protected SourceInfo getInfo() {

        SourceInfo info = new SourceInfo();
        info.driverName = "com.mysql.cj.jdbc.Driver";

        String host = env.getProperty("MYSQL_HOST", "db");
        String port = env.getProperty("MYSQL_PORT", "3306");
        String dbName = env.getProperty("MYSQL_DB_NAME", "jpaapp");

        info.url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        // info.url = "jdbc:mysql://" + host + "/" + dbName;

        info.username = env.getProperty("MYSQL_USERNAME", "root");
        info.password = env.getProperty("MYSQL_PASSWORD", "example");
        System.out.println("MYSQL INFO: " + info.toString());
        return info;
    }

    @Override
    protected Database getDb() {
        return Database.MYSQL;
    }

}