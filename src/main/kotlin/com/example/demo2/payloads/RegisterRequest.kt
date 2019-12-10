package com.example.demo2.payloads

data class RegisterRequest (
        val name:String,
        val email:String,
        val password:String,
        val matchingPassword:String
)