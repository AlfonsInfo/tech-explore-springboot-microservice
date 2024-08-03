package tech.explore.microservice.cards.service.impl

import tech.explore.microservice.cards.domain.constants.CardsConstants
import tech.explore.microservice.cards.domain.dto.CardsDto
import tech.explore.microservice.cards.domain.entity.CardsEntity
import tech.explore.microservice.cards.exception.CardAlreadyExistException
import tech.explore.microservice.cards.exception.ResourceNotFoundException
import tech.explore.microservice.cards.mapper.CardsMapper
import tech.explore.microservice.cards.repository.CardsRepository
import tech.explore.microservice.cards.service.ICardsService
import kotlin.random.Random


class CardsService(
    private val cardsRepository: CardsRepository,
) : ICardsService {

    override fun createCards(mobileNumber: String?) {
        cardsRepository.findByMobileNumber(mobileNumber ?: "")
            ?.ifPresent {
                throw CardAlreadyExistException("Card already registered ith given mobile Number $mobileNumber")
            }

        cardsRepository.save(createNewCard(mobileNumber ?: ""))
    }

    override fun fetchCards(mobileNumber: String?): CardsDto {
        val cards =  cardsRepository.findByMobileNumber(mobileNumber!!)?.orElseThrow {
            ResourceNotFoundException(
                "Card",
                "mobileNumber",
                mobileNumber
            )
        }
        return CardsMapper.mapToCardsDto(cards!!, CardsDto())
    }



    override fun updateCards(cardsDto: CardsDto?): Boolean {
        val cards =  cardsRepository.findByCardNumber(cardsDto?.cardNumber)?.orElseThrow {
            ResourceNotFoundException(
                "Card",
                "CardNumber",
                cardsDto?.cardNumber
            )
        }
        CardsMapper.mapToCards(cardsDto!!, cards!!)
        cardsRepository.save<CardsEntity>(cards)
        return true
    }

    override fun deleteCards(mobileNumber: String?): Boolean {
        val cards = cardsRepository.findByMobileNumber(mobileNumber)!!.orElseThrow {
            ResourceNotFoundException(
                "Card",
                "mobileNumber",
                mobileNumber
            )
        }
        cardsRepository.deleteById(cards?.cardId!!)
        return true
    }


    private fun createNewCard(mobileNumber: String): CardsEntity {
        val newCard = CardsEntity()
        val randomCardNumber: Long = 100000000000L + Random.nextInt(900000000)
        newCard.cardNumber = randomCardNumber.toString()
        newCard.mobileNumber = mobileNumber
        newCard.cardType = CardsConstants.CREDIT_CARD
        newCard.totalLimit = CardsConstants.NEW_CARD_LIMIT
        newCard.amountUsed = 0
        newCard.availableAmount = CardsConstants.NEW_CARD_LIMIT
        return newCard
    }


}