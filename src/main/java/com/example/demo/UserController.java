package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final SignIn signIn;
    private final SignUp signUp;

    @PostMapping("/signUp")
    public User signUp(@RequestBody User user) {
        log.info("SignUp: {}", user);
        return signUp.execute(user);
    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody SignInRequest request) {
        log.info("SignIn: {}", request);
        return signIn.execute(request.email, request.password);
    }
}
