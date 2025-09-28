package io.universechat.app.core.service;

import reactor.core.publisher.Mono;

import java.net.http.HttpResponse;

public interface IService<S, P, F> {
    Mono<HttpResponse<Object>> add(S entity) throws Exception;

    Mono<HttpResponse<Object>> update(P id, S entity) throws Exception;

    Mono<HttpResponse<Object>> delete(P id) throws Exception;

    Mono<HttpResponse<Object>> getById(P id) throws Exception;

    Mono<HttpResponse<Object>> getAll(F filter) throws Exception;
}
