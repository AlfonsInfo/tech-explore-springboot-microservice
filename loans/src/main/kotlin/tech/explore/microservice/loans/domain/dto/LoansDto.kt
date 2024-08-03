package tech.explore.microservice.loans.domain.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import tech.explore.microservice.loans.annotation.*
import tech.explore.microservice.loans.annotation.apidocs.*
import tech.explore.microservice.loans.documentation.CustomerDtoApiDocumentation


@CustomerDtoApiDocumentation
@SchemaLoansDto
data class LoansDto (

    @SchemaMobileNumber
    @PhoneNumberPattern
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    var mobileNumber: String? = null,

    @SchemaLoanNumber
    @NotEmpty(message = "Loan Number can not be a null or empty")
    @LoanNumberPattern
     var loanNumber:  String? = null,

    @SchemaLoanType
    @NotEmpty(message = "LoanType can not be a null or empty")
    var loanType: String? = null,

    @SchemaTotalLoanAmount
    @Positive(message = "Total loan amount should be greater than zero")
    var totalLoan: Int = 0,

    @SchemaAmountPaid
    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    var amountPaid: Int = 0,

    @SchemaOutstandingAmount
    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    val outstandingAmount:  Int = 0
)

