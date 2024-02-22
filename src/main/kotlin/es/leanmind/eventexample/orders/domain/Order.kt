package es.leanmind.eventexample.orders.domain

import es.leanmind.eventexample.orders.domain.dto.OrderMaterialize
import java.util.*

class Order private constructor(
    private val id: UUID,
    private val items: Products
) {
    companion object {
        fun from(
            id: UUID,
            products: Products
        ): Order {
            if (products.isEmpty()) {
                throw IllegalArgumentException("An order must have at least one item")
            }
            return Order(
                id,
                products
            )
        }
    }

    fun materialize(): OrderMaterialize {
        return OrderMaterialize(
            id = id,
            total = items.total(),
            products = items.materialize()
        )

    }
}