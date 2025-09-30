package io.universechat.app.core.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.universechat.app.core.exception.NotImageFileException;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
@Produces
public class NotImageFileExceptionHandle implements ExceptionHandler<NotImageFileException, Mono<HttpResponse<?>>> {

    @Override
    public Mono<HttpResponse<?>> handle(HttpRequest request, NotImageFileException exception) {
        return Mono.just(HttpResponse.badRequest("This file isn't image"));
    }
}
