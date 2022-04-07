package com.ksenialexeev.inventoryServer.entities.equipment_belonging

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ksenialexeev.inventoryServer.entities.BaseEntity
import com.ksenialexeev.inventoryServer.entities.inventory.Inventory
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType

@Entity
@Table(name = "equipment_belonging")
class EquipmentBelonging(_id:Long,
                         _name:String,
                         _equipmentBelonging:List<Inventory>): BaseEntity(_id,_name) {


    @JsonIgnore @OneToMany(mappedBy = "equipmentBelonging", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val equipmentBelonging: List<Inventory>?

    init {
        equipmentBelonging = _equipmentBelonging
    }
}