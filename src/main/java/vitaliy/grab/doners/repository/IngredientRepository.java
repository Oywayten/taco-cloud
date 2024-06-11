package vitaliy.grab.doners.repository;

import org.springframework.data.repository.CrudRepository;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.model.IngredientId;

/**
 * Oywayten 12.11.2023.
 */

public interface IngredientRepository extends CrudRepository<Ingredient, IngredientId> {
}
