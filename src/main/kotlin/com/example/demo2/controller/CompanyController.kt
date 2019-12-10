package com.example.demo2.controller

import com.example.demo2.model.Company
import com.example.demo2.service.CompanyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/companies"])
class CompanyController(val companyService: CompanyService) {

    @GetMapping
    fun getCompanyByUsername(@RequestParam username:String): Company {
        return companyService.getCompanyByUserName(username)
    }
}