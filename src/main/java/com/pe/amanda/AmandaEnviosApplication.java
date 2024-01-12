package com.pe.amanda;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmandaEnviosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmandaEnviosApplication.class, args);
    }

    @Bean
    public OpenAPI springAmandaEnviosAPI() {
        return new OpenAPI()
                .info(new Info().title("API REST Amanda Envios")
                        .termsOfService("Terms of service")
                        .description("API's Rest de Amanda Envios, para clientes front-end")
                        .version("1.0")
                        .license(new License().name("All rights reserved").url("www.amandaenvios.pe")))
                .externalDocs(new ExternalDocumentation()
                        .description("Amanda Envios Documentation")
                        .url("www.amandaenvios.pe/docs"));

    }
}
