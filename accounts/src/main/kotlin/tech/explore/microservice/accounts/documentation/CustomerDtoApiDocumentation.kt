package tech.explore.microservice.accounts.documentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import tech.explore.microservice.accounts.domain.dto.ErrorResponseDto


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Schema(
    name = "Customer",
    description = "Schema to hold Customer and Account information"
)
annotation class CustomerDtoApiDocumentation