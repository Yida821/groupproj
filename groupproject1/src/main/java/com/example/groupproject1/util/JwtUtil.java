package com.example.groupproject1.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {
    // token payload which contains user

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;
    public static final String APPSECRET_KEY = "piconjo_secret";

//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, userDetails.getUsername());
//    }

    public static String createToken(String username, String role) {
        Map<String, Object> map =  new HashMap<>();
        map.put("role", role);
        String token = Jwts
                .builder()
                .setSubject(username)
                .setClaims(map) //<string, object>
                .claim("username",username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
        return token;

    }

    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getUsername(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("username").toString();
    }


    public static String getUserRole(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("role").toString();
    }

    public static boolean isExpiration(String token){
        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }


// from Yang
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        final String username = extractUsername(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
}
