package com.example.sneakpeak.Utils;

import com.example.sneakpeak.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    private static final Logger log = LoggerFactory.getLogger(JWTUtils.class);
    private static String secret ="This_is_secret";
    private static long expirationDuration=30 * 24 * 60 * 60;

    public String generateJWT(User user){
        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime+expirationDuration*1000;
        Date issuedAt = new Date(milliTime);
        Date expiryAt = new Date(expiryTime);

        //Claims created
        Claims claims = Jwts.claims().setIssuer(user.getId().toString()).setIssuedAt(issuedAt).setExpiration(expiryAt);
        claims.put("emailId",user.getEmailId());
        claims.put("fullName",user.getName());

        //jwt generate using claims
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512 , secret).compact();
    }
}
