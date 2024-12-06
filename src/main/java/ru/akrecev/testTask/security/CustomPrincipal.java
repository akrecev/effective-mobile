package ru.akrecev.testTask.security;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.security.Principal;

@RequiredArgsConstructor
@Builder(toBuilder = true)
@Getter
@ToString
public class CustomPrincipal implements Principal {
    private final Long id;
    private final String name;
}
