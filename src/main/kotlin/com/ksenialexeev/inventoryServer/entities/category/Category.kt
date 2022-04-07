package com.ksenialexeev.inventoryServer.entities.category


import com.fasterxml.jackson.annotation.JsonIgnore
import com.ksenialexeev.inventoryServer.entities.BaseEntity
import com.ksenialexeev.inventoryServer.entities.equipment.Equipment
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType

@Entity
@Table(name = "category")
class Category(_id:Long,
               _name:String,
               _equipment:List<Equipment>): BaseEntity(_id,_name) {

    //Lazy -
    //Eager - выполняет запросы к бд даже когда не используются эти сущности, производительность страдает
    @JsonIgnore @OneToMany(orphanRemoval = true, mappedBy = "category", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val equipment: List<Equipment>?

    init {
        name = _name
        equipment = _equipment
    }
}