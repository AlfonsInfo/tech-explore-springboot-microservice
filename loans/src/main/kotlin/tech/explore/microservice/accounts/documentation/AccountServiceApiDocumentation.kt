package tech.explore.microservice.accounts.documentation

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import tech.explore.microservice.accounts.domain.dto.ErrorResponseDto
@OpenAPIDefinition(
    info = Info(
        title = "Accounts microservices REST API Documentation",
        description = "Account microservices Application REST API Documentation",
        version = "v1",
        contact = Contact(
            name = "Alfonsus Setiawan Jacub",
            email = "itsmealfons@gmail.com",
            url = "alfons.com/inifake"
        ),
        license = License(
            name = "Apache 2.0",
            url = ""
        ),
    ),
    externalDocs = 	ExternalDocumentation(
        description = "Account Documentation",
        url = "dummyUrl"
    )

)
annotation class AccountServiceApiDocumentation