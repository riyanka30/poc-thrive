package com.example.demo2.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys.secretKeyFor
import org.springframework.stereotype.Component
import java.util.*


@Component
class JwtService{
    // -------------------------JWT implementation without keys-------------

    companion object{
//        val signingKey = "MTIzNDU2Nzg="
        val signingKey = secretKeyFor(SignatureAlgorithm.HS512)
    }
    fun generateJwtToken(): String {
        // year    the year minus 1900.
        // month   the month between 0-11.
        // date    the day of the month between 1-31.
        val token = Jwts.builder().setSubject("adam")
                .setExpiration(Date(2020-1900, 12-1, 1))
                .setIssuer("info@wstutorial.com")
                .claim("groups", arrayOf<String>("user", "admin"))
                // HMAC using SHA-512  and 12345678 base64 encoded
                .signWith(SignatureAlgorithm.HS512, signingKey).compact()
        return token
    }

    fun printStructure(token: String) {
        val parseClaimsJws = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token)
        println("Header     : " + parseClaimsJws.header)
        println("Body       : " + parseClaimsJws.body)
        println("Signature  : " + parseClaimsJws.signature)
    }

    fun printBody(token: String) {
        val body = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).body
        println("Issuer     : " + body.issuer)
        println("Subject    : " + body.subject)
        println("Expiration : " + body.expiration)
    }
}
