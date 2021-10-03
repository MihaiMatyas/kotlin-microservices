package com.userservice.userservice.service

import com.userservice.userservice.dto.DepartmentDto
import com.userservice.userservice.dto.ResponseTemplateVO
import com.userservice.userservice.dto.UserDto
import com.userservice.userservice.entity.User
import com.userservice.userservice.repository.UserRepository
import org.apache.coyote.Response
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import javax.persistence.EntityNotFoundException

@Service
internal class UserService(
    private val userRepository: UserRepository,
    private val restTemplate: RestTemplate
) {

    fun save(user: UserDto) = userRepository.save(
        User(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            departmentId = user.departmentId
        )
    ).id

    fun getUserById(id: Long): ResponseTemplateVO {
        val user = userRepository.findById(id).orElseThrow { EntityNotFoundException() }
        val department =
            restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/${user.departmentId}", DepartmentDto::class.java)
        return ResponseTemplateVO(
            user = UserDto(firstName = user.firstName, lastName = user.lastName, email = user.email, departmentId = user.departmentId),
            department = department
        )
    }
}