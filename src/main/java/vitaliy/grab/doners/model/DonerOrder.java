package vitaliy.grab.doners.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Oywayten 06.11.2023.
 */
@Data
@Table("orders")
public class DonerOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();

    private Date placedAt = new Date();

    @NotBlank(message = "Delivery name is required")
    @Size(max = 50, message = "Name must be no more than 50 characters")
    public String deliveryName;

    @NotBlank(message = "Street is required")
    @Size(max = 50, message = "Street must be no more than 50 characters")
    private String deliveryStreet;

    @NotBlank(message = "City is requirecitd")
    @Size(max = 50, message = "City must be no more than 50 characters")
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Size(min = 2, max = 2, message = "State must be 2 characters")
    private String deliveryState;

    @NotBlank(message = "Zip code is required")
    @Size(min = 2, max = 2, message = "Zip code must be 2 characters.")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([/])([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    @Column("doners")
    private final List<DonerUDT> doners = new ArrayList<>();

    public void addDoner(DonerUDT doner) {
        doners.add(doner);
    }
}
