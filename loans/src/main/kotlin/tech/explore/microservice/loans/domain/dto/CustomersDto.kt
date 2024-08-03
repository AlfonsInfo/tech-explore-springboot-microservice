package tech.explore.microservice.loans.domain.dto

import io.swagger.v3.oas.annotations.media.Schema
import tech.explore.microservice.loans.documentation.CustomerDtoApiDocumentation

@CustomerDtoApiDocumentation
data class CustomersDto (
    @Schema(description = "Name of the customer", example = "Eazy Bytes")
    var name : String? = null,

    @Schema(description = "Email address of the customer", example = "tutor@eazybytes.com")
    var email : String? = null,

    @Schema(description = "Mobile Number of the customer", example = "9345432123")
    var mobileNumber : String? = null,

    @Schema(description = "Account details of the Customer")
    var accountsDto: AccountsDto?  = null,
)