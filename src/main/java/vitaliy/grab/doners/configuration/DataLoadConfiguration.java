package vitaliy.grab.doners.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.model.IngredientId;
import vitaliy.grab.doners.model.User;
import vitaliy.grab.doners.service.DonerService;
import vitaliy.grab.doners.service.IngredientService;
import vitaliy.grab.doners.service.UserService;

import java.util.Arrays;

import static vitaliy.grab.doners.model.Ingredient.Type;

/**
 * Oywayten 15.11.2023.
 */
@Configuration
@AllArgsConstructor
public class DataLoadConfiguration {

    private final PasswordEncoder encoder;

    @Bean
    public CommandLineRunner ingredientDataLoader(IngredientService ingredientService, DonerService donerService) {
        return args -> {
            Ingredient flourTortilla = new Ingredient(IngredientId.FLTO, IngredientId.FLTO.getName(), Type.WRAP);
            Ingredient cornTortilla = new Ingredient(IngredientId.COTO, IngredientId.COTO.getName(), Type.WRAP);
            Ingredient groundBeef = new Ingredient(IngredientId.GRBF, IngredientId.GRBF.getName(), Type.PROTEIN);
            Ingredient carnitas = new Ingredient(IngredientId.CARN, IngredientId.CARN.getName(), Type.PROTEIN);
            Ingredient tomatoes = new Ingredient(IngredientId.TMTO, IngredientId.TMTO.getName(), Type.VEGGIES);
            Ingredient lettuce = new Ingredient(IngredientId.LETC, IngredientId.LETC.getName(), Type.VEGGIES);
            Ingredient cheddar = new Ingredient(IngredientId.CHED, IngredientId.CHED.getName(), Type.CHEESE);
            Ingredient jack = new Ingredient(IngredientId.JACK, IngredientId.JACK.getName(), Type.CHEESE);
            Ingredient salsa = new Ingredient(IngredientId.SLSA, IngredientId.SLSA.getName(), Type.SAUCE);
            Ingredient sourCream = new Ingredient(IngredientId.SRCR, IngredientId.SRCR.getName(), Type.SAUCE);

            ingredientService.save(flourTortilla);
            ingredientService.save(cornTortilla);
            ingredientService.save(groundBeef);
            ingredientService.save(carnitas);
            ingredientService.save(tomatoes);
            ingredientService.save(lettuce);
            ingredientService.save(cheddar);
            ingredientService.save(jack);
            ingredientService.save(salsa);
            ingredientService.save(sourCream);

            Doner doner1 = new Doner();
            doner1.setName("Carnivore");
            doner1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
            donerService.save(doner1);

            Doner doner2 = new Doner();
            doner2.setName("Bovine Bounty");
            doner2.setIngredients(Arrays.asList(cornTortilla, groundBeef, cheddar, jack, sourCream));
            donerService.save(doner2);

            Doner doner3 = new Doner();
            doner3.setName("Veg-Out");
            doner3.setIngredients(Arrays.asList(flourTortilla, cornTortilla, tomatoes, lettuce, salsa));
            donerService.save(doner3);

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
