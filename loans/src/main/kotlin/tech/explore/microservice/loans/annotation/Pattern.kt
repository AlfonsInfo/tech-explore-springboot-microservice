package tech.explore.microservice.loans.annotation

import jakarta.validation.constraints.Pattern


@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
annotation class PhoneNumberPattern ()


@Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
annotation class LoanNumberPattern()