package es.leanmind.eventexample.orders.infraestructure.repository

import es.leanmind.eventexample.orders.application.repository.OrderRepository
import es.leanmind.eventexample.orders.domain.Order
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.sql.DataSource

@Component
class PostgresOrderRepository(
    private val jdbcTemplate: JdbcTemplate,
    val dataSource: DataSource
) : OrderRepository {
    override fun save(order: Order) {

        val materialize = order.materialize()
        jdbcTemplate.update(
            "INSERT INTO \"order\" (id, date) VALUES (?, ?)",
            materialize.id, Timestamp.valueOf(LocalDateTime.now())
        )

        materialize.products.forEach { product ->
            jdbcTemplate.update(
                "INSERT INTO \"order_product\" (order_id, product_id, quantity, price, total, currency) VALUES (?, ?, ?, ?, ?, ?)",
                materialize.id,
                product.id,
                product.quantity,
                product.price,
                product.total,
                product.currency
            )
        }
    }
}