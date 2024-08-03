package tech.explore.microservice.loans.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.Pattern
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import tech.explore.microservice.loans.documentation.AccountControllerApiDocumentation
import tech.explore.microservice.loans.documentation.CreateAccountApiDocumentation
import tech.explore.microservice.loans.domain.constants.LoansConstants
import tech.explore.microservice.loans.domain.dto.CustomersDto
import tech.explore.microservice.loans.domain.dto.ResponseDto
import tech.explore.microservice.loans.service.IAccountService
@AccountControllerApiDocumentation
@RestController
@RequestMapping("/api/account")
@Validated
class AccountsController(
    private val iAccountsService: IAccountService,
) {

    @PostMapping("/create")
    @CreateAccountApiDocumentation
    fun createAccount(@Valid @RequestBody customersDto : CustomersDto) : ResponseEntity<ResponseDto>{
        iAccountsService.createAccount(customersDto)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body<ResponseDto>(ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201))
    }

    @GetMapping("/fetch")
    fun fetchAccountDetails(
        @RequestParam @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
        ) mobileNumber: String?,
    ): ResponseEntity<CustomersDto> {
        val customerDto= iAccountsService.fetchAccount(mobileNumber)
        return ResponseEntity.status(HttpStatus.OK).body<CustomersDto>(customerDto)
    }


    @PutMapping("/update")
    fun updateAccountDetails(@RequestBody customerDto: @Valid CustomersDto?): ResponseEntity<ResponseDto> {
        val isUpdated: Boolean = iAccountsService.updateAccount(customerDto)
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

    @DeleteMapping("/delete")
    fun deleteAccountDetails(
        @RequestParam @Pattern(
            regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digits"
        ) mobileNumber: String?,
    ): ResponseEntity<ResponseDto> {
        val isDeleted: Boolean = iAccountsService.deleteAccount(mobileNumber)
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