package io.universechat.app.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.universechat.app.core.controller.IController;
import io.universechat.app.model.dto.CreateUserRoleDto;
import io.universechat.app.model.qo.UserRoleQo;
import io.universechat.app.service.IUserRoleService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "/v1/user-role")
@RequiredArgsConstructor
public class UserRoleController implements IController<CreateUserRoleDto, Long, UserRoleQo> {

    private final IUserRoleService userRoleService;

    @Override
    public Mono<HttpResponse<?>> add(CreateUserRoleDto entity) {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> update(Long id, CreateUserRoleDto entity) {
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
    public MutableHttpResponse<Flux<?>> getAll(UserRoleQo filter) {
        return null;
    }
}
