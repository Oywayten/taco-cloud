package vitaliy.grab.doners.model;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

/**
 * Oywayten 01.01.2024.
 */

@Data
@UserDefinedType("doner")
public class DonerUDT {

    private final String name;

    private final List<IngredientUDT> ingredients;
}
