package com.ksenialexeev.inventoryServer.entities.equipment_belonging

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EquipmentBelongingRepository : JpaRepository<EquipmentBelonging, Long>