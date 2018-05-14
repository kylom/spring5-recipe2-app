package pl.k1it.spring5recipe2app.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.k1it.spring5recipe2app.domain.*;
import pl.k1it.spring5recipe2app.repositories.CategoryRepository;
import pl.k1it.spring5recipe2app.repositories.RecipeRepository;
import pl.k1it.spring5recipe2app.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("onApplicationEvent");
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if(!eachUomOptional.isPresent()) {
            throw  new RuntimeException("Exception UOM Not Found");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tableSpoonUomOptional.isPresent()) {
            throw  new RuntimeException("Exception UOM Not Found");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaSpoonUomOptional.isPresent()) {
            throw  new RuntimeException("Exception UOM Not Found");
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUomOptional.isPresent()) {
            throw  new RuntimeException("Exception UOM Not Found");
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUomOptional.isPresent()) {
            throw  new RuntimeException("Exception UOM Not Found");
        }

        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!cupUomOptional.isPresent()) {
            throw  new RuntimeException("Exception UOM Not Found");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        // get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()) {
            throw  new RuntimeException("Exception Category Not Found");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()) {
            throw  new RuntimeException("Exception Category Not Found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();


        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDescription("bla bla bla");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("bla bla bla");
        guacNotes.setRecipe(guacRecipe);

        guacRecipe.setNotes(guacNotes);

        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(5), teaSpoonUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), tableSpoonUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), teaSpoonUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), eachUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), teaSpoonUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), dashUom, guacRecipe));
        guacRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(5), eachUom, guacRecipe));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("bla bla bla");

        Notes tacosNotes = new Notes();
        tacosNotes.setRecipeNotes("bla bla bla");
        tacosNotes.setRecipe(tacosRecipe);

        tacosRecipe.setNotes(tacosNotes);

        tacosRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(5), teaSpoonUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), tableSpoonUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), teaSpoonUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), eachUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), teaSpoonUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(2), dashUom, tacosRecipe));
        tacosRecipe.addIngredient(new Ingredient("kosher salt", new BigDecimal(5), eachUom, tacosRecipe));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);

        return recipes;
    }
}
