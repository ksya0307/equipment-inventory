package com.ksenialexeev.inventoryServer.entities.classroom

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.ksenialexeev.inventoryServer.entities.classroom_equipment.ClassroomEquipment
import com.ksenialexeev.inventoryServer.entities.inventory.Inventory
import com.ksenialexeev.inventoryServer.entities.user.User
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




@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "classnumber")
@Entity
@Table(name = "classrooms")
class Classroom(_classnumber:String,
                _users: User,
                _classroom:List<ClassroomEquipment>,
                _forClassroom:List<Inventory>) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "classnumber")
    val classnumber: String?
    //По умолчанию   FetchType - Eager
    @JoinColumn(name = "user") @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val users: User?
    @JsonIgnore @OneToMany(mappedBy = "classroom", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val classroom: List<ClassroomEquipment>?
    @JsonIgnore @OneToMany(mappedBy = "forClassroom", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val forClassroom: List<Inventory>?

    init {
        classnumber = _classnumber
        classroom = _classroom
        users = _users
        forClassroom = _forClassroom
    }
}