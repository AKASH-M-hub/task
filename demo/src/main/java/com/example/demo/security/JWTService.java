/// generate the full working code for the JWTService class in the package com.example.demo.security with methods to generate and validate JWT tokens.
/// Make sure to use the appropriate libraries for JWT token generation and validation, such as io.jsonwebtoken.Jwts and io.jsonwebtoken.SignatureAlgorithm.
/// Make sure to also include methods to extract the username and any other relevant information from the token.
/// Make sure to also handle any exceptions that might occur during the token generation and validation process and return appropriate responses in case of errors.
/// Make sure to also include any necessary dependencies in the build file for the JWT library you choose to use.

package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JWTService {
    // Use a sufficiently long secret for HMAC algorithms in production store this securely
    private static final String SECRET_KEY = "changeitchangeitchangeitchangeitchangeitchangeitchangeitchangeit";
    private static final long EXPIRATION_TIME = 86400000; // 24 hours

    private Key signingKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(signingKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(signingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(signingKey()).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
