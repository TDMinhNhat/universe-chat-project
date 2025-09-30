package io.universechat.app.core.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.universechat.app.core.exception.FileContentTypeNotFoundException;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
@Produces
public class FileContentTypeNotFoundExceptionHandle implements ExceptionHandler<FileContentTypeNotFoundException, Mono<HttpResponse<?>>> {

    @Override
    public Mono<HttpResponse<?>> handle(HttpRequest request, FileContentTypeNotFoundException exception) {
        return Mono.just(HttpResponse.notFound("File content type not found: " + exception.getMessage()));
    }
}
