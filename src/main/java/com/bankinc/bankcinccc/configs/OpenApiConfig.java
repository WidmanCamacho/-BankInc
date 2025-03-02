package com.bankinc.bankcinccc.configs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Credit Card Crud",
                version = "1.0.0",
                description = "Process Credit Card"
        )
)

public class OpenApiConfig {
}
