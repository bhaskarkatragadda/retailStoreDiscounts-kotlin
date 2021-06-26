package com.example.retailstore.billing.`interface`

interface BillInterface {
    fun getBill():Double
    fun getTotalItemCost()
    fun getGroceriesCost():Double
    fun applyUserDiscount(cost:Double)
    fun applyFinalDiscount(billCost: Double)
}