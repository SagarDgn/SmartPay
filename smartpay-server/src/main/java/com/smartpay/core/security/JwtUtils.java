package com.smartpay.core.security;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtils {

    //private constructor, yo class to object banauna naparos to access methods
    private JwtUtils(){}

    //HMAC-SHA256 algorithm, symmetric key
    public static final MacAlgorithm ALGORITHM= Jwts.SIG.HS256;

    //when app restarts every time the secret changes and token expires
    public static final SecretKey SECRET_KEY= ALGORITHM.key().build();

    //token expiration time =1 hours
    public static final long EXPIRATION= 1000*60*60;

    public static String generateToken(String email, String role){
        return Jwts.builder()
                .subject(email)//who the token belongs to
                .claim("role", role)//custom claim
                .issuedAt(new Date())//issue date
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .signWith(SECRET_KEY)//signing with secret key
                .compact();//converts token to string
    }

    public static String extractEmail(String token, String email){
        return Jwts.parser()//verify token, decode, extract claims
                .verifyWith(SECRET_KEY)//verify signature
                .build()//finalize parser,parser is ready to use
                .parseSignedClaims(token)
                .getPayload()//email, issueAt, expireAt
                .getSubject();//get email
    }

   public static boolean isTokenExpired(String token){
        try{
            Date date= Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getExpiration();
            return date.before(new Date());
        }catch (JwtException e){
            return true;
        }
    }

    public static boolean validateToken(String token ,String email){
        try{
            String extractedEmail= extractEmail(token,email);
            return extractedEmail.equals(email) && !isTokenExpired(token);
        }catch(JwtException e){
            return false;
        }
    }
    public static String getRoleFromToken(String token){
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("role", String.class);
    }
}
