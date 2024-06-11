package vitaliy.grab.doners.converter;

import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.service.IngredientService;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Oywayten 08.11.2023.
 */
@Component
@AllArgsConstructor
public class IngredientByIdConverter implements Converter<Ingredient.Id, Ingredient> {

    private final IngredientService ingredientService;

    @Override
    public Ingredient convert(@NonNull Ingredient.Id id) {
        return ingredientService.findById(id).orElse(null);
    }

}
