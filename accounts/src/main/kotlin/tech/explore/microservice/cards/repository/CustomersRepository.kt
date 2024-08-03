package tech.explore.microservice.cards.repository

import org.springframework.stereotype.Repository
import tech.explore.microservice.cards.domain.entity.CustomerEntity
import java.util.*


@Repository
interface CustomersRepository : SoftDeleteRepository<CustomerEntity, Long>{
    fun findByMobileNumber(mobileNumber: String?): Optional<CustomerEntity?>?
}