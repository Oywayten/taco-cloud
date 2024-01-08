package vitaliy.grab.doners.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.service.IngredientService;

/**
 * Oywayten 08.11.2023.
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientService ingredientService;

    public IngredientByIdConverter(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @Override
    public Ingredient convert(@NonNull String id) {
        return ingredientService.findById(id).orElse(null);
    }
}
