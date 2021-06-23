package com.example.retailstore.billing.dto


import com.example.retailstore.billing.model.Bill
import com.example.retailstore.billing.model.CartItem
import com.example.retailstore.billing.model.User
import com.example.retailstore.billing.model.UserType

class UserCartInfo {
   lateinit var user: User
    lateinit var cartItemList: List<CartItem>
}