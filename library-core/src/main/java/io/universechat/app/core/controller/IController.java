package io.universechat.app.core.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IController<S, P, F> {
    Mono<?> add(S entity) throws Exception;

    Mono<?> update(P id, S entity) throws Exception;

    Mono<?> delete(P id) throws Exception;

    Mono<?> getById(P id) throws Exception;

    Flux<?> getAll(F filter) throws Exception;
}
