package tech.explore.microservice.accounts.domain.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.PositiveOrZero
import tech.explore.microservice.accounts.documentation.CardDtoApiDoc


@CardDtoApiDoc
data class CardsDto (
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    @Schema(description = "Mobile Number of Customer", example = "4354437687")
    private val mobileNumber: @NotEmpty(message = "Mobile Number can not be a null or empty") String? = null,

    @Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits")
    @Schema(description = "Card Number of the customer", example = "100646930341")
    private val cardNumber: @NotEmpty(message = "Card Number can not be a null or empty") String? = null,

    @Schema(description = "Type of the card", example = "Credit Card")
    private val cardType: @NotEmpty(message = "CardType can not be a null or empty") String? = null,

    @Schema(description = "Total amount limit available against a card", example = "100000")
    private val totalLimit: @Positive(message = "Total card limit should be greater than zero") Int = 0,

    @Schema(description = "Total amount used by a Customer", example = "1000")
    private val amountUsed: @PositiveOrZero(message = "Total amount used should be equal or greater than zero") Int = 0,

    @Schema(description = "Total available amount against a card", example = "90000")
    private val availableAmount: @PositiveOrZero(message = "Total available amount should be equal or greater than zero") Int =
        0
)

