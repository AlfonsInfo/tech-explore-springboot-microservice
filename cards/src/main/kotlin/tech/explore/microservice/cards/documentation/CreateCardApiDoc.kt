package tech.explore.microservice.cards.documentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import tech.explore.microservice.cards.domain.dto.ErrorResponseDto


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(summary = "Create Card REST API", description = "REST API to create new Card inside EazyBank")
@ApiResponses(
    ApiResponse(
        responseCode = "201",
        description = "HTTP Status CREATED"
    ), ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = [Content(schema = Schema(implementation = ErrorResponseDto::class))]
    )
)
annotation class CreateCardApiDoc