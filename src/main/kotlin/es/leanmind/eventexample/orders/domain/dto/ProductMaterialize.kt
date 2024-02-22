package es.leanmind.eventexample.orders.domain.dto

import java.util.UUID

data class ProductMaterialize (
    val id: UUID,
    val name: String,
    val price: Double,
    val quantity: Int,
    val currency: String,
    val total: Double
)