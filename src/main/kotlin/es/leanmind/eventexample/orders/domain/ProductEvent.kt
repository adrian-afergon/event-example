package es.leanmind.eventexample.orders.domain

data class ProductEvent (
    val productId: String,
    val quantity: Int,
    val price: Double,
    val total: Double,
    val currency: String
)
