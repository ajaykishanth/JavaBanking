package com.online.banking.config;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi cardApi() {
        return GroupedOpenApi.builder()
                .group("Card Operations")
                .pathsToMatch("/api/v1/cards/**")
                .build();
    }
}