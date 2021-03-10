package com.example.demo;

import io.opentelemetry.extension.annotations.WithSpan;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Component
@AllArgsConstructor
public class SignUp {
    private final UserRepository userRepository;

    @WithSpan
    public User execute(User user) {
        return userRepository.save(user);
    }
}
