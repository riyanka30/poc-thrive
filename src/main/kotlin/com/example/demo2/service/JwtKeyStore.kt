//package com.example.demo2.service
//
//import org.bouncycastle.jce.provider.BouncyCastleProvider
//import org.bouncycastle.util.io.pem.PemReader
//import org.springframework.stereotype.Component
//import java.nio.file.Files
//import java.nio.file.Paths
//import java.security.Key
//import java.security.KeyFactory
//import java.security.Security
//import java.security.spec.PKCS8EncodedKeySpec
//import java.security.spec.X509EncodedKeySpec
//
//
//@Component
//class JwtKeyStore() {
//    final val privateKey: Key
//    final val publicKey: Key
//
//    companion object{
//        // this is the private key
////        val signingKeyPath = "/Users/riyanka/.ssh/id_ed25519"
//        val signingKeyPath = "/Users/riyanka/.ssh"
//        // this is the public key
////        val verifyingKeyPath = "/Users/riyanka/.ssh/id_ed25519.pub"
//        val verifyingKeyPath = "/Users/riyanka/.ssh"
//    }
//
//    init {
//        Security.addProvider(BouncyCastleProvider())
//
//        val rsaFactory = KeyFactory.getInstance("RSA")
//
//        val privateSpec = PKCS8EncodedKeySpec(
//            PemReader(Files.newBufferedReader(Paths.get(signingKeyPath))).readPemObject().content
//        )
//        val publicSpec = X509EncodedKeySpec(
//            PemReader(Files.newBufferedReader(Paths.get(verifyingKeyPath))).readPemObject().content
//        )
//
//        privateKey = rsaFactory.generatePrivate(privateSpec)
//        publicKey = rsaFactory.generatePublic(publicSpec)
//    }
//}
