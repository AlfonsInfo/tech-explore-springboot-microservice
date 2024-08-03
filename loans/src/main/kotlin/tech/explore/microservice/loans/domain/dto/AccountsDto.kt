package tech.explore.microservice.loans.domain.dto

data class AccountsDto (
    var accountNumber : Long? = null,
    var accountType : String? = null,
    var branchAddress : String? = null,
)