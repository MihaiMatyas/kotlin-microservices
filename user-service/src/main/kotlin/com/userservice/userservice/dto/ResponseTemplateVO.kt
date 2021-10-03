package com.userservice.userservice.dto

data class ResponseTemplateVO (
    val user: UserDto,
    val department: DepartmentDto?
)