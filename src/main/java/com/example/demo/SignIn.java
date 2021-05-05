package com.example.demo;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.extension.annotations.WithSpan;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Slf4j
@Component
@AllArgsConstructor
public class SignIn {
    private final UserRepository userRepository;

    public void execute(Request request, Presenter presenter) {
        User user = userRepository.findFirstByEmailAndPassword(request.email, request.password)
                .orElseThrow();
        presenter.present(user);
    }

    @Value
    public static class Request {
        public String email, password;
    }

    public interface Presenter {
        void present(User user);
    }
}
