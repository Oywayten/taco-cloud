package vitaliy.grab.doners.web.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.service.IngredientService;

@RestController("IngredientApiController")
@RequestMapping(value = "/api/ingredients", produces = "application/json")
@AllArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    @GetMapping
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
        return ingredientService.save(ingredient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredientById(@PathVariable("id") Ingredient.Id ingredientId) {
        ingredientService.deleteIngredientById(ingredientId);
    }
}
