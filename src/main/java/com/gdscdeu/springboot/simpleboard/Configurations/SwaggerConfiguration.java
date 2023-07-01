package com.gdscdeu.springboot.simpleboard.Configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI simpleBoardOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Simple Board API")
                        .description("Springboot 스터디 게시판")
                        .version("v0.0.1"));
    }

}
