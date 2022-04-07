package com.ksenialexeev.inventoryServer.entities.category

import org.springframework.data.domain.Page

interface CategoryService {
    fun getAllCategories(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<Category>
//    fun getById(id:Long): Category
//    fun getCategory(name:String): Category
//    fun saveCategory(category: Category)
}