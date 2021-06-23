package com.example.retailstore.billing


import org.springframework.boot.test.context.SpringBootTest
import org.mockito.Mock
import org.mockito.InjectMocks
import com.example.retailstore.billing.service.GenerateBill
import org.junit.jupiter.api.BeforeEach
import com.example.retailstore.billing.dto.UserCartInfo
import com.example.retailstore.billing.model.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.ArrayList

@SpringBootTest
class BillingApplicationTests {
    @Mock
    var cartItemList: MutableList<CartItem>? = null

    @InjectMocks
    var generateBill: GenerateBill? = null
    @BeforeEach
    fun before() {
        cartItemList = ArrayList()
        var item = CartItem()
        item.itemName = "Soap"
        item.itemPrice = 20.0
        item.category = CartItemCategory.GROCERY
        (cartItemList as ArrayList<CartItem>).add(item)
        item = CartItem()
        item.itemName = "Shirt"
        item.itemPrice = 500.0
        item.category = CartItemCategory.FASHION
        (cartItemList as ArrayList<CartItem>).add(item)
        item = CartItem()
        item.itemName = "Laptop Battery"
        item.itemPrice = 1000.0
        item.category = CartItemCategory.ELECTRONICS
        (cartItemList as ArrayList<CartItem>).add(item)
    }

    @Test
    fun test() {
        println("Test Application Started")
    }

    @Test
    fun testEmployeeDiscount() {
        val user = User("bhaskar", "1234567890", UserType.EMPLOYEE)
        val userCartInfo = UserCartInfo()
        userCartInfo.user = user
        userCartInfo.cartItemList = cartItemList!!
        val resultUserBill = generateBill!!.getBill(userCartInfo)
        Assertions.assertEquals(
            1020.0,
            resultUserBill.finalBill
        )
    }

    @Test
    fun testAffiliateDiscount() {
        val user = User("bhaskar", "1234567890", UserType.AFFILIATE)
        val userCartInfo = UserCartInfo()
        userCartInfo.user = user
        userCartInfo.cartItemList = cartItemList!!
        val resultUserBill = generateBill!!.getBill(userCartInfo)
        Assertions.assertEquals(
            1305.0,
            resultUserBill.finalBill
        )
    }

    @Test
    fun testCustomerDiscount() {
        val user = User("bhaskar", "1234567890", UserType.CUSTOMER)
        val userCartInfo = UserCartInfo()
        userCartInfo.user = user
        userCartInfo.cartItemList = cartItemList!!
        val resultUserBill = generateBill!!.getBill(userCartInfo)
        Assertions.assertEquals(
            1375.0,
            resultUserBill.finalBill
        )
    }
}