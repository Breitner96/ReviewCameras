package com.platzi.platzireviewscameras.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${SPRING_DATASOURCE_DRIVER}")
    private String SPRING_DATASOURCE_DRIVER;

    @Value("${SPRING_DATASOURCE_USERNAME}")
    private String SPRING_DATASOURCE_USERNAME;

    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String SPRING_DATASOURCE_PASSWORD;

    @Value("${SPRING_DATASOURCE_URL}")
    private String SPRING_DATASOURCE_URL;




    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(SPRING_DATASOURCE_DRIVER);
        dataSourceBuilder.url(SPRING_DATASOURCE_URL);
        dataSourceBuilder.username(SPRING_DATASOURCE_USERNAME);
        dataSourceBuilder.password(SPRING_DATASOURCE_PASSWORD);
        return dataSourceBuilder.build();
    }
}