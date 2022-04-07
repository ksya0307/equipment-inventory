package com.ksenialexeev.inventoryServer.entities.classroom_equipment

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ksenialexeev.inventoryServer.entities.classroom.Classroom
import com.ksenialexeev.inventoryServer.entities.equipment.Equipment
import com.ksenialexeev.inventoryServer.entities.inventory.Inventory
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne


@Entity
@Table(name = "classrooms_equipment")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "inventory_number")
class ClassroomEquipment(_inventorynumber:Long,
                          _numberInClassroom:String,
                          _classroom: Classroom,
                          _equipment: Equipment,
                          _inventoryNumber:List<Inventory>){

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "inventory_number")
    val id: Long?

    @Column(name = "number_in_classroom")
    val numberInClassroom:String?

    @JoinColumn(name = "classroom") @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    val classroom: Classroom?

    @JoinColumn(name = "equipment") @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = [CascadeType.ALL])
    val equipment: Equipment?

    @JsonIgnore @OneToMany(mappedBy = "inventoryNumber", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val inventoryNumber: List<Inventory>?

    init {
        id = _inventorynumber
        numberInClassroom = _numberInClassroom
        classroom = _classroom
        equipment = _equipment
        inventoryNumber = _inventoryNumber
    }
}