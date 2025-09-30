package io.universechat.app.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.StreamingFileUpload;
import io.universechat.app.core.controller.IController;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
import io.universechat.app.service.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller("/v1/user")
@RequiredArgsConstructor
public class UserController implements IController<CreateUserDto, Long, UserQo> {

    private final IUserService userService;

    @Post(processes = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> add(@Valid @Body CreateUserDto entity) throws Exception {
        return userService.add(entity);
    }

    @Post(value = "/with-avatar", processes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.APPLICATION_JSON_STREAM)
    public Mono<?> addWithAvatar(@Valid @Body CreateUserDto entity, @Part(value = "avatar")StreamingFileUpload file) throws Exception {
        return userService.addWithAvatar(entity, file);
    }

    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> update(@PathVariable("id") Long id, @Valid @Body CreateUserDto entity) throws Exception {
        return userService.update(id, entity);
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> delete(@PathVariable("id") Long id) throws Exception {
        return userService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<?> getById(@PathVariable("id") Long id) throws Exception {
        return userService.getById(id);
    }

    @Post(value = "/get-list", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<?> getAll(@Body @Valid UserQo filter) throws Exception {
        return userService.getAll(filter);
    }
}
