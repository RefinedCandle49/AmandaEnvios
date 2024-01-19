package com.pe.amanda.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Zegel",
						email = "zegel@la.com",
						url = "www.zegel.pe"
				),
				description = "API's Rest de Amanda Envios, para clientes front-end",
				title = "API REST Amanda Envios",
				version = "1.0",
				license = @License(
						name = "All rights reserved",
						url = "www.amandaenvios.pe"
				),
				termsOfService = "Terms of service"
		),
		servers = {
				@Server(
						description = "PROD ENV",
						url = "http://localhost:8080"
				)
				// EL OTRO SERVER NO SE QUE ES
		},
		security = {
				@SecurityRequirement(
						name = "bearerAuth"
				)
		}
)
@SecurityScheme(
		name = "bearerAuth",
		description = "JWT auth description",
		scheme = "bearer",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		in = SecuritySchemeIn.HEADER
		
)
public class OpenApiConfig {

}
