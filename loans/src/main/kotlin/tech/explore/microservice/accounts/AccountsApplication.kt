package tech.explore.microservice.accounts

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import tech.explore.microservice.accounts.documentation.AccountServiceApiDocumentation

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@AccountServiceApiDocumentation
class AccountsApplication

fun main(args: Array<String>) {
	runApplication<AccountsApplication>(*args)
}
