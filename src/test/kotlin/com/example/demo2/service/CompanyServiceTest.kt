package com.example.demo2.service

import com.example.demo2.model.JwtToken
import com.example.demo2.model.Movie
import com.example.demo2.repository.DomainRepository
import com.example.demo2.repository.MovieRepository
import com.example.demo2.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.Duration
import java.time.Instant

//@RunWith(SpringRunner.class)
@SpringBootTest
class CompanyServiceTest {

    @Autowired
    private lateinit var domainRepository: DomainRepository

    @Autowired
    private lateinit var movieRepository: MovieRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var jwtService: JwtService


    @Test
    fun getDomains() {
        val domains = domainRepository.findAll()
        println("test runs $domains")

        val movies = movieRepository.findAll()
        println("test runs $movies")

        val newMovie = Movie(id = "some random string", name = "created from test")
        movieRepository.save(newMovie)

        val newmovies = movieRepository.findAll()
        println("test runs $newmovies")

    }

    @Test
    fun testRegistration() {
        val users = userRepository.findAll()
        println("all users are $users")

//        val saved = userService.signUpUser(RegisterRequest(name = "riyanka",email = "abc@example.com",
//                password = "somepassword",matchingPassword = "somepassword"))

        userService.getAllUsers().map {
            println(it)
        }

        val res1 = userService.verifyUser(email = "abc@example.com", inputPassword = "somepassword")
        Assertions.assertEquals(true, res1)
        val res2 = userService.verifyUser(email = "abc@example.com", inputPassword = "ajhjhjsk")
        Assertions.assertEquals(false, res2)

    }

//    @Test
//    fun testJwtService(){
//        val token = JwtToken(issuedAt = Instant.now(),
//                expireAt = Instant.now().plus(Duration.ofHours(1)),
//                type = "access")
//        val encodedToken = jwtService.encode(token)
//        println("encoded token is $encodedToken")
//
//    }

    @Test
    fun testJWT() {
        val token = jwtService.generateJwtToken()
        assertTrue(token != null)
        println(token)
        jwtService.printStructure(token)
        jwtService.printBody(token)


    }
}