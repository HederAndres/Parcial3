package com.parcial.resuelto.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)  // Desactivar CSRF
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/api/**").permitAll()  // Permitir acceso a /api/**
                        .anyExchange().authenticated())  // Proteger otras rutas
                .build();
    }
}

