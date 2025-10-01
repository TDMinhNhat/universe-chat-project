package io.universechat.app.repository;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsCrudRepository;
import io.micronaut.data.repository.reactive.ReactiveStreamsPageableRepository;
import io.universechat.app.entity.PrivateChat;

@MongoRepository
public interface PrivateChatRepository extends ReactiveStreamsCrudRepository<PrivateChat, Long>, ReactiveStreamsPageableRepository<PrivateChat, Long> {
}
