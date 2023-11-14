package vitaliy.grab.doners.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Oywayten 06.11.2023.
 */
@Data
public class Delivery {

    @NotBlank(message = "Delivery name is required")
    @Size(max = 50, message = "Name must be no more than 50 characters")
    private String name;

    @NotBlank(message = "Street is required")
    @Size(max = 50, message = "Street must be no more than 50 characters")
    private String street;

    @NotBlank(message = "City is requirecitd")
    @Size(max = 50, message = "City must be no more than 50 characters")
    private String city;

    @NotBlank(message = "State is required")
    @Size(min = 2, max = 2, message = "State must be 2 characters")
    private String state;

    @NotBlank(message = "Zip code is required")
    @Size(min = 2, max = 2, message = "Zip code must be 2 characters.")
    private String zip;
}
