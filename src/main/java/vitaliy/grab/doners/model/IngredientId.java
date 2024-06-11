package vitaliy.grab.doners.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

    @Getter
    @AllArgsConstructor
    public enum IngredientId {
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
