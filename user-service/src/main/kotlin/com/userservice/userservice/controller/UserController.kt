package com.userservice.userservice.controller

import com.userservice.userservice.dto.UserDto
import com.userservice.userservice.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
internal class UserController(
    private val userService: UserService
) {

    @PostMapping("/")
    fun saveUser(@RequestBody user: UserDto) = userService.save(user)


    @GetMapping("/{id}")
    fun getUserWithDepartment(@PathVariable id: Long) = userService.getUserById(id)
}