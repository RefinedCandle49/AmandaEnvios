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
						name = "AmandaEnvios",
						email = "soporte@amandaenvios.pe",
						url = "www.amandaenvios.pe"
				),
				description = "API diseñada para empresas de Courier que buscan integrar un sistema de seguimientos de paquetes. Para solicitar más información, por favor escríbanos al siguiente correo soporte@amandaenvios.pe",
				title = "API REST Amanda Envios",
				version = "1.0",
				license = @License(
						name = "Todos los derechos reservados",
						url = "www.amandaenvios.pe"
				),
				termsOfService = "Términos de servicio"
		),
		servers = {
				@Server(
						description = "SERVER AMANDA",
						url = "http://localhost:8080"
				)
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
