package tech.explore.microservice.loans

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import tech.explore.microservice.loans.documentation.AccountServiceApiDocumentation

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@AccountServiceApiDocumentation
class AccountsApplication

fun main(args: Array<String>) {
	runApplication<AccountsApplication>(*args)
}
