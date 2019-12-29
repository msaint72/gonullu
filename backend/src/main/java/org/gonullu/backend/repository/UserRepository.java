package org.gonullu.backend.repository;


import org.gonullu.backend.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findByLastName(@Param("lastname") String lastname);

    List<UserEntity> findByFirstName(@Param("firstname") String firstname);

    UserEntity findByEmail(String email);

    UserEntity findByUserId(String userId);
}
