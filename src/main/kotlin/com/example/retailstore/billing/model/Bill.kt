package com.example.retailstore.billing.model



class Bill {
    var id: String = ""
    var creationDate: String=""
   lateinit var cartItemList: List<CartItem>
    var totalBill: Double = 0.0
    var totalBillAfterDiscount: Double = 0.0
    var finalBill: Double = 0.0
}