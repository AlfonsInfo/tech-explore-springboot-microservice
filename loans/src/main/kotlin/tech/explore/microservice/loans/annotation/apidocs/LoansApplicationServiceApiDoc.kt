package tech.explore.microservice.loans.annotation.apidocs

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License

@OpenAPIDefinition(
    info = Info(
        title = "Loans microservices REST API Documentation",
        description = "Loans microservices Application REST API Documentation",
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
annotation class LoansApplicationServiceApiDoc