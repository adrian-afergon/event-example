package es.leanmind.eventexample.orders.domain.dto

import java.util.*

data class OrderMaterialize(
    val id: UUID,
    val total: Double,
    val products: List<ProductMaterialize>
)
