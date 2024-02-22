package es.leanmind.eventexample.orders.application.repository

import es.leanmind.eventexample.orders.domain.Products
import java.util.UUID

interface ProductRepository {
    fun findProductsByIds(ids: List<UUID>): Products
}