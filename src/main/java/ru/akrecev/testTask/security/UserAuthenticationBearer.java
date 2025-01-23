package ru.akrecev.testTask.security;

import io.jsonwebtoken.Claims;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserAuthenticationBearer {
    public static Authentication create(JwtHandler.VerificationResult verificationResult) {
        Claims claims = verificationResult.claims;
        String subject = claims.getSubject();
        String role = claims.get("role", String.class);
        String principalName = claims.get("username", String.class);
        List<GrantedAuthority> grantedAuthorities = List.of(new SimpleGrantedAuthority(role));
        Long principalId = Long.parseLong(subject);

        CustomPrincipal principal = new CustomPrincipal(principalId, principalName);

        return new UsernamePasswordAuthenticationToken(principal, null, grantedAuthorities);
    }
}
