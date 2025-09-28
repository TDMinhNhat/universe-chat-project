package io.universechat.app.core.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.universechat.app.core.exception.QueryNotFoundException;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
@Produces(MediaType.APPLICATION_JSON_STREAM)
public class QueryNotFoundExceptionHandle implements ExceptionHandler<QueryNotFoundException, Mono<HttpResponse<?>>> {

    @Override
    public Mono<HttpResponse<?>> handle(HttpRequest request, QueryNotFoundException exception) {
        return Mono.just(HttpResponse.notFound(exception.getMessage()));
    }
}
