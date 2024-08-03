package tech.explore.microservice.loans.service.impl

import org.springframework.stereotype.Service
import tech.explore.microservice.loans.domain.constants.LoansConstants
import tech.explore.microservice.loans.domain.dto.LoansDto
import tech.explore.microservice.loans.domain.entity.LoansEntity
import tech.explore.microservice.loans.exception.LoanAlreadyExistsException
import tech.explore.microservice.loans.exception.ResourceNotFoundException
import tech.explore.microservice.loans.mapper.LoansMapper
import tech.explore.microservice.loans.repository.LoansRepository
import tech.explore.microservice.loans.service.ILoansService
import kotlin.random.Random


@Service
class LoansService(
    private val loansRepository: LoansRepository,
) : ILoansService {
    override fun createLoan(mobileNumber: String?) {
         loansRepository.findByMobileNumber(mobileNumber).ifPresent{
             throw LoanAlreadyExistsException("Loan already registered with given mobileNumber $mobileNumber")
         }
        loansRepository.save(createNewLoan(mobileNumber!!))
    }

    override fun fetchLoan(mobileNumber: String?): LoansDto? {
        val loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow {
            ResourceNotFoundException(
                "Loan",
                "mobileNumber",
                mobileNumber
            )
        }
        return LoansMapper.mapToLoansDto(loans!!, LoansDto())
    }

    override fun updateLoan(loansDto: LoansDto?): Boolean {
        val loans =
            loansRepository.findByLoanNumber(loansDto?.loanNumber)!!.orElseThrow<ResourceNotFoundException> {
                ResourceNotFoundException(
                    "Loan",
                    "LoanNumber",
                    loansDto?.loanNumber
                )
            }
        LoansMapper.mapToLoans(loansDto!!, loans!!)
        loansRepository.save<LoansEntity>(loans)
        return true
    }

    override fun deleteLoan(mobileNumber: String?): Boolean {
        val loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow {
            ResourceNotFoundException(
                "Loan",
                "mobileNumber",
                mobileNumber
            )
        }
        loansRepository.deleteById(loans?.loanId!!)
        return true
    }


    fun createNewLoan(mobileNumber: String): LoansEntity {
        val randomLoanNumber = 100_000_000_000L + Random.nextInt(900_000_000)
        return LoansEntity(
            loanNumber = randomLoanNumber.toString(),
            mobileNumber = mobileNumber,
            loanType = LoansConstants.HOME_LOAN,
            totalLoan = LoansConstants.NEW_LOAN_LIMIT,
            amountPaid = 0,
            outstandingAmount = LoansConstants.NEW_LOAN_LIMIT
        )
    }

}