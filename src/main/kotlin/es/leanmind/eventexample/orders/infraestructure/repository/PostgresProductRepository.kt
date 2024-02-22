package es.leanmind.eventexample.orders.infraestructure.repository

import es.leanmind.eventexample.orders.application.repository.ProductRepository
import es.leanmind.eventexample.orders.domain.Amount
import es.leanmind.eventexample.orders.domain.Product
import es.leanmind.eventexample.orders.domain.Products
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.*

@Component
class PostgresProductRepository(
    private val jdbcTemplate: JdbcTemplate
) : ProductRepository {

    override fun findProductsByIds(ids: List<UUID>): Products {
        return Products.from(jdbcTemplate.query(
            """SELECT * FROM product WHERE id IN (${ids.joinToString(",") { "'$it'" }})""",
            ProductsMapper()
        ))
    }

}

class ProductsMapper : RowMapper<Product> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Product {
        return Product.from(
            id = UUID.fromString(rs.getString("id")),
            amount = Amount.from(
                price = rs.getDouble("price"),
                currency = Currency.getInstance(rs.getString("currency"))
            ),
            rs.getString("name")
        )
    }
}