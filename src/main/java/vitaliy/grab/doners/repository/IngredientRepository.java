package vitaliy.grab.doners.repository;

import vitaliy.grab.doners.model.Ingredient;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 12.11.2023.
 */

public interface IngredientRepository {

    List<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
