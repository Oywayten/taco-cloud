package vitaliy.grab.doners.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * Oywayten 06.11.2023.
 */
@Data
public class Delivery {

    @NotBlank(message = "Delivery name is required")
    private String name;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip code is required")
    private String zip;
}
