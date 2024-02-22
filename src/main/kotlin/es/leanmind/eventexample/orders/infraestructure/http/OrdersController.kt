package es.leanmind.eventexample.orders.infraestructure.http

import es.leanmind.eventexample.orders.application.usecase.CreateOrder
import es.leanmind.eventexample.orders.application.usecase.dto.ItemParams
import es.leanmind.eventexample.orders.application.usecase.dto.OrderParams
import es.leanmind.eventexample.orders.infraestructure.http.dto.ItemRequest
import es.leanmind.eventexample.orders.infraestructure.http.dto.OrderRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OrdersController {

    @Autowired
    private lateinit var createOrderUseCase: CreateOrder

    @PostMapping("/orders")
    fun createOrder(@RequestBody orderRequest: OrderRequest) {
        return createOrderUseCase(
            orderRequest.toOrderParams()
        )
    }
}

private fun OrderRequest.toOrderParams(): OrderParams {
    return OrderParams(
        id = id,
        items = items.map { it.toItemParams() }
    )
}

private fun ItemRequest.toItemParams(): ItemParams {
    return ItemParams(
        id = id,
        quantity = quantity

    )
}
