package com.jbariel.example.jpaswapping.config;

import javax.sql.DataSource;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public abstract class AbstractConfig {

    @Bean
    @SuppressWarnings("rawtypes")
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        SourceInfo info = getInfo();
        dataSourceBuilder.driverClassName(info.driverName);
        dataSourceBuilder.url(info.url);
        dataSourceBuilder.username(info.username);
        dataSourceBuilder.password(info.password);

        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean mgr = new LocalContainerEntityManagerFactoryBean();
        mgr.setDataSource(dataSource);
        mgr.setPackagesToScan(new String[] { "com.jbariel.example" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(getDb());

        mgr.setJpaVendorAdapter(vendorAdapter);

        return mgr;
    }

    protected abstract SourceInfo getInfo();

    protected abstract Database getDb();

    class SourceInfo {
        public SourceInfo() {
            super();
        }

        String driverName;
        String url;
        String username;
        String password;

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }
    }
}