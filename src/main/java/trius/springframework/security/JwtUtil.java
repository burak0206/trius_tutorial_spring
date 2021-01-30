package trius.springframework.security;


import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {

   @Autowired
   private JwtConfig jwtConfig;

    public String generateJwtForUser(String email)  {
        Instant issuedAt = Instant.now();
        Instant expiration = issuedAt.plus(jwtConfig.expireDuration());

        return Jwts
                .builder()
                .setSubject(email)
                .setIssuedAt(new Date(issuedAt.toEpochMilli()))
                .setExpiration(new Date(expiration.toEpochMilli()))
                .claim("email", email)
                .signWith(jwtConfig.getJwtKey())
                .compact();
    }
}
