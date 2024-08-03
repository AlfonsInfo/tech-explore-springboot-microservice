package tech.explore.microservice.loans.annotation

import jakarta.validation.Constraint
import tech.explore.microservice.loans.validator.LoanNumberValidator
import tech.explore.microservice.loans.validator.PhoneNumberValidator
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PhoneNumberValidator::class])
annotation class PhoneNumberPattern(
    val message: String = "Mobile Number must be 10 digits",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
)

@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [LoanNumberValidator::class])
annotation class LoanNumberPattern(
    val message: String = "LoanNumber must be 12 digits",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Any>> = []
)