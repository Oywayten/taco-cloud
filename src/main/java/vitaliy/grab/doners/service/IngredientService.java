package vitaliy.grab.doners.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.repository.IngredientRepository;

import java.util.Optional;

/**
 * Oywayten 12.11.2023.
 */
@Service
@AllArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Optional<Ingredient> findById(Ingredient.Id id) {
        return ingredientRepository.findById(id);
    }

    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }
}
