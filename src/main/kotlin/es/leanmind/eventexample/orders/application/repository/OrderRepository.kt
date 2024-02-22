package es.leanmind.eventexample.orders.application.repository

import es.leanmind.eventexample.orders.domain.Order

interface OrderRepository {
    fun save(order: Order)
}