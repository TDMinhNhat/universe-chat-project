package io.universechat.app.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.entity.UserRole;

@Repository
public interface UserRoleRepository extends ReactorCrudRepository<UserRole, Long>, ReactorPageableRepository<UserRole, Long> {
}
