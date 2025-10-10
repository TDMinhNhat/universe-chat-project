package io.universechat.app.service.impl;

import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.GroupMemberRole;
import io.universechat.app.model.dto.GroupMemberRoleDto;
import io.universechat.app.model.qo.GroupMemberRoleQo;
import io.universechat.app.repository.GroupMemberRoleRepository;
import io.universechat.app.service.GroupMemberRoleService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class GroupMemberRoleServiceImpl implements GroupMemberRoleService {

    private final GroupMemberRoleRepository groupMemberRoleRepository;

    @Override
    public Mono<GroupMemberRole> add(GroupMemberRoleDto entity) throws Exception {
        return groupMemberRoleRepository.save(new GroupMemberRole(
                entity.getNote(),
                null,
                entity.getName(),
                entity.getColorCode()
        ));
    }

    @Override
    public Mono<GroupMemberRole> update(Long id, GroupMemberRoleDto entity) throws Exception {
        return groupMemberRoleRepository.findAndUpdate(id, entity);
    }

    @Override
    public Mono<GroupMemberRole> delete(Long id) throws Exception {
        return groupMemberRoleRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Member Role Not Found")))
                .flatMap(item -> {
                    item.setDeleted(true);
                    return groupMemberRoleRepository.update(item);
                });
    }

    @Override
    public Mono<GroupMemberRole> getById(Long id) throws Exception {
        return groupMemberRoleRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group Member Role Not Found")));
    }

    @Override
    public Flux<GroupMemberRole> getAll(GroupMemberRoleQo filter) throws Exception {
        return groupMemberRoleRepository.getAllGroupMemberRolesByFilter(
                filter.getId(),
                filter.getDeleted(),
                filter.getName(),
                filter.getColorCode(),
                filter.getPageable()
        ).flatMapMany(Flux::fromIterable);
    }
}
