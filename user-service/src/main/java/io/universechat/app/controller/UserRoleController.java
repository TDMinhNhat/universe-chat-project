package io.universechat.app.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.universechat.app.core.controller.IController;
import io.universechat.app.entity.UserRole;
import io.universechat.app.model.dto.CreateUserRoleDto;
import io.universechat.app.model.qo.UserRoleQo;
import io.universechat.app.service.IUserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "/v1/user-role")
@RequiredArgsConstructor
public class UserRoleController implements IController<CreateUserRoleDto, Long, UserRoleQo> {

    private final IUserRoleService userRoleService;

    @Post(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> add(@Valid @Body CreateUserRoleDto entity) throws Exception {
        return userRoleService.add(entity);
    }

    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> update(@PathVariable("id") Long id, @Valid @Body CreateUserRoleDto entity) throws Exception {
        return userRoleService.update(id, entity);
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> delete(@PathVariable("id") Long id) throws Exception {
        return userRoleService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> getById(@PathVariable("id") Long id) throws Exception {
        return userRoleService.getById(id);
    }

    @Post(value = "/get-all", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<?> getAll(@Valid @Body UserRoleQo filter) throws Exception {
        return userRoleService.getAll(filter);
    }
}
