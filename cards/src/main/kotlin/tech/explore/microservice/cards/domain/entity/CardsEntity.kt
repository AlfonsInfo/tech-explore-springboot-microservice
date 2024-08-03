package tech.explore.microservice.cards.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity @Table(name = "cards")
data class CardsEntity (
    @Id
    var cardId : Long? = null,
    var mobileNumber : String? = null,
    var cardNumber : String = "",
    var cardType : String = "",
    var totalLimit : Int = 0,
    var amountUsed  :  Int =  0,
    var availableAmount : Int = 0
) : BaseEntity()