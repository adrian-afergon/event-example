package es.leanmind.eventexample.orders.domain

data class OrderCreatedEvent (
    val orderId: String,
    val eventType: String,
    val eventDate: String,
    val products: List<ProductEvent>
)