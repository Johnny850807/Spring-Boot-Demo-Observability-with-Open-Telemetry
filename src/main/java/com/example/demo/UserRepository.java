package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Waterball (johnny850807@gmail.com)
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findFirstByEmailAndPassword(String email, String password);
}
