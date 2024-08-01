package tech.explore.microservice.accounts.domain.dto

data class CustomersDto (
    var name : String? = null,
    var email : String? = null,
    var mobileNumber : String? = null,
    var accountsDto: AccountsDto?  = null,
)