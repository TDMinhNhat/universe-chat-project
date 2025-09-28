package io.universechat.app.controller;

import reactor.core.publisher.Mono;

import java.net.http.HttpResponse;

public interface IController<S, P, F> {
    Mono<HttpResponse<Object>> add(S entity);

    Mono<HttpResponse<Object>> update(P id, S entity);

    Mono<HttpResponse<Object>> delete(P id);

    Mono<HttpResponse<Object>> getById(P id);

    Mono<HttpResponse<Object>> getAll(F filter);
}
