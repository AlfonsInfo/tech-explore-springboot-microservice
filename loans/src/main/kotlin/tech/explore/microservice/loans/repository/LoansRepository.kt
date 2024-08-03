package tech.explore.microservice.loans.repository

import org.springframework.stereotype.Repository
import tech.explore.microservice.loans.domain.entity.LoansEntity
import java.util.*


@Repository
interface LoansRepository : SoftDeleteRepository<LoansEntity, Long>{

    fun findByMobileNumber(mobileNumber: String?): Optional<LoansEntity?>

    fun findByLoanNumber(loanNumber: String?): Optional<LoansEntity?>?
}