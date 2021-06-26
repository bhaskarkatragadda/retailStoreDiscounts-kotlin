package com.example.retailstore.billing.model

import java.util.*

class User(var name: String, var phone: String?, var userType: UserType) {
    var id: String = UUID.randomUUID().toString()
}