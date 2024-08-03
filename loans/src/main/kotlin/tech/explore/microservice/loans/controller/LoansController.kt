package tech.explore.microservice.loans.controller

import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import tech.explore.microservice.loans.annotation.PhoneNumberPattern
import tech.explore.microservice.loans.annotation.apidocs.*
import tech.explore.microservice.loans.domain.constants.LoansConstants
import tech.explore.microservice.loans.domain.dto.LoansDto
import tech.explore.microservice.loans.domain.dto.ResponseDto
import tech.explore.microservice.loans.service.ILoansService


@LoansControllerApiDoc
@RestController
@RequestMapping(path = ["/api/loans"])
@Validated
class LoansController (
    private val iLoansService: ILoansService
) {


    @CreateLoansApiDoc
    @PostMapping("/create")
    fun createLoan(
        @RequestParam
        @PhoneNumberPattern
        mobileNumber: String?,
    ): ResponseEntity<ResponseDto> {
        iLoansService.createLoan(mobileNumber)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201))
    }


    @FetchLoansApiDoc
    @GetMapping("/fetch")
    fun fetchLoanDetails(
        @RequestParam
        @PhoneNumberPattern
        mobileNumber: String?,
    ): ResponseEntity<LoansDto> {
        val loansDto = iLoansService!!.fetchLoan(mobileNumber)
        return ResponseEntity.status(HttpStatus.OK).body(loansDto)
    }

    @UpdateLoansApiDoc
    @PutMapping("/update")
    fun updateLoanDetails(@Valid @RequestBody loansDto: LoansDto?): ResponseEntity<ResponseDto> {
        val isUpdated = iLoansService.updateLoan(loansDto)
        return if (isUpdated) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200))
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE))
        }
    }

    @DeleteLoansApiDoc
    @DeleteMapping("/delete")
    fun deleteLoanDetails(
        @RequestParam
        @PhoneNumberPattern
        mobileNumber: String?,
    ): ResponseEntity<ResponseDto> {
        val isDeleted = iLoansService!!.deleteLoan(mobileNumber)
        return if (isDeleted) {
            ResponseEntity
                .status(HttpStatus.OK)
                .body(ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200))
        } else {
            ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE))
        }
    }
}
