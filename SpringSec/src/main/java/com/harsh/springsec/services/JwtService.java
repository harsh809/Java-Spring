package com.harsh.springsec.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;

@Service
public class JwtService {
    private String secretKey = "";

    public JwtService(){
        try{
            KeyGenerator keygen = KeyGenerator.getInstance("hmacSHA256");
            SecretKey secKey = keygen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(secKey.getEncoded());
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String generateToken(String username) {
        Map<String, Objects> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt( new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 *30))
                .and()
                .signWith(getKey())
                .compact();

    }
    public Key getKey(){
        byte[] kb = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(kb);
    }
}
