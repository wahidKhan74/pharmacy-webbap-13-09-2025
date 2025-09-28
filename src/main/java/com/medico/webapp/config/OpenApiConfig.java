package com.medico.webapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openApiConf() {
    return  new OpenAPI().info(
      new Info()
        .title("Ecommerce WebService As RestFull APIs")
        .description("Ecommerce WebService Spring Boot REST API with Swagger OpenAPI documentation")
        .version("1.0.0")
        .contact(
          new Contact()
            .name("Admin")
            .email("admin@gmail.com")
            .url("http://localhost/contactus")
        )
    );
  }
}
