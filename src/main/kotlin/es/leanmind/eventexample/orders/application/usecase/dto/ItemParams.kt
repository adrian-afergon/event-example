package es.leanmind.eventexample.orders.application.usecase.dto

import java.util.*

data class ItemParams (
    val id: UUID,
    val quantity: Int
)
