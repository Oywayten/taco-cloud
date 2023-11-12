package vitaliy.grab.doners.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

/**
 * Oywayten 06.11.2023.
 */
@Data
public class CreditCard {

    @CreditCardNumber(message = "Not a valid credit card number")
    private String number;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String expiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String cvv;
}
