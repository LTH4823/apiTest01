package org.taerock.apitest01.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import jdk.javadoc.doclet.Doclet;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi getAllApi() {

        return GroupedOpenApi
                .builder()
                .group("all")
                .pathsToMatch("/**")
                .build();

    }

    @Bean
    public GroupedOpenApi getBoardApi() {

        return GroupedOpenApi
                .builder()
                .group("board")
                .pathsToMatch("/board/**")
                .build();

    }

    @Bean
    public GroupedOpenApi getUploadApi() {

        return GroupedOpenApi
                .builder()
                .group("upload")
                .pathsToMatch("/upload/**", "/view/**", "/remove/**")
                .build();

    }

    @Bean
    public OpenAPI getOpenApi() {

        return new OpenAPI().components(new Components())
                .info(getInfo());

    }

    private Info getInfo() {
        return new Info()
                .version("1.0.0")
                .title("Boot 01 Project Swagger")
                .description("Rest API Test");
    }


}
