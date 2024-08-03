package tech.explore.microservice.accounts.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import tech.explore.microservice.accounts.documentation.CardControllerApiDoc
import tech.explore.microservice.accounts.documentation.CreateCardApiDoc
import tech.explore.microservice.accounts.domain.constants.CardConstants
import tech.explore.microservice.accounts.domain.dto.CardsDto
import tech.explore.microservice.accounts.domain.dto.ResponseDto
import tech.explore.microservice.accounts.service.ICardsService
@CardControllerApiDoc
@RestController
@RequestMapping("/api/cards")
@Validated
class CardController(
    private val iCardsService: ICardsService,
) {

    @PostMapping("/create")
    @CreateCardApiDoc
    fun createAccount(@Valid @RequestBody cardsDto : CardsDto) : ResponseEntity<ResponseDto>{
        iCardsService.createCards(cardsDto)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body<ResponseDto>(ResponseDto(CardConstants.STATUS_201, CardConstants.MESSAGE_201))
    }

    @GetMapping("/fetch")
    fun fetchCardsDetails(
        @RequestParam @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
        ) mobileNumber: String?,
    ): ResponseEntity<CardsDto> {
        val customerDto= iCardsService.fetchCards(mobileNumber)
        return ResponseEntity.status(HttpStatus.OK).body<CardsDto>(customerDto)
    }


    @PutMapping("/update")
    fun updateCardsDetails(@RequestBody customerDto: @Valid CardsDto?): ResponseEntity<ResponseDto> {
        val isUpdated: Boolean = iCardsService.updateCards(customerDto)
        return if (isUpdated) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200))
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_UPDATE))
        }
    }

    @DeleteMapping("/delete")
    fun deleteAccountDetails(
        @RequestParam @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
        ) mobileNumber: String?,
    ): ResponseEntity<ResponseDto> {
        val isDeleted: Boolean = iCardsService.deleteCards(mobileNumber)
        return if (isDeleted) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto(CardConstants.STATUS_200, CardConstants.MESSAGE_200))
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ResponseDto(CardConstants.STATUS_417, CardConstants.MESSAGE_417_DELETE))
        }
    }

}