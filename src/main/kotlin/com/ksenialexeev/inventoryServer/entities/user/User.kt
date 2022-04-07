package com.ksenialexeev.inventoryServer.entities.user

import com.fasterxml.jackson.annotation.JsonIgnore
import com.ksenialexeev.inventoryServer.entities.BaseEntity
import com.ksenialexeev.inventoryServer.entities.classroom.Classroom
import com.ksenialexeev.inventoryServer.entities.inventory.Inventory
import com.ksenialexeev.inventoryServer.entities.role.Role
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.OneToMany
import javax.persistence.FetchType
import javax.persistence.CascadeType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany


@Entity
@Table(name = "users")
class User (_id:Long, _surname:String,
            _name:String, _patronym:String,
            _username:String, _roles:Set<Role>,
            _password:String, _classrooms:List<Classroom>,
            _responsiblePerson:List<Inventory>): BaseEntity(_id, _name) {

    @Column(name = "surname")
    private var surname: String?

    @Column(name = "patronym")
    var patronym: String?

    @Column(name = "username")
    var username: String?

    @Column(name = "password")
    var password: String?

    @JsonIgnore @OneToMany(mappedBy = "users", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var classrooms: List<Classroom>?

    @JsonIgnore @OneToMany(mappedBy = "responsiblePerson", orphanRemoval = true, fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var responsiblePerson: List<Inventory>?

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "users_roles", joinColumns = [JoinColumn(name = "user_id")], inverseJoinColumns = [JoinColumn(name = "role_id")])
    var roles:Set<Role>? = HashSet()
    //Set для лучшей производительности, он сразу добавляет/удаляет то что нужно, без перезаписи, переудаления
    //при List Hibernate сначала удалит существующие потом добавит их снова и новые
    //в List данные могут повторятся, в Set уникальны

    init {
        this.surname = _surname
        this.patronym = _patronym
        this.username = _username
        this.password = _password
        this.roles = _roles
        this.classrooms = _classrooms
        this.responsiblePerson = _responsiblePerson
    }

}