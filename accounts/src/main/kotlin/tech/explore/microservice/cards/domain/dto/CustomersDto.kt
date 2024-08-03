package tech.explore.microservice.cards.domain.dto

data class CustomersDto (
    var name : String? = null,
    var email : String? = null,
    var mobileNumber : String? = null,
    var accountsDto: AccountsDto?  = null,
)