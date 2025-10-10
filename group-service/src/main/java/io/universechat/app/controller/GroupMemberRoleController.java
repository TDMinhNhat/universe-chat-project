package io.universechat.app.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.universechat.app.core.controller.IController;
import io.universechat.app.entity.GroupMemberRole;
import io.universechat.app.model.dto.GroupMemberRoleDto;
import io.universechat.app.model.qo.GroupMemberRoleQo;
import io.universechat.app.service.GroupMemberRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller("/group-member-roles")
@RequiredArgsConstructor
public class GroupMemberRoleController implements IController<GroupMemberRoleDto, Long, GroupMemberRoleQo, GroupMemberRole> {

    private final GroupMemberRoleService groupMemberRoleService;

    @Post(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMemberRole> add(@Valid @Body GroupMemberRoleDto entity) throws Exception {
        return groupMemberRoleService.add(entity);
    }

    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMemberRole> update(@PathVariable("id") Long id, @Valid @Body GroupMemberRoleDto entity) throws Exception {
        return groupMemberRoleService.update(id, entity);
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMemberRole> delete(@PathVariable("id") Long id) throws Exception {
        return groupMemberRoleService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMemberRole> getById(@PathVariable("id") Long id) throws Exception {
        return groupMemberRoleService.getById(id);
    }

    @Get
    @Override
    public Flux<GroupMemberRole> getAll(@Valid GroupMemberRoleQo filter) throws Exception {
        return groupMemberRoleService.getAll(filter);
    }
}
