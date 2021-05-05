package com.example.demo;

import static com.example.demo.SignUpHandler.QUEUE;

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
        user = userRepository.save(user);
        amqpTemplate.convertAndSend(QUEUE, user.getId());
        presenter.present(user);
    }

    public interface Presenter {
        void present(User user);
    }
}
