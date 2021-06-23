package com.example.retailstore.billing.model

class User(name: String?, phone: String?, userType: UserType?) {
    var id: String ? = null
    var name: String? = null
    var phone: String? = null
    var userType: UserType? = null

    init {
        this.name = name
        this.phone = phone
        this.userType = userType
    }
}