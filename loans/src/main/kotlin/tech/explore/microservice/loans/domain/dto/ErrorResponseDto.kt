package tech.explore.microservice.loans.domain.dto

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

data class ErrorResponseDto (
    val apiPath : String ,
    val errorCode : HttpStatus ,
    val errorMessage : String ,
    val errorTime : LocalDateTime ,
)