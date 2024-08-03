package tech.explore.microservice.loans.repository

import org.springframework.stereotype.Repository
import tech.explore.microservice.loans.domain.entity.CustomerEntity
import java.util.*


@Repository
interface CustomersRepository : SoftDeleteRepository<CustomerEntity, Long>{
    fun findByMobileNumber(mobileNumber: String?): Optional<CustomerEntity?>?
}