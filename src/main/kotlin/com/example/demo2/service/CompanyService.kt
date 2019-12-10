package com.example.demo2.service

import com.example.demo2.model.Company
import com.example.demo2.repository.DomainRepository
import org.springframework.stereotype.Service

@Service
class CompanyService(val domainRepository: DomainRepository) {

    fun getCompanyByUserName(username: String): Company {
        return Company(name = "company abc", countOfEmployees = 20)
    }

    fun getDomains() {
        val domains = domainRepository.findAll()
    }
}