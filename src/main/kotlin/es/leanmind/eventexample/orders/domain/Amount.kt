package es.leanmind.eventexample.orders.domain

import java.util.*

class Amount private constructor(
    val price: Double,
    private val currency: Currency
){
    companion object {
        fun from(
            price: Double,
            currency: Currency
        ): Amount {
            if (price <= 0) {
                throw IllegalArgumentException("Price must be greater than 0")
            }
            return Amount(
                price,
                currency
            )
        }
    }

    fun getCurrencyCode ( ) : String {
        return currency.currencyCode
    }
}