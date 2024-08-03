package tech.explore.microservice.accounts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import tech.explore.microservice.accounts.documentation.CardServiceDoc

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@CardServiceDoc
class AccountApplication

fun main(args: Array<String>) {
	runApplication<AccountApplication>(*args)
}
