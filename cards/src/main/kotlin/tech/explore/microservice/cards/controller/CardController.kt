package tech.explore.microservice.cards.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import tech.explore.microservice.cards.documentation.CardControllerApiDoc
import tech.explore.microservice.cards.documentation.CreateCardApiDoc
import tech.explore.microservice.cards.documentation.DeleteCardApiDoc
import tech.explore.microservice.cards.documentation.FetchCardApiDoc
import tech.explore.microservice.cards.domain.constants.CardsConstants
import tech.explore.microservice.cards.domain.dto.CardsDto
import tech.explore.microservice.cards.domain.dto.ResponseDto
import tech.explore.microservice.cards.service.ICardsService


@CardControllerApiDoc
@RestController
@RequestMapping("/api/cards")
@Validated
class CardController(
    private val iCardsService: ICardsService,
) {


    @PostMapping("/create")
    @CreateCardApiDoc
    fun createCard(
        @RequestParam mobileNumber: @Valid @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String?,
    ): ResponseEntity<ResponseDto> {
        iCardsService.createCards(mobileNumber)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201))
    }

    @GetMapping("/fetch")
    @FetchCardApiDoc
    fun fetchCardDetails(
        @RequestParam mobileNumber: @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
        ) String?,
    ): ResponseEntity<CardsDto> {
        val cardsDto = iCardsService.fetchCards(mobileNumber)
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto)
    }

    @PutMapping("/update")
    @FetchCardApiDoc
    fun updateCardDetails(@RequestBody cardsDto: @Valid CardsDto?): ResponseEntity<ResponseDto> {
        val isUpdated: Boolean = iCardsService.updateCards(cardsDto)
        return if (isUpdated) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200))
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_UPDATE))
        }
    }

    @DeleteMapping("/delete")
    @DeleteCardApiDoc
    fun deleteCardDetails(
        @RequestParam mobileNumber: @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
        ) String?,
    ): ResponseEntity<ResponseDto> {
        val isDeleted: Boolean = iCardsService.deleteCards(mobileNumber)
        return if (isDeleted) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200))
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ResponseDto(CardsConstants.STATUS_417, CardsConstants.MESSAGE_417_DELETE))
        }
    }

}