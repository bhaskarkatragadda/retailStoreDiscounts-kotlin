package com.example.retailstore.billing.service

import org.springframework.stereotype.Service
import com.example.retailstore.billing.dto.UserCartInfo
import com.example.retailstore.billing.model.Bill
import com.example.retailstore.billing.model.User



@Service
class GenerateBill  {
    fun getBill(userCartInfo: UserCartInfo): Bill {
        val user = User(userCartInfo.user.name,userCartInfo.user.phone?:userCartInfo.user.phone,userCartInfo.user.userType)
        val bill = Bill(userCartInfo.cartItemList,user)
        bill.getBill()
        return bill
    }
}