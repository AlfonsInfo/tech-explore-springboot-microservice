package tech.explore.microservice.loans.domain.constants

class LoansConstants {
    companion object{
        const val HOME_LOAN = "Home Loan"
        const val NEW_LOAN_LIMIT = 100000
        const val STATUS_201 = "201"
        const val MESSAGE_201 = "Loan created successfully"
        const val STATUS_200 = "200"
        const val MESSAGE_200 = "Request processed successfully"
        const val STATUS_417 = "417"
        const val MESSAGE_417_UPDATE = "Update operation failed. Please try again or contact Dev team"
        const val MESSAGE_417_DELETE = "Delete operation failed. Please try again or contact Dev team"
    }
}