package es.leanmind.eventexample.mail.infrastructure

import es.leanmind.eventexample.shared.infraestructure.events.OrderCreatedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener

import org.springframework.stereotype.Component

@Component
class CreateOrderMailerListener {
    val logger: Logger = LoggerFactory.getLogger(CreateOrderMailerListener::class.java)

    @ApplicationModuleListener
    fun onOrderCreated(order: OrderCreatedEvent) {
        logger.info("[Mail module]: Order created: $order")
        logger.info("[Mail module]: We need to send an email to the customer!")
    }

}