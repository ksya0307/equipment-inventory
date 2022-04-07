package com.ksenialexeev.inventoryServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InventoryApplication

fun main(args: Array<String>) {
	runApplication<InventoryApplication>(*args)
}
