package ru.akrecev.testTask.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.akrecev.testTask.exception.AuthException;
import ru.akrecev.testTask.model.User;
import ru.akrecev.testTask.service.UserService;

@Component
@RequiredArgsConstructor
public class SecurityService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Integer expirationInSeconds;

    @Value("${jwt.issuer}")
    private String issuer;

    public TokenDetails authenticate(String username, String password) {
        User user = userService.getByName(username);
        if (user == null) {
            throw new AuthException("Invalid username", "ADMIN_INVALID_USERNAME");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthException("Invalid password", "ADMIN_INVALID_PASSWORD");
        }

        return generateToken(user).toBuilder().userId(user.getId()).build();
    }

    private TokenDetails generateToken(User user) {
        Map<String, Object> claims = new HashMap<>() {
            {
                put("role", user.getRole());
                put("username", user.getName());
            }
        };

        return generateToken(claims, user.getId().toString());
    }

    private TokenDetails generateToken(Map<String, Object> claims, String subject) {
        long expirationTimeInMillis = expirationInSeconds * 1000L;
        Date expirationDate = new Date(new Date().getTime() + expirationTimeInMillis);

        return generateToken(expirationDate, claims, subject);
    }

    private TokenDetails generateToken(Date expirationDate, Map<String, Object> claims, String subject) {
        Date createdDate = new Date();
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuer(issuer)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setId(UUID.randomUUID().toString())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.ES256, Base64.getEncoder().encodeToString(secret.getBytes()))
                .compact();

        return TokenDetails.builder()
                .token(token)
                .issuedAt(createdDate)
                .expiresAt(expirationDate)
                .build();
    }
}
