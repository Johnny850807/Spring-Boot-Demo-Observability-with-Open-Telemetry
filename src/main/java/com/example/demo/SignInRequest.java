package com.example.demo;

import lombok.Value;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Value
public class SignInRequest {
    public String email, password;

    @Override
    public String toString() {
        return "SignInRequest{" +
                "email='" + email + '\'' +
                ", password='********'}";
    }
}
