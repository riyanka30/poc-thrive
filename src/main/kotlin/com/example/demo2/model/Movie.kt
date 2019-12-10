package com.example.demo2.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "movie")
data class Movie(
        @Id
        val id: String,
        val name: String
)