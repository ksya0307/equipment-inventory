package com.ksenialexeev.inventoryServer.entities.user

import com.ksenialexeev.inventoryServer.dto.UserDto
import com.ksenialexeev.inventoryServer.utils.Constants
import lombok.RequiredArgsConstructor
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
class UserController(private val userService: UserService) {

    @GetMapping
//    @Timed(value = "users.time", description = "Time taken to return all users")
    fun getAllUsers(
        @RequestParam(value = "pageNumber", defaultValue = Constants.DEFAULT_PAGE_NUMBER, required = false) pageNumber:Int,
        @RequestParam(value = "pageSize", defaultValue = Constants.DEFAULT_PAGE_SIZE, required = false) pageSize:Int,
        @RequestParam(value = "sortBy", defaultValue = Constants.DEFAULT_SORT_BY, required = false) sortBy:String,
        @RequestParam(value = "sortDir", defaultValue = Constants.DEFAULT_SORT_DIRECTION, required = false) sortDir:String
    ): Page<UserDto> = userService.getAllUsers(pageNumber, pageSize, sortBy, sortDir)
//
//    @GetMapping
//    fun all():List<UserDto> = userService.users()



//    @GetMapping(value = ["/{id}"])
//    fun getById(@PathVariable id:Long): ResponseEntity<User> = ResponseEntity.ok().body(userService.getById(id))//200
//
//    @PostMapping(value = ["/save"])
//    fun saveUser(@RequestBody user: User):ResponseEntity<User>{
//        val uri: URI = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users/save").toUriString())
//        userService.saveUser(user)
//        return ResponseEntity.created(uri).body(user)//201
//    }



//    @GetMapping(value = ["usernames/{username}"])
//    fun getByUsername(@PathVariable username:String): ResponseEntity<Users> {
//        val user:Users = userService.getUser(username)
//        if(user.equals(null)){
//            return ResponseEntity(HttpStatus.NOT_FOUND)
//        }
//        return ResponseEntity<Users>(user, HttpStatus.OK)
//    }
//

}
