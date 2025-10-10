package io.universechat.app.core.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IController<S, P, F, R> {
    Mono<R> add(S entity) throws Exception;

    Mono<R> update(P id, S entity) throws Exception;

    Mono<R> delete(P id) throws Exception;

    Mono<R> getById(P id) throws Exception;

    Flux<R> getAll(F filter) throws Exception;
}
