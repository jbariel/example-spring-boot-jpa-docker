package com.jbariel.example.jpaswapping.config;

import java.util.Map;

import com.jbariel.example.jpaswapping.model.Hello;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
// import org.springframework.context.annotation.Bean;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.orm.jpa.vendor.Database;

@Configuration
@Profile("redis")
public class RedisConfig extends AbstractConfig {

    @Autowired
    Environment env;

    @Override
    protected SourceInfo getInfo() {
        SourceInfo info = new SourceInfo();
        info.driverName = "org.h2.Driver";

        Map<String, String> env = System.getenv();
        String host = env.getOrDefault("MYSQL_HOST", "");
        String port = env.getOrDefault("MYSQL_PORT", "");
        String dbName = env.getOrDefault("MYSQL_DB_NAME", "");

        info.url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;

        info.username = env.getOrDefault("MYSQL_USERNAME", "");
        info.password = env.getOrDefault("MYSQL_PASSWORD", "");

        return info;
    }

    // @Bean
    // public RedisTemplate<Long, Hello> redisTemplate(RedisConnectionFactory
    // connectionFactory) {
    // RedisTemplate<Long, Hello> template = new RedisTemplate<>();
    // template.setConnectionFactory(connectionFactory);
    // // Add some specific configuration here. Key serializers, etc.
    // return template;
    // }

    @Override
    protected Database getDb() {
        return Database.H2;
    }

}