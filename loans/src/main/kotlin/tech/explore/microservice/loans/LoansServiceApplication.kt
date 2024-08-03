package tech.explore.microservice.loans

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import tech.explore.microservice.loans.annotation.apidocs.LoansApplicationServiceApiDoc

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@LoansApplicationServiceApiDoc
class LoansServiceApplication

fun main(args: Array<String>) {
	runApplication<LoansServiceApplication>(*args)
}
