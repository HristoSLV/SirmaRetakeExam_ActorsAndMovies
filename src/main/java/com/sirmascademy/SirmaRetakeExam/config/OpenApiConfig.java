package com.sirmascademy.SirmaRetakeExam.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                description = "A backend rest api for finding out which actors are overlapping in which movies",
                title = "Overlapping Actors in Movies BE",
                version = "0.1"
        ),
        servers = {
                @Server(description = "Local server - port defined in application.properties")
        }
)
@Configuration
public class OpenApiConfig {
}
