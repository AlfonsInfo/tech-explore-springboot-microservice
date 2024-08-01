package tech.explore.microservice.accounts.repository

import org.springframework.stereotype.Repository
import tech.explore.microservice.accounts.domain.entity.CustomerEntity
import java.util.*


@Repository
interface CustomersRepository : SoftDeleteRepository<CustomerEntity, Long>{
    fun findByMobileNumber(mobileNumber: String?): Optional<CustomerEntity?>?
}