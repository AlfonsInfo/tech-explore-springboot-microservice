package tech.explore.microservice.accounts.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity @Table(name = "accounts")
data class AccountsEntity (
    @Id
    @Column(name = "account_number")
    var accountNumber : Long? = null,
    @Column(name = "customer_id")
    var customerId : Long? = null,
    @Column(name = "account_type")
    var accountType : String = "",
    @Column(name = "branch_address")
    var branchAddress : String = ""
) : BaseEntity()