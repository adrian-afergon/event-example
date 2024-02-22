package es.leanmind.eventexample.orders.application.usecase

import es.leanmind.eventexample.orders.application.publisher.OrdersPublisher
import es.leanmind.eventexample.orders.application.repository.OrderRepository
import es.leanmind.eventexample.orders.application.repository.ProductRepository
import es.leanmind.eventexample.orders.application.usecase.dto.OrderParams
import es.leanmind.eventexample.orders.domain.Order
import org.springframework.stereotype.Component

@Component
class CreateOrder(
    private val productRepository: ProductRepository,
    private val ordersPublisher: OrdersPublisher,
    private val orderRepository: OrderRepository,
) {
    operator fun invoke(orderParams: OrderParams) {
        val products = productRepository.findProductsByIds(orderParams.items.map { it.id })
        // for every item based on quantity we will include the product in the list
        val productsAtOrder = orderParams.items.fold(products) { acc, item ->
            acc.applyProductQuantity(item.id, item.quantity)
        }

        val order = Order.from(
            id = orderParams.id,
            products = productsAtOrder
        )

        orderRepository.save(order)
        ordersPublisher.publish(order)
    }
}