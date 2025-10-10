package io.universechat.app.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.universechat.app.core.controller.IController;
import io.universechat.app.entity.Group;
import io.universechat.app.model.dto.GroupDto;
import io.universechat.app.model.qo.GroupQo;
import io.universechat.app.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "/v1/groups")
@RequiredArgsConstructor
public class GroupController implements IController<GroupDto, Long, GroupQo, Group> {
    
    private final GroupService groupService;

    @Post(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<Group> add(@Valid @Body GroupDto entity) throws Exception {
        return groupService.add(entity);
    }

    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<Group> update(@PathVariable("id") Long id, @Valid @Body GroupDto entity) throws Exception {
        return groupService.update(id, entity);
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<Group> delete(@PathVariable("id") Long id) throws Exception {
        return groupService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<Group> getById(@PathVariable("id") Long id) throws Exception {
        return groupService.getById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<Group> getAll(@Valid GroupQo filter) throws Exception {
        return groupService.getAll(filter);
    }
}
