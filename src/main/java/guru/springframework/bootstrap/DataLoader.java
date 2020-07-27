package guru.springframework.bootstrap;

import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repository.IngredientRepository;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository uomRepository;

    public DataLoader(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository uomRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.uomRepository = uomRepository;

        this.ingredientRepository.save(new Ingredient());
    }

    @Override
    public void run(String... args) throws Exception {

        Recipe guacamole = new Recipe();

        guacamole.setDescription("Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setServings(3);
        guacamole.setCookTime(0);
        guacamole.setSource("Simply Recipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

        UnitOfMeasure teaSpoon = new UnitOfMeasure();
        teaSpoon.setDescription("TeaSpoon");
        uomRepository.save(teaSpoon);

        Ingredient salt = new Ingredient();
        salt.setUnitOfMeasure(teaSpoon);
        salt.setRecipe(guacamole);
        salt.setAmount(BigDecimal.valueOf(0.25));
        salt.setDescription("Salt");

        UnitOfMeasure unit = new UnitOfMeasure();
        unit.setDescription("Unit");
        uomRepository.save(unit);

        Ingredient avocado = new Ingredient();
        avocado.setRecipe(guacamole);
        avocado.setDescription("Avocado");
        avocado.setAmount(BigDecimal.valueOf(2L));
        avocado.setUnitOfMeasure(unit);

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(avocado);
        ingredients.add(salt);

        guacamole.setIngredients(ingredients);
        recipeRepository.save(guacamole);
        ingredientRepository.save(avocado);
        ingredientRepository.save(salt);

        System.out.println(guacamole);


    }
}
