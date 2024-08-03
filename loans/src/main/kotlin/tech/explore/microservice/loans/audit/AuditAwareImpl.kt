package tech.explore.microservice.loans.audit

import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component
import java.util.Optional


@Component("auditAwareImpl")
class AuditAwareImpl : AuditorAware<String> {
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.of("ACCOUNTS_MS")
    }
}

