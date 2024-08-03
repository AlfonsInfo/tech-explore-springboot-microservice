package tech.explore.microservice.cards

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import tech.explore.microservice.cards.documentation.CardServiceDoc

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@CardServiceDoc
class CardServiceApplication

fun main(args: Array<String>) {
	runApplication<CardServiceApplication>(*args)
}
