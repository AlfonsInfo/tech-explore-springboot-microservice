package tech.explore.microservice.cards.repository

import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import tech.explore.microservice.cards.domain.entity.AccountsEntity
import java.util.*


@Repository
interface AccountsRepository : SoftDeleteRepository<AccountsEntity, Long>{
    fun findByCustomerId(customerId : Long) : Optional<AccountsEntity>

    @Transactional
    @Modifying
    fun deleteByCustomerId(customerId: Long?)
}