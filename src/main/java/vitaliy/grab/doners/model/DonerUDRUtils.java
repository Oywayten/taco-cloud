package vitaliy.grab.doners.model;

/**
 * Oywayten 01.01.2024.
 */

public class DonerUDRUtils {

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

    public static DonerUDT toDonerUDT(Doner doner) {
        return new DonerUDT(doner.getName(), doner.getIngredients());
    }
}
