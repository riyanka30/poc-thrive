package com.example.demo2.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "domain")
data class Domain(
        @Id
        val id: Long,

        @Indexed(unique = true)
        val domain: String,

        val displayAds: Boolean
)