package vitaliy.grab.doners.service;

import org.springframework.stereotype.Service;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.repository.JdbcIngredientRepository;

import java.util.List;
import java.util.Optional;

/**
 * Oywayten 12.11.2023.
 */
@Service
public class JdbcIngredientService implements IngredientService {

    private final JdbcIngredientRepository jdbcIngredientRepository;

    public JdbcIngredientService(JdbcIngredientRepository jdbcIngredientRepository) {
        this.jdbcIngredientRepository = jdbcIngredientRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return jdbcIngredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return jdbcIngredientRepository.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return jdbcIngredientRepository.save(ingredient);
    }
}
