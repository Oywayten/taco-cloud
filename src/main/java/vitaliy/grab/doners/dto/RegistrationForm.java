package vitaliy.grab.doners.dto;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import vitaliy.grab.doners.model.User;

/**
 * Oywayten 05.01.2024.
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;


    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username, passwordEncoder.encode(password), fullname, street, city, state, zip, phone);
    }
}
