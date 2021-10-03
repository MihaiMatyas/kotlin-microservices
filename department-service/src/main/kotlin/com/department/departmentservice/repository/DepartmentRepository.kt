package com.department.departmentservice.repository

import com.department.departmentservice.entity.Department
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository: JpaRepository<Department, Long> {
}