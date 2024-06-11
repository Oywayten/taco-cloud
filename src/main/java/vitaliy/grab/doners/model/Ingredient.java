package vitaliy.grab.doners.model;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Oywayten 06.11.2023.
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Ingredient {

    @jakarta.persistence.Id
    private Ingredient.Id id;
    private String name;
    private Type type;

    @Getter
    @AllArgsConstructor
    public enum Id {
        FLTO("Flour Tortilla"),
        COTO("Corn Tortilla"),
        GRBF("Ground Beef"),
        CARN("Carnitas"),
        TMTO("Diced Tomatoes"),
        LETC("Lettuce"),
        CHED("Cheddar"),
        JACK("Monterrey Jack"),
        SLSA("Salsa"),
        SRCR("Sour Cream");

        private final String name;

    }

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }

}
