package com.example.retailstore.billing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
//@Configuration
//@ComponentScan
class BillingApplication

fun main(args: Array<String>) {
	runApplication<BillingApplication>(*args)
}
