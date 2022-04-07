package com.ksenialexeev.inventoryServer.entities.equipment_belonging

import com.ksenialexeev.inventoryServer.utils.Constants
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/equipment-belonging")
class EquipmentBelongingController(private val equipmentBelongingService: EquipmentBelongingService) {

    @GetMapping
    fun getAllEquipmentBelonging(
        @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) pageNumber:Int,
        @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) pageSize:Int,
        @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) sortBy:String,
        @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) sortDir:String
    ): Page<EquipmentBelonging>{
        return equipmentBelongingService.getAllEquipmentBelonging(pageNumber, pageSize, sortBy, sortDir)
    }
}