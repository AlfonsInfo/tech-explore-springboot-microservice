package tech.explore.microservice.cards.repository

import org.springframework.stereotype.Repository
import tech.explore.microservice.cards.domain.entity.CardsEntity
import java.util.*


@Repository
interface CardsRepository : SoftDeleteRepository<CardsEntity, Long>{
    fun findByMobileNumber(mobileNumber: String?): Optional<CardsEntity?>?

    fun findByCardNumber(cardNumber: String?): Optional<CardsEntity?>?
}