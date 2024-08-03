package tech.explore.microservice.loans.mapper

import tech.explore.microservice.loans.domain.dto.LoansDto
import tech.explore.microservice.loans.domain.entity.LoansEntity


class LoansMapper {
    companion object{
        fun mapToLoansDto(loans: LoansEntity, loansDto: LoansDto): LoansDto {
            loansDto.loanNumber = loans.loanNumber
            loansDto.loanType = loans.loanType
            loansDto.mobileNumber = loans.mobileNumber
            loansDto.totalLoan = loans.totalLoan
            loansDto.amountPaid = loans.amountPaid
            loansDto.outstandingAmount = loans.outstandingAmount
            return loansDto
        }

        fun mapToLoans(loansDto: LoansDto, loans: LoansEntity): LoansEntity {
            loans.setLoanNumber(loansDto.loanNumber)
            loans.setLoanType(loansDto.loanType)
            loans.setMobileNumber(loansDto.mobileNumber)
            loans.setTotalLoan(loansDto.totalLoan)
            loans.setAmountPaid(loansDto.amountPaid)
            loans.setOutstandingAmount(loansDto.outstandingAmount)
            return loans
        }

    }
}