package com.userservice.userservice.repository

import com.userservice.userservice.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
internal interface UserRepository: JpaRepository<User, Long> {
}