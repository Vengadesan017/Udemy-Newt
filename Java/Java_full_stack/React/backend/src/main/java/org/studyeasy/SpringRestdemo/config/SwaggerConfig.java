package org.studyeasy.SpringRestdemo.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.*;


@Configuration
@OpenAPIDefinition(
  info =@Info(
    title = "Demo API",
    version = "Verions 1.0",
    contact = @Contact(
      name = "StudyEasy", email = "vengat@admin.org", url = "https://vengat.org"
    ),
    license = @License(
      name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
    ),
    termsOfService = "https://vengat.org/",
    description = "Spring Boot RestFul API Demo by vengat"
  )
)
public class SwaggerConfig {
}
