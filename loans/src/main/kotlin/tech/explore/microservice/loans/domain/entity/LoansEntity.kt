package tech.explore.microservice.loans.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity @Table(name = "loans")
data class LoansEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var loanId: Long? = null, // Nullable untuk mendukung NoArgsConstructor
    var mobileNumber: String = "",
    var loanNumber: String = "",
    var loanType: String = "",
    var totalLoan: Int = 0,
    var amountPaid: Int = 0,
    var outstandingAmount: Int = 0
) : BaseEntity()