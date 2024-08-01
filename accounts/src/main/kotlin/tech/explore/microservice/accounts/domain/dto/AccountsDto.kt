package tech.explore.microservice.accounts.domain.dto

data class AccountsDto (
    var accountNumber : Long? = null,
    var accountType : String? = null,
    var branchAddress : String? = null,
)