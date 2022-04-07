package com.ksenialexeev.inventoryServer.entities.equipment

import com.ksenialexeev.inventoryServer.entities.category.Category
import com.fasterxml.jackson.annotation.JsonIgnore
import com.ksenialexeev.inventoryServer.entities.BaseEntity
import com.ksenialexeev.inventoryServer.entities.classroom_equipment.ClassroomEquipment
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
@Table(name = "equipment")
class Equipment (_id:Long,
                 _about:String,
                 _category: Category,
                 _equipment:List<ClassroomEquipment>, _name: String
): BaseEntity(_id, _name) {

    @Column(name = "about")
    val about: String?

    @JoinColumn(name = "category") @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    val category: Category?

    @JsonIgnore @OneToMany(orphanRemoval = true, mappedBy = "equipment", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val equipment: List<ClassroomEquipment>?

    init {
        about = _about
        category = _category
        equipment = _equipment
    }
}