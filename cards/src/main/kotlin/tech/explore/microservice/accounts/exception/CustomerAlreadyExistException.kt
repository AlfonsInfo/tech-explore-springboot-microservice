package tech.explore.microservice.accounts.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class CustomerAlreadyExistsException(message: String?) : RuntimeException(message)

