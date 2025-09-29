package com.medico.webapp.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI openApiConf() {
    final String securitySchemeName = "bearerAuth";
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
    ).addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
      .components(new Components().addSecuritySchemes(securitySchemeName,
        new SecurityScheme()
          .name(securitySchemeName)
          .type(SecurityScheme.Type.HTTP)
          .scheme("bearer")
          .bearerFormat("JWT")));
  }
}
