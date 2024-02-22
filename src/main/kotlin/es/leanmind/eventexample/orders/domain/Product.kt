package es.leanmind.eventexample.orders.domain

import java.util.*

class Product private constructor(
    val id: UUID,
    val amount: Amount,
    val name: String
) {
    companion object {
        fun from(
            id: UUID,
            amount: Amount,
            name: String
        ): Product {
            return Product(
                id,
                amount,
                name
            )
        }
    }
}
