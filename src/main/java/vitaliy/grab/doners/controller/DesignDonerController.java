package vitaliy.grab.doners.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import vitaliy.grab.doners.model.Doner;
import vitaliy.grab.doners.model.Ingredient;
import vitaliy.grab.doners.model.Order;
import vitaliy.grab.doners.service.IngredientService;

import java.util.ArrayList;
import java.util.List;

import static vitaliy.grab.doners.model.Ingredient.Type;

/**
 * Oywayten 06.11.2023.
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignDonerController {

    private final IngredientService ingredientService;

    public DesignDonerController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientService.findAll();
        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    private Iterable<Ingredient> filterByType(Iterable<Ingredient> ingredients, Type type) {
        List<Ingredient> list = new ArrayList<>();
        for (Ingredient x : ingredients) {
            if (x.getType().equals(type)) {
                list.add(x);
            }
        }
        return list;
    }

    @ModelAttribute
    public Order order() {
        return new Order();
    }

    @ModelAttribute("doner")
    public Doner doner() {
        return new Doner();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processDoner(@Valid Doner doner, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }
        order.addDoner(doner);
        log.info("Processing doner: {}", doner);
        return "redirect:/orders/current";
    }
}
