package com.example.demo2.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.Instant

//@JsonIgnoreProperties(value = ["issued_at", "expire_at"], ignoreUnknown = true)
data class JwtToken (
    val issuedAt: Instant,
    val expireAt: Instant,
    val type: String
)