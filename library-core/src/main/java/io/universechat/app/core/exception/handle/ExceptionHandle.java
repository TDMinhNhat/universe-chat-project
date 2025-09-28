package io.universechat.app.core.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
@Produces(MediaType.APPLICATION_JSON_STREAM)
public class ExceptionHandle implements ExceptionHandler<Exception, Mono<HttpResponse<Object>>> {

    @Override
    public Mono<HttpResponse<Object>> handle(HttpRequest request, Exception exception) {
        return Mono.just(HttpResponse.serverError().body(exception.getMessage()));
    }
}
