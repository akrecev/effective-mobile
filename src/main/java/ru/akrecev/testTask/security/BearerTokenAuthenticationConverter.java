package ru.akrecev.testTask.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;

@RequiredArgsConstructor
public class BearerTokenAuthenticationConverter implements AuthenticationConverter {
    private final JwtHandler jwtHandler;
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public Authentication convert(HttpServletRequest request) {
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        String accessToken = authorization.replace(BEARER_PREFIX, "");
        return UserAuthenticationBearer.create(jwtHandler.check(accessToken));
    }
}
