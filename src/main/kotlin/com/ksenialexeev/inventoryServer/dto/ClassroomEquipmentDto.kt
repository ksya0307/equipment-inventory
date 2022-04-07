package com.ksenialexeev.inventoryServer.dto

//dto может быть такой же как Entity & может иметь свою структуру, мможет иметь разные имена и типы полей, разное количество полей
//можно иметь сколько угодно dto
data class ClassroomEquipmentDto(val inventoryNumber:Long, val numberInClassroom:String)