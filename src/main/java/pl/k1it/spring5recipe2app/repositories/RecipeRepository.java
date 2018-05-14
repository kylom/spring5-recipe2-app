package pl.k1it.spring5recipe2app.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.k1it.spring5recipe2app.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
