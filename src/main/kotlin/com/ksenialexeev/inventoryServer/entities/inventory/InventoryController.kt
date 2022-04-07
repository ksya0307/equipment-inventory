package com.ksenialexeev.inventoryServer.entities.inventory

import com.ksenialexeev.inventoryServer.utils.Constants
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/inventory")
class InventoryController(private val inventoryService: InventoryService) {

    @GetMapping
    fun getAllInventory(
        @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) pageNumber:Int,
        @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) pageSize:Int,
        @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) sortBy:String,
        @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) sortDir:String
    ):Page<Inventory>{
        return inventoryService.getAllInventory(pageNumber, pageSize, sortBy, sortDir)
    }

//    @RequestMapping(value = ["/inventory"], method = [RequestMethod.GET],
//        headers = ["Accept=application/json;charset=UTF-8"],
//        produces = ["application/json"])
//    @ResponseBody
//    fun inventory():List<Inventory>{
//        return inventoryService.all()
//    }
//
//    @RequestMapping(value = ["/inventoryById"], method = [RequestMethod.GET],
//        headers = ["Accept=application/json;charset=UTF-8"],
//        produces = ["application/json"])
//    @ResponseBody
//    fun inventoryById(@RequestParam(name = "id") id:Long):Inventory{
//        return inventoryService.inventoryById(id)
//    }

//    @RequestMapping(value = ["/addInventory"], method = [RequestMethod.POST],
//        headers = ["Accept=application/json;charset=UTF-8"],
//        produces = [MediaType.APPLICATION_JSON_VALUE])
//    @Throws(URISyntaxException::class)
//    fun addInventory(@RequestBody inventory: Inventory):ResponseEntity<Inventory> {
//        val createInventory:Inventory =  inventoryService.addInventory(inventory)
//        return if(createInventory.equals(null)){
//            ResponseEntity.notFound().build()
//        }else{
//            val uri: URI = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(createInventory.id)
//                .toUri()
//            ResponseEntity.created(uri).body(createInventory)
//        }
//    }
}