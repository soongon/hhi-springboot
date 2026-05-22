package com.hhi.springhhi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("현대중공업 스프링 교육용 API 문서")
                        .version("v1.0")
                        .description("교육용 입니다.")
                        .contact(new Contact()
                                .name("개발 아키텍트 팀")
                                .email("dev@hhi.com"))
                );
    }
}
