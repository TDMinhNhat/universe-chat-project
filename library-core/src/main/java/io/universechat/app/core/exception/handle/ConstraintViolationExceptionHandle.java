package io.universechat.app.core.exception.handle;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolationException;
import reactor.core.publisher.Mono;

import java.util.List;

@Singleton
@Produces(MediaType.APPLICATION_JSON_STREAM)
public class ConstraintViolationExceptionHandle implements ExceptionHandler<ConstraintViolationException, Mono<HttpResponse<Object>>> {

    @Override
    public Mono<HttpResponse<Object>> handle(HttpRequest request, ConstraintViolationException exception) {
        List<String> errors = exception.getConstraintViolations().stream().map(item -> item.getPropertyPath() + ": " + item.getMessage()).toList();
        return Mono.just(HttpResponse.badRequest(errors));
    }
}
