package com.example.demo2.repository

import com.example.demo2.model.Movie
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface MovieRepository : MongoRepository<Movie, String>