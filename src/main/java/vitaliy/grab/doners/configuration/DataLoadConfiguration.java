package vitaliy.grab.doners.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.service.IngredientService;
import vitaliy.grab.doners.service.UserService;

import static vitaliy.grab.doners.model.Ingredient.Type;

/**
 * Oywayten 15.11.2023.
 */
@Configuration
@AllArgsConstructor
public class DataLoadConfiguration {

    private final PasswordEncoder encoder;
    @Bean
    public CommandLineRunner ingredientDataLoader(IngredientService ingredientService) {
        return args -> {
            ingredientService.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            ingredientService.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            ingredientService.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            ingredientService.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            ingredientService.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            ingredientService.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            ingredientService.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            ingredientService.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            ingredientService.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            ingredientService.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };
    }

    @Bean
    public CommandLineRunner userDataLoader(UserService userService) {
        return args -> {
            userService.save(new User("buzz", encoder.encode("password"), null, null, null, null, null, null));
            userService.save(new User("user", encoder.encode("password"), null, null, null, null, null, null));
        };
    }
}
