package vitaliy.grab.doners.service;

import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.repository.IngredientRepository;

import java.util.Optional;

/**
 * Oywayten 12.11.2023.
 */
@Service
public class JdbcIngredientService implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public JdbcIngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }
}
