package pl.k1it.spring5recipe2app.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.k1it.spring5recipe2app.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
