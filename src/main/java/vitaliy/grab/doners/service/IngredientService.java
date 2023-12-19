package vitaliy.grab.doners.service;

import vitaliy.grab.doners.model.Ingredient;

import java.util.Optional;

/**
 * Oywayten 12.11.2023.
 */

public interface IngredientService {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
