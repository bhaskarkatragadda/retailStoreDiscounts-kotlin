package com.example.retailstore.billing.model

enum class UserType(typeId: Int, discountPercentage: Int) {
    EMPLOYEE(1, 30),
    AFFILIATE(2, 10),
    CUSTOMER(3, 5);

    private val userTypeId: Int = typeId
    private val discountPercentage: Int = discountPercentage

    fun getDiscountPercentage(): Int {
        return this.discountPercentage
    }
}