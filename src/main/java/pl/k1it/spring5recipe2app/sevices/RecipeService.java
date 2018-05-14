package pl.k1it.spring5recipe2app.sevices;

import pl.k1it.spring5recipe2app.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
