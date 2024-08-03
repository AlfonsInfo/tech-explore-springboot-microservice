package tech.explore.microservice.cards.domain.constants

class CardsConstants {
    companion object{
        const val CREDIT_CARD = "Credit Card"
        const val NEW_CARD_LIMIT = 100000
        const val STATUS_201 = "201"
        const val MESSAGE_201 = "Card created successfully"
        const val STATUS_200 = "200"
        const val MESSAGE_200 = "Request processed successfully"
        const val STATUS_417 = "417"
        const val MESSAGE_417_UPDATE = "Update operation failed. Please try again or contact Dev team"
        const val MESSAGE_417_DELETE = "Delete operation failed. Please try again or contact Dev team"
    }
}