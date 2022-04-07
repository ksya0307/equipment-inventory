package com.ksenialexeev.inventoryServer.entities.inventory

import com.ksenialexeev.inventoryServer.entities.BaseEntity
import com.ksenialexeev.inventoryServer.entities.classroom.Classroom
import com.ksenialexeev.inventoryServer.entities.classroom_equipment.ClassroomEquipment
import com.ksenialexeev.inventoryServer.entities.equipment_belonging.EquipmentBelonging
import com.ksenialexeev.inventoryServer.entities.user.User
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.FetchType
import javax.persistence.CascadeType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne




@Entity
@Table(name = "inventory")
 class Inventory(_id:Long,
                 _inventoryNumber: ClassroomEquipment,
                 _getDate:LocalDate,
                 _equipmentBelonging: EquipmentBelonging,
                 _given:String,
                 _document:String,
                 _ifo:String,
                 _forClassroom: Classroom,
                 _comment:String,
                 _responsiblePerson: User,
                 _name:String,
                 _commentchernega:String):
    BaseEntity(_id,_name) {

    @JoinColumn(name = "inventory_number") @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    val inventoryNumber: ClassroomEquipment?

    @Column(name = "get_date")
    val getDate: LocalDate?

    @JoinColumn(name = "equipment_belonging") @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    val equipmentBelonging: EquipmentBelonging?

    @Column(name = "given")
    val given: String?

    @Column(name = "document")
    val document: String?

    @Column(name = "ifo", nullable = false)
    val ifo: String?

    @JoinColumn(name = "for_classroom") @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    val forClassroom: Classroom?

    @JoinColumn(name = "responsible_person") @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.ALL])
    val responsiblePerson: User?

    @Column(name = "comment", nullable = true)
    val comment: String?

    @Column(name = "comment_chernega", nullable = true)
    val commentchernega: String?

    init {
      inventoryNumber = _inventoryNumber
      getDate = _getDate
      equipmentBelonging = _equipmentBelonging
      given = _given
      document = _document
      ifo = _ifo
      forClassroom = _forClassroom
      responsiblePerson = _responsiblePerson
      comment = _comment
      commentchernega = _commentchernega
    }
}