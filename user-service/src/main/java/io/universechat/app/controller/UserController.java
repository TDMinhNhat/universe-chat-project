package io.universechat.app.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.universechat.app.core.controller.IController;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
import io.universechat.app.service.IUserService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller("/v1/user")
@RequiredArgsConstructor
public class UserController implements IController<CreateUserDto, Long, UserQo> {

    private final IUserService userService;

    @Override
    public Mono<HttpResponse<?>> add(CreateUserDto entity) {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> update(Long id, CreateUserDto entity) {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> delete(Long id) {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> getById(Long id) {
        return null;
    }

    @Override
    public MutableHttpResponse<Flux<?>> getAll(UserQo filter) {
        return null;
    }
}
