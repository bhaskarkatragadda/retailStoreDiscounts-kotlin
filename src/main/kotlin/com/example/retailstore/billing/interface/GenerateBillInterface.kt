package com.example.retailstore.billing.interfaces


import com.example.retailstore.billing.dto.UserCartInfo
import com.example.retailstore.billing.model.Bill
import com.example.retailstore.billing.model.CartItem

interface GenerateBillInterface {
    fun getBill(userCartInfo: UserCartInfo): Bill
    fun getTotalItemCost(cartItemList: List<CartItem>): Double
    fun getGroceriesCost(cartItemList: List<CartItem>): Double
    fun userDiscount(cost: Double)
    fun finalDiscount(billCost: Double)
}