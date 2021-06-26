package com.example.retailstore.billing.dto



import com.example.retailstore.billing.model.CartItem
import com.example.retailstore.billing.model.User


class UserCartInfo {
   lateinit var user: User
    lateinit var cartItemList: List<CartItem>
}