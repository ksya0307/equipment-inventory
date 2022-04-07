package com.ksenialexeev.inventoryServer.entities

import javax.persistence.*

@MappedSuperclass
//@JsonIdentityInfo(generator = ObjectIdGenerators.::class, property = "id")
open class BaseEntity(_id:Long, _name:String) {

    @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?
    @Column(name = "name")
    var name:String?
    init {
        id = _id
        name = _name
    }

}