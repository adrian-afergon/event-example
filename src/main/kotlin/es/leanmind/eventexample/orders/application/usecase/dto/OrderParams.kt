package es.leanmind.eventexample.orders.application.usecase.dto

import java.util.UUID

data class OrderParams(
    val id: UUID,
    val items: List<ItemParams>
)
