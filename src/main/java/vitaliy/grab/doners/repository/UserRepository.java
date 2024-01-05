package vitaliy.grab.doners.repository;

import org.springframework.data.repository.CrudRepository;
import vitaliy.grab.doners.model.User;

/**
 * Oywayten 05.01.2024.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String name);
}
