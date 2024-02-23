package es.leanmind.eventexample.shared.infraestructure.events

data class OrderCreatedEvent (
    val orderId: String,
    val eventType: String,
    val eventDate: String,
    val version: Int = 1,
    val products: List<ProductEvent>
)

data class ProductEvent (
    val productId: String,
    val quantity: Int,
    val price: Double,
    val total: Double,
    val currency: String
)