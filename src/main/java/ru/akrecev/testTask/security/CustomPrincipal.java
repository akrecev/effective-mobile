package ru.akrecev.testTask.security;

import java.security.Principal;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CustomPrincipal implements Principal {
    private Long id;
    private String name;
}
