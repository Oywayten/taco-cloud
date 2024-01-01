package vitaliy.grab.doners.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

/**
 * Oywayten 01.01.2024.
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@UserDefinedType("ingredient")
public class IngredientUDT {

    private final String name;

    private final Ingredient.Type type;
}
