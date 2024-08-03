package tech.explore.microservice.accounts.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import tech.explore.microservice.accounts.domain.entity.CardsEntity
import java.util.*


@Repository
interface CardsRepository : SoftDeleteRepository<CardsEntity, Long>{
    fun findByCustomerId(customerId : Long) : Optional<CardsEntity>

    @Transactional
    @Modifying
    fun deleteByCustomerId(customerId: Long?)
}