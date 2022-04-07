package com.ksenialexeev.inventoryServer.entities.inventory

import org.springframework.data.domain.Page

interface  InventoryService {
    fun getAllInventory(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String):Page<Inventory>
//    fun getById(id:Long): Inventory
//    fun saveInventory(inventory: Inventory)

}