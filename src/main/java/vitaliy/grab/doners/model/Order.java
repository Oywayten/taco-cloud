package vitaliy.grab.doners.model;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Oywayten 06.11.2023.
 */
@Data
public class Order {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date placeAt;

    @Valid
    private final Delivery delivery = new Delivery();

    @Valid
    private final CreditCard creditCard = new CreditCard();
    private final List<Doner> doners = new ArrayList<>();

    public void addDoner(Doner doner) {
        doners.add(doner);
    }
}
