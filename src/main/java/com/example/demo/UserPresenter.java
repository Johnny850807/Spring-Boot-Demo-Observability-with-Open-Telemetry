package com.example.demo;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
public class UserPresenter implements SignIn.Presenter, SignUp.Presenter {
    private User user;
    @Override
    public void present(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
