package io.universechat.app.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.entity.User;

@Repository
public interface UserRepository extends ReactorCrudRepository<User, Long>, ReactorPageableRepository<User, Long> {
}
