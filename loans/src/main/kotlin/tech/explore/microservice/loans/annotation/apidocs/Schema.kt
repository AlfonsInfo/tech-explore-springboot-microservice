package tech.explore.microservice.loans.annotation.apidocs

import io.swagger.v3.oas.annotations.media.Schema

@Schema(name = "Loans", description = "Schema to hold Loan information")
annotation class SchemaLoansDto()

@Schema(description = "Mobile Number of Customer", example = "4365327698")
annotation class SchemaMobileNumber()

@Schema(description = "Loan Number of the customer", example = "548732457654")
annotation class SchemaLoanNumber()

@Schema(description = "Type of the loan", example = "Home Loan")
annotation class SchemaLoanType()


@Schema(description = "Total loan amount", example = "100000")
annotation class SchemaTotalLoanAmount()

@Schema(description = "Total loan amount paid", example = "1000")
annotation class SchemaAmountPaid()

@Schema(description = "Total outstanding amount against a loan", example = "99000")
annotation class SchemaOutstandingAmount()
