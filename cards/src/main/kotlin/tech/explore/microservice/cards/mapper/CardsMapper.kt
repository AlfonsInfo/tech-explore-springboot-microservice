package tech.explore.microservice.cards.mapper

import tech.explore.microservice.cards.domain.dto.CardsDto
import tech.explore.microservice.cards.domain.entity.CardsEntity


class CardsMapper {
    companion object{
        fun mapToCardsDto(cards: CardsEntity, cardsDto: CardsDto): CardsDto {
            cardsDto.cardNumber = cards.cardNumber
            cardsDto.cardType = cards.cardType
            cardsDto.mobileNumber = cards.mobileNumber
            cardsDto.totalLimit = cards.totalLimit
            cardsDto.availableAmount = cards.availableAmount
            cardsDto.amountUsed = cards.amountUsed
            return cardsDto
        }

        fun mapToCards(cardsDto: CardsDto, cards: CardsEntity): CardsEntity {
            cards.cardNumber = cardsDto.cardNumber ?: ""
            cards.cardType = cardsDto.cardType ?: ""
            cards.mobileNumber = cardsDto.mobileNumber
            cards.totalLimit = cardsDto.totalLimit
            cards.availableAmount = cardsDto.availableAmount
            cards.amountUsed = cardsDto.amountUsed
            return cards
        }
    }
}