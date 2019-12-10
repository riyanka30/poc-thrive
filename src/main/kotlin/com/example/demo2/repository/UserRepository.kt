package com.example.demo2.repository

import com.example.demo2.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {

    fun findByEmail(inputEmail: String): User?
}