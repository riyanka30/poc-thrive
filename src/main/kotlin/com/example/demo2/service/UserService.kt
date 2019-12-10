package com.example.demo2.service

import com.example.demo2.model.User
import com.example.demo2.payloads.RegisterRequest
import com.example.demo2.repository.UserRepository
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository,
                  val passwordEncoder: PasswordEncoder) {

    companion object{
//        jwt.secret=javainuse
    }

    fun signUpUser(registerRequest: RegisterRequest): String {
        val encodedPwd = passwordEncoder.encode(registerRequest.password)
        val newUser = User(
                id = UUID.randomUUID().toString(),
                name = registerRequest.name,
                email = registerRequest.email,
                password = encodedPwd
        )
        val savedUser = userRepository.save(newUser)
        return savedUser.id
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }

    fun verifyUser(email: String, inputPassword: String):Boolean {
//        val encodedPassword = passwordEncoder.encode(inputPassword)
        val user = userRepository.findByEmail(email) ?: throw RuntimeException("no user found by this email")
        val result = passwordEncoder.matches(inputPassword, user.password)
        return if(result){
            println("valid password")
            true
        }else{
            println("Invalid password")
            false
        }
        // when the user is valid, generate a jwt token for it with some expiry
        // on each subsequent request, validate the jwt

    }

}