package com.breitner.project.reviewscameras.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.breitner.project.reviewscameras.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My REST REVIEWS CAMERAS API PROJECT",
                "This API was created with the goal of showing a basic reviews cameras project.",
                "API 1.0",
                "Terms of service",
                new Contact("Breitner Mora", "www.breitcode.com", "jeanbreitnermora@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}