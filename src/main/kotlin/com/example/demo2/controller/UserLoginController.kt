package com.example.demo2.controller

import com.example.demo2.model.Company
import com.example.demo2.model.User
import com.example.demo2.service.CompanyService
import com.example.demo2.payloads.RegisterRequest
import com.example.demo2.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/users"])
class UserLoginController(val userService: UserService) {

    @PostMapping(value = ["/registration"])
    fun registerUser(@RequestParam registerRequest: RegisterRequest):String {
        return userService.signUpUser(registerRequest)
    }

    @GetMapping
    fun getRegisteredUsers() :List<User>{
        return userService.getAllUsers()
    }
}