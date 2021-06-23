package com.example.retailstore.billing.service

import org.springframework.stereotype.Service
import com.example.retailstore.billing.dto.UserCartInfo
import com.example.retailstore.billing.interfaces.GenerateBillInterface
import com.example.retailstore.billing.model.Bill
import com.example.retailstore.billing.model.CartItem
import com.example.retailstore.billing.model.CartItemCategory
import com.example.retailstore.billing.model.User
import java.text.SimpleDateFormat
import java.util.*

import kotlin.math.floor

@Service
class GenerateBill : GenerateBillInterface {
    private var userBill: Bill? = null
    private var user: User? = null
    override fun getBill(userCartInfo: UserCartInfo): Bill {
        userBill = Bill()
        user = userCartInfo.user
        userBill!!.cartItemList = userCartInfo.cartItemList
        userBill!!.totalBill = getTotalItemCost(userCartInfo.cartItemList)
        userDiscount(userBill!!.totalBill)
        finalDiscount(userBill!!.totalBillAfterDiscount)
        setIdAndCreationDate(userBill!!)
        return userBill as Bill
    }

    fun setIdAndCreationDate(userBill: Bill) {

        userBill.id=UUID.randomUUID().toString()
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        userBill.creationDate=currentDate
    }

    override fun getTotalItemCost(cartItemList: List<CartItem>): Double {
        var totalCost = 0.0
        for (cartItem in userBill?.cartItemList!!) {
            totalCost += cartItem.itemPrice
        }
        return totalCost
    }

    override fun getGroceriesCost(cartItemList: List<CartItem>): Double {
        var cost = 0.0
        for (cartItem in userBill?.cartItemList!!) {
            if (cartItem.category == CartItemCategory.GROCERY) {
                cost += cartItem.itemPrice
            }
        }
        return cost
    }

    override fun userDiscount(cost: Double) {
        var discountValue = 0.0
        println(user?.userType?.getDiscountPercentage());
        val discountPercentage: Int = user?.userType!!.getDiscountPercentage()
        val groceriesValue = userBill?.let { getGroceriesCost(it.cartItemList) }
        discountValue = cost - groceriesValue!!
        discountValue = discountValue * discountPercentage / 100
        userBill!!.totalBillAfterDiscount = (cost - discountValue)
    }

    override fun finalDiscount(billCost: Double) {
        userBill!!.finalBill = (billCost - floor(floor(billCost) / 100) * 5)
    }
}