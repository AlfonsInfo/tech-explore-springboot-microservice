package tech.explore.microservice.accounts.service

import tech.explore.microservice.accounts.domain.dto.CardsDto

interface ICardsService {
    /**
     *
     * @param cardsDto - CustomerDto Object
     */
    fun createCards(cardsDto: CardsDto?)

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Cardss Details based on a given mobileNumber
     */
    fun fetchCards(mobileNumber: String?): CardsDto?

    /**
     *
     * @param customerDto - CustomersDto Object
     * @return boolean indicating if the update of Cards details is successful or not
     */
    fun updateCards(customerDto: CardsDto?): Boolean

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of Cards details is successful or not
     */
    fun deleteCards(mobileNumber: String?): Boolean
}