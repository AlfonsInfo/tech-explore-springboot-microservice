package tech.explore.microservice.accounts.documentation

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import tech.explore.microservice.accounts.domain.dto.ErrorResponseDto

@Tag(
    name = "CRUD Rest API for Accounts in XYZ Bank",
    description = "CRUD REST APIs in XYZ Bank to CREATE, UPDATE, FETCH, DELETE Accounts Details")
annotation class AccountControllerApiDocumentation