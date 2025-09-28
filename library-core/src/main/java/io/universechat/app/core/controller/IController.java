package io.universechat.app.core.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IController<S, P, F> {
    Mono<HttpResponse<?>> add(S entity);

    Mono<HttpResponse<?>> update(P id, S entity);

    Mono<HttpResponse<?>> delete(P id);

    Mono<HttpResponse<?>> getById(P id);

    MutableHttpResponse<Flux<?>> getAll(F filter);
}
