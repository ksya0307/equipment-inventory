package com.ksenialexeev.inventoryServer.entities.category

import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service @RequiredArgsConstructor @Transactional @Slf4j
class CategoryServiceImpl(private val categoryRepository: CategoryRepository):
    CategoryService {
    override fun getAllCategories(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<Category> {
        val sort:Sort = if(sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        val pageable: Pageable = PageRequest.of(pageNumber,pageSize,sort)
        return categoryRepository.findAll(pageable)
    }

//    override fun getById(id: Long): Category {
//
//    }
//
//    override fun getCategory(name: String): Category {
//
//    }
//
//    override fun saveCategory(category: Category) {
//
//    }
}