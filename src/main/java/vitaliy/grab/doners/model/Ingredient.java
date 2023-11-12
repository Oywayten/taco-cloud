package vitaliy.grab.doners.model;

import lombok.Data;

/**
 * Oywayten 06.11.2023.
 */

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
