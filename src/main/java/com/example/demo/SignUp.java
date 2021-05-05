package com.example.demo;

import static com.example.demo.SignUpBroker.QUEUE;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Component
@AllArgsConstructor
public class SignUp {
    private final UserRepository userRepository;
    private final AmqpTemplate amqpTemplate;

    public void execute(User user, Presenter presenter) {
        User result = userRepository.save(user);
        amqpTemplate.convertAndSend(QUEUE, "The user " + user.getEmail() + " has signed up.");
        presenter.present(result);
    }

    public interface Presenter {
        void present(User user);
    }
}
