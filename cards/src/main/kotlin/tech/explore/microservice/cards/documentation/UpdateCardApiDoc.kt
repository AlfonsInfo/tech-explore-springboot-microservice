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
    summary = "Update Card Details REST API",
    description = "REST API to update card details based on a card number"
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
annotation class UpdateCardApiDoc