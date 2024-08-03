package tech.explore.microservice.loans.documentation

import io.swagger.v3.oas.annotations.media.Schema


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Schema(
    name = "Customer",
    description = "Schema to hold Customer and Account information"
)
annotation class CustomerDtoApiDocumentation