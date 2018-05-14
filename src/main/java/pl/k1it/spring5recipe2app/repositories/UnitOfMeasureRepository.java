package pl.k1it.spring5recipe2app.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.k1it.spring5recipe2app.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
