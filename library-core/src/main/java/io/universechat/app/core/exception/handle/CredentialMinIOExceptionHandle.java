package io.universechat.app.core.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.universechat.app.core.exception.CredentialMinIOException;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
@Produces
public class CredentialMinIOExceptionHandle implements ExceptionHandler<CredentialMinIOException, Mono<HttpResponse<?>>> {

    @Override
    public Mono<HttpResponse<?>> handle(HttpRequest request, CredentialMinIOException exception) {
        return Mono.just(HttpResponse.serverError(exception.getMessage()));
    }
}
