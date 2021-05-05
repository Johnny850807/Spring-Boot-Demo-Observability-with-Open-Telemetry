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
        UserPresenter presenter = new UserPresenter();
        signUp.execute(user, presenter);
        return presenter.getUser();
    }

    @PostMapping("/signIn")
    public User signIn(@RequestBody SignInRequest request) {
        log.info("SignIn: {}", request);
        UserPresenter presenter = new UserPresenter();
        signIn.execute(new SignIn.Request(request.email, request.password), presenter);
        return presenter.getUser();
    }
}
