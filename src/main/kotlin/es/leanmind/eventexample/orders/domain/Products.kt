package es.leanmind.eventexample.orders.domain

import es.leanmind.eventexample.orders.domain.dto.ProductMaterialize
import java.util.*

class Products private constructor(
    private val products: List<Product>
) {
    fun isEmpty(): Boolean {
        return products.isEmpty()
    }

    companion object {
        fun from(
            items: List<Product>
        ): Products {
            return Products(
                items
            )
        }
    }

    fun applyProductQuantity(id: UUID, quantity: Int): Products {
        val product = products.find { it.id == id }
        if (product == null) {
            throw IllegalArgumentException("Product not found")
        }
        return from(
            List(quantity -1) { product } + products
        )
    }

    fun total(): Double {
        // TODO: Amount should know how to sum itself
        return products.sumByDouble { it.amount.price }
    }

    fun materialize(): List<ProductMaterialize> {
        return products.groupBy { it.id }.entries.map { (id, products) ->
            val product = products.first()
            ProductMaterialize(
                id = id,
                name = product.name,
                price = product.amount.price,
                currency = product.amount.getCurrencyCode(),
                quantity = products.size,
                total = products.sumByDouble { it.amount.price }
            )
        }
    }

}
