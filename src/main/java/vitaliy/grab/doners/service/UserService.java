package vitaliy.grab.doners.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.repository.UserRepository;

/**
 * Oywayten 08.01.2024.
 */

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
