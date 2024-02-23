package es.leanmind.eventexample.orders.infraestructure.publisher

import es.leanmind.eventexample.orders.application.publisher.OrdersPublisher
import es.leanmind.eventexample.orders.domain.Order
import es.leanmind.eventexample.shared.infraestructure.events.OrderCreatedEvent
import es.leanmind.eventexample.shared.infraestructure.events.ProductEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.logging.Logger

@Component
class ModulithOrdersPublisher(events: ApplicationEventPublisher): OrdersPublisher {
    private var events: ApplicationEventPublisher? = null
    private val logger: Logger = Logger.getLogger(ModulithOrdersPublisher::class.java.name)

    init {
        this.events = events
    }

    @Transactional
    override fun publish(order: Order) {
        val materializedOrder = order.materialize()
        logger.info("Publishing order: $materializedOrder")
        events!!.publishEvent(OrderCreatedEvent(
            orderId = materializedOrder.id.toString(),
            eventType = "orders.create",
            eventDate = LocalDateTime.now().toString(),
            products = materializedOrder.products.map { ProductEvent(
                productId = it.id.toString(),
                quantity = it.quantity,
                price = it.price,
                total = it.total,
                currency = it.currency
            )
            }
        ))
    }
}