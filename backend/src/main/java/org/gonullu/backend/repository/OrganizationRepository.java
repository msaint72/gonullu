package org.gonullu.backend.repository;

import org.gonullu.backend.domain.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<Organization,Long> {
    Optional<Organization> findById(Long id);
}
