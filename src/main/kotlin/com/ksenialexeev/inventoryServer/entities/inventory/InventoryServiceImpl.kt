package com.ksenialexeev.inventoryServer.entities.inventory

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service @RequiredArgsConstructor @Transactional @Slf4j
class InventoryServiceImpl(private val inventoryRepository: InventoryRepository): InventoryService {
    override fun getAllInventory(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<Inventory> {
        val sort: Sort = if(sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        val pageable: Pageable = PageRequest.of(pageNumber,pageSize,sort)
        return inventoryRepository.findAll(pageable)
    }

//    override fun getById(id: Long): Inventory {
//
//    }
//
//    override fun saveInventory(inventory: Inventory) {
//
//    }
}