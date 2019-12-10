package com.example.demo2.repository

import com.example.demo2.model.Domain
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface DomainRepository : MongoRepository<Domain, Long> {

    fun findFirstByDomain(domain: String): Domain

    fun findByDomainAndDisplayAds(domain: String, displayAds: Boolean): Domain

    //Supports native JSON query string
    @Query("{domain:'?0'}")
    fun findCustomByDomain(domain: String): Domain

    @Query("{domain: { \$regex: ?0 } })")
    fun findCustomByRegExDomain(domain: String): List<Domain>
}