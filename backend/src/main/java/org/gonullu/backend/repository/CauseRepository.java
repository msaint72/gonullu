package org.gonullu.backend.repository;

import org.gonullu.backend.domain.Cause;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CauseRepository extends CrudRepository<Cause,Long> {
    List<Cause> findAll();
    Cause findCauseByName(String name);
}
