package io.universechat.app.core.service;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IService<S, P, F> {
    Mono<HttpResponse<?>> add(S entity) throws Exception;

    Mono<HttpResponse<?>> update(P id, S entity) throws Exception;

    Mono<HttpResponse<?>> delete(P id) throws Exception;

    Mono<HttpResponse<?>> getById(P id) throws Exception;

    MutableHttpResponse<Flux<?>> getAll(F filter) throws Exception;
}
