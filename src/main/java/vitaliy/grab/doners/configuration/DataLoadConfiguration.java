package vitaliy.grab.doners.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.service.IngredientService;

import static vitaliy.grab.doners.model.Ingredient.Type;

/**
 * Oywayten 15.11.2023.
 */
@Configuration
public class DataLoadConfiguration {
    @Bean
    public CommandLineRunner dataLoader(IngredientService service) {
        return args -> {
            service.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
            service.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
            service.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
            service.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
            service.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
            service.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
            service.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
            service.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
            service.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
            service.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
        };
    }
}
