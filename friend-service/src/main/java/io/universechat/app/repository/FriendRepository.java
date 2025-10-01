package io.universechat.app.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import io.universechat.app.entity.Friend;
import io.universechat.app.model.dto.FriendDto;
import reactor.core.publisher.Mono;

@Repository
public interface FriendRepository extends ReactorCrudRepository<Friend, Long>, ReactorPageableRepository<Friend, Long> {


}
