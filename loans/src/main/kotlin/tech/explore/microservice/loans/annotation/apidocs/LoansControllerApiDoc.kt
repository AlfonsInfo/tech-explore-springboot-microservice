package tech.explore.microservice.loans.annotation.apidocs

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import tech.explore.microservice.loans.domain.dto.ErrorResponseDto


@Tag(
    name = "CRUD REST APIs for Loans in EazyBank",
    description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE loan details"
)
annotation class LoansControllerApiDoc


@Operation(summary = "Create Loan REST API", description = "REST API to create new loan inside EazyBank")
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
annotation class CreateLoansApiDoc


@Operation(
    summary = "Fetch Loan Details REST API",
    description = "REST API to fetch loan details based on a mobile number"
)
@ApiResponses(
    ApiResponse(responseCode = "200", description = "HTTP Status OK"),
    ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = [Content(schema = Schema(implementation = ErrorResponseDto::class))]
    )
)
annotation class FetchLoansApiDoc


@Operation(
    summary = "Update Loan Details REST API",
    description = "REST API to update loan details based on a loan number"
)
@ApiResponses(
    ApiResponse(responseCode = "200", description = "HTTP Status OK"), ApiResponse(
        responseCode = "417",
        description = "Expectation Failed"
    ),    ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = [Content(schema = Schema(implementation = ErrorResponseDto::class))]
    )
)
annotation class UpdateLoansApiDoc



@Operation(
    summary = "Delete Loan Details REST API",
    description = "REST API to delete Loan details based on a mobile number"
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
annotation class DeleteLoansApiDoc