package io.universechat.app.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.universechat.app.core.controller.IController;
import io.universechat.app.entity.GroupMember;
import io.universechat.app.model.dto.GroupMemberDto;
import io.universechat.app.model.qo.GroupMemberQo;
import io.universechat.app.service.GroupMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller(value = "/group-members")
@RequiredArgsConstructor
public class GroupMemberController implements IController<GroupMemberDto, Long, GroupMemberQo, GroupMember> {

    private final GroupMemberService groupMemberService;

    @Post(produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMember> add(@Valid @Body GroupMemberDto entity) throws Exception {
        return groupMemberService.add(entity);
    }

    @Override
    public Mono<GroupMember> update(Long id, GroupMemberDto entity) throws Exception {
        return null;
    }

    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMember> delete(@PathVariable("id") Long id) throws Exception {
        return groupMemberService.delete(id);
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Mono<GroupMember> getById(@PathVariable("id") Long id) throws Exception {
        return groupMemberService.getById(id);
    }

    @Get(produces =  MediaType.APPLICATION_JSON_STREAM)
    @Override
    public Flux<GroupMember> getAll(@Valid GroupMemberQo filter) throws Exception {
        return groupMemberService.getAll(filter);
    }
}
