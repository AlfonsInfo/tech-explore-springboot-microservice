package tech.explore.microservice.cards.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import tech.explore.microservice.cards.domain.dto.ErrorResponseDto
import java.time.LocalDateTime
import java.util.function.Consumer


@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    protected fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException, headers: HttpHeaders?, status: HttpStatusCode?, request: WebRequest?,
    ): ResponseEntity<Any> {
        val validationErrors: MutableMap<String, String?> = HashMap()
        val validationErrorList = ex.bindingResult.allErrors
        validationErrorList.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val validationMsg = error.getDefaultMessage()
            validationErrors[fieldName] = validationMsg
        })
        return ResponseEntity(validationErrors, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleGlobalException(
        exception: Exception,
        webRequest: WebRequest,
    ): ResponseEntity<ErrorResponseDto> {
        val errorResponseDTO = ErrorResponseDto(
            webRequest.getDescription(false),
            HttpStatus.INTERNAL_SERVER_ERROR,
            exception.message!!,
            LocalDateTime.now()
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorResponseDTO)
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(
        exception: ResourceNotFoundException,
        webRequest: WebRequest,
    ): ResponseEntity<ErrorResponseDto> {
        val errorResponseDTO = ErrorResponseDto(
            webRequest.getDescription(false),
            HttpStatus.NOT_FOUND,
            exception.message!!,
            LocalDateTime.now()
        )
        return ResponseEntity(errorResponseDTO, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(CardAlreadyExistException::class)
    fun handleCardAlreadyExistsException(
        exception: CardAlreadyExistException,
        webRequest: WebRequest,
    ): ResponseEntity<ErrorResponseDto> {
        val errorResponseDTO = ErrorResponseDto(
            webRequest.getDescription(false),
            HttpStatus.BAD_REQUEST,
            exception.message ?: "Bad Request",
            LocalDateTime.now()
        )
        return ResponseEntity(errorResponseDTO, HttpStatus.BAD_REQUEST)
    }
}

