package es.leanmind.eventexample.orders.infraestructure.http.dto

import java.util.UUID

data class OrderRequest(
    val id: UUID,
    val items: List<ItemRequest>
)
