package com.ksenialexeev.inventoryServer.entities.role

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ksenialexeev.inventoryServer.entities.BaseEntity
import com.ksenialexeev.inventoryServer.entities.user.User
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "roles")
class Role(_id:Long, _name:String, _users:Set<User>): BaseEntity(_id,_name) {

    @JsonIgnore @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    var users: Set<User> = HashSet()

    init {
        users = _users
    }
}