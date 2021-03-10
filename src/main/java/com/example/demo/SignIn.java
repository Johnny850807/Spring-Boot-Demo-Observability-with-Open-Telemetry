package com.example.demo;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.extension.annotations.WithSpan;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Slf4j
@Component
@AllArgsConstructor
public class SignIn {
    private final UserRepository userRepository;
    public User execute(String email, String password) {
        return userRepository.findFirstByEmailAndPassword(email, password)
                .orElseThrow();
    }
}
