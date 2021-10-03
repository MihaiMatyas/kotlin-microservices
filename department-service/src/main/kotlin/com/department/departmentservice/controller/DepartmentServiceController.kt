package com.department.departmentservice.controller

import com.department.departmentservice.dto.DepartmentDto
import com.department.departmentservice.service.DepartmentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/department")
internal class DepartmentServiceController(
    private val departmentService: DepartmentService
) {
    @PostMapping("/")
    fun saveDepartment(@RequestBody department: DepartmentDto) = departmentService.saveDepartment(department)

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Long): DepartmentDto = departmentService.getDepartmentById(id)
}