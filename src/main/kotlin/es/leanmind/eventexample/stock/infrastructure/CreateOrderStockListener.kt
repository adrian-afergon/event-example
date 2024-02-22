package es.leanmind.eventexample.stock.infrastructure

import es.leanmind.eventexample.orders.domain.OrderCreatedEvent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.stereotype.Component

@Component
class CreateOrderStockListener {
    val logger: Logger = LoggerFactory.getLogger(CreateOrderStockListener::class.java)

    @ApplicationModuleListener
    fun onOrderCreated(order: OrderCreatedEvent) {
        logger.info("[Stock Module]: Order created: $order")
        order.products.forEach() {
            logger.info("[Stock Module]: We need to reduce the stock of Product: ${it.productId}, quantity: ${it.quantity}")
        }
    }

}