package com.example.retailstore.billing.model


import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.floor


class Bill  (private var cartItemList: List<CartItem>, private var user: User) {
    var id: String = UUID.randomUUID().toString()
    var creationDate: String = DateTimeFormatter.ISO_INSTANT.format(Instant.now())
    private var totalBill: Double = 0.0
    private var totalBillAfterUserDiscount: Double = 0.0
    private var totalBillAfterFinalDiscount: Double = 0.0



    fun getBill():Double{
        getTotalItemCost()
        applyUserDiscount(totalBill)
        applyFinalDiscount(totalBillAfterUserDiscount)
        return totalBillAfterFinalDiscount
    }

    private fun getTotalItemCost() {
        var totalCost = 0.0
        for (cartItem in this.cartItemList) {
            totalCost += cartItem.itemPrice
        }
       this.totalBill = totalCost
    }

    private fun getGroceriesCost(): Double {
        var cost = 0.0
        for (cartItem in this.cartItemList) {
            if (cartItem.category == CartItemCategory.GROCERY) {
                cost += cartItem.itemPrice
            }
        }
        return cost
    }

    private fun applyUserDiscount(cost: Double) {

        val discountPercentage: Int = user.userType.getDiscountPercentage()
        val groceriesValue =  getGroceriesCost()
        var discountValue = cost - groceriesValue
        discountValue = discountValue * discountPercentage / 100
        this.totalBillAfterUserDiscount = (cost - discountValue)
    }

    private fun applyFinalDiscount(billCost: Double) {
        this.totalBillAfterFinalDiscount= (billCost - floor(floor(billCost) / 100) * 5)
    }

}