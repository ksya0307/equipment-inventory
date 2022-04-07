package com.ksenialexeev.inventoryServer.entities.user

import com.ksenialexeev.inventoryServer.dto.UserDto
import com.ksenialexeev.inventoryServer.entities.role.RolesRepository
import com.ksenialexeev.inventoryServer.entities.user.exceptions.UserNotFoundException
import com.ksenialexeev.inventoryServer.mappers.UserDtoMapper
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

//RequiredArgsConstructor - создаст конструктор и потом проверяет, чтобы все эти аргументы были переданы в этот конструктор
//Transactional -
@Service @RequiredArgsConstructor @Transactional @Slf4j
class UserServiceImpl(private val userRepository: UserRepository, private val rolesRepository: RolesRepository) : UserService {

    @Autowired
    lateinit var userDtoMapper: UserDtoMapper

    override fun getAllUsers(pageNumber: Int, pageSize:Int, sortBy:String,sortDir:String): Page<UserDto> {
        val sort: Sort = if (sortDir.equals(Sort.Direction.ASC.name, ignoreCase = true)) Sort.by(sortBy).ascending() else Sort.by(sortBy).descending()
        val pageableRequest: PageRequest = PageRequest.of(pageNumber, pageSize, sort)//объект для указания размера страницы, номера страницы и сортировка
        val users:List<UserDto> = userDtoMapper.userDtoList(userRepository.findAll(pageableRequest))//сощлаем список наших юзеров с полями DTo
//        val user_input:List<User> = userRepository.getAllUsers(pageableRequest)
//        val users:List<UserDto> = userDtoMapper.userToUserDto(user_input)
        println("$users users")
        val total:Int = users.size //определеяем размер
        val start: Int = pageableRequest.offset.toInt()//для получения старта страницы, с какого номер будет начинается
        println("$start получили оффсет")
        val end: Int = (start + pageableRequest.pageSize).coerceAtMost(total)// максимальное количество записей
        println("$end получаем end")
        var output:List<UserDto> = userDtoMapper.userDtoList(userRepository.findAll(pageableRequest))
        println("$output output")
//        val user_output:List<User> =  userRepository.getAllUsers(pageableRequest)
//        var output:List<UserDto> = userDtoMapper.userToUserDto(user_output)
        if(start<=end) output = users.subList(start,end)
        return PageImpl(output, pageableRequest, total.toLong())

    }

    override fun getById(id: Long): User {
        return userRepository.findById(id).orElseThrow {
            UserNotFoundException("User not found")
        }
    }
    override fun getUser(username: String): User {
       return userRepository.findByUsername(username)
    }
    override fun saveUser(user: User) {
      userRepository.save(user)
    }

//    override fun addRoleToUser(used_id: Long, role_id: Long) {
//
//    }

//    override fun users(): List<UserDto> {
//     return userDtoMapper.userToUserDto(userRepository.findAll())
//    }
}