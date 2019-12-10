package com.example.demo2.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
        @Id
        val id: String,
        val name: String,
        val email: String,
        val password: String
)