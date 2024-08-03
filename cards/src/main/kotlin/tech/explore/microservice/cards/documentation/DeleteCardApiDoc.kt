package tech.explore.microservice.cards.documentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import tech.explore.microservice.cards.domain.dto.ErrorResponseDto


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Operation(
    summary = "Delete Card Details REST API",
    description = "REST API to delete Card details based on a mobile number"
)
@ApiResponses(
    ApiResponse(responseCode = "200", description = "HTTP Status OK"), ApiResponse(
        responseCode = "417",
        description = "Expectation Failed"
    ), ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = [Content(schema = Schema(implementation = ErrorResponseDto::class))]
    )
)
annotation class DeleteCardApiDoc