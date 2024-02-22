package es.leanmind.eventexample.orders.application.publisher

import es.leanmind.eventexample.orders.domain.Order

interface OrdersPublisher {
    fun publish(order: Order)
}