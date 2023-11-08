package vitaliy.grab.tacos.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Oywayten 06.11.2023.
 */
@Data
public class Order {

    private final Delivery delivery = new Delivery();
    private final CreditCard creditCard = new CreditCard();
    private final List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
