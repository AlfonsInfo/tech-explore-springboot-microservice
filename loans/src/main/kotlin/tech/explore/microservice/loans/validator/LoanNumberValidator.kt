package tech.explore.microservice.loans.validator

import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import tech.explore.microservice.loans.annotation.LoanNumberPattern
import tech.explore.microservice.loans.annotation.PhoneNumberPattern

class LoanNumberValidator : ConstraintValidator<PhoneNumberPattern, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext): Boolean {
        // Allow null or empty string as valid
        if (value.isNullOrEmpty()) {
            return true
        }
        // Validate against 10-digit pattern
        return value.matches(Regex("[0-9]{10}"))
    }
}


