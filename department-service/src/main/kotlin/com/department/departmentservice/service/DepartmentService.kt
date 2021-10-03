package com.department.departmentservice.service

import com.department.departmentservice.dto.DepartmentDto
import com.department.departmentservice.entity.Department
import com.department.departmentservice.repository.DepartmentRepository
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
internal class DepartmentService(
    private val departmentRepository: DepartmentRepository
) {

    fun saveDepartment(department: DepartmentDto): Long = departmentRepository.save(
        Department(
            name = department.name,
            address = department.address,
            code = department.code
        )
    ).id

    fun getDepartmentById(id: Long): DepartmentDto {
        val department = departmentRepository.findById(id).orElseThrow { EntityNotFoundException() }
        return DepartmentDto(
            name = department.name,
            address = department.address,
            code = department.code
        )
    }
}