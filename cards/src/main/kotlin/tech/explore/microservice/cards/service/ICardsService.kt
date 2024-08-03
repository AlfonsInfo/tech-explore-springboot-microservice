package tech.explore.microservice.cards.service

import tech.explore.microservice.cards.domain.dto.CardsDto

interface ICardsService {
    /**
     * @param mobileNumber - Mobile number of the customer
     */
    fun createCards(mobileNumber: String?)

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Cards Details based on a given mobileNumber
     */
    fun fetchCards(mobileNumber: String?): CardsDto?

    /**
     *
     * @param cardsDto - CustomersDto Object
     * @return boolean indicating if the update of Cards details is successful or not
     */
    fun updateCards(cardsDto: CardsDto?): Boolean

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Cards details is successful or not
     */
    fun deleteCards(mobileNumber: String?): Boolean
}