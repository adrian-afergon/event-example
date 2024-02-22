package es.leanmind.eventexample.orders.infraestructure.tasks

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.modulith.events.IncompleteEventPublications
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Duration


@Component
class Scheduler (
        @Autowired
        private val incompleteEventPublications: IncompleteEventPublications
){

    val logger = org.slf4j.LoggerFactory.getLogger(Scheduler::class.java)

    @Scheduled(cron = "0 * * * * *")
    fun schedule() {
        logger.info("Retry incomplete events...")
        incompleteEventPublications.resubmitIncompletePublicationsOlderThan(Duration.ZERO)
        logger.info("Retry incomplete events done")
    }
}