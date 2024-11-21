package ru.akrecev.testTask.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Task Management System Api",
                description = "API системы управления задачами",
                version = "1.0.0",
                contact = @Contact(
                        name = "Andrey Kretsev",
                        email = "akrecev@gmail.com",
                        url = "https://t.me/akrecev"
                )
        )
)
public class OpenApiConfig {
}
