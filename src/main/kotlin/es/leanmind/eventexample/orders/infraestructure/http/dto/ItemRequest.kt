package es.leanmind.eventexample.orders.infraestructure.http.dto

import java.util.*

data class ItemRequest(
    val id: UUID,
    val quantity: Int
)
