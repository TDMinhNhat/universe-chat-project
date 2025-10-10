package io.universechat.app.service.impl;

import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.Group;
import io.universechat.app.entity.GroupMember;
import io.universechat.app.entity.GroupMemberRole;
import io.universechat.app.model.dto.GroupMemberDto;
import io.universechat.app.model.qo.GroupMemberQo;
import io.universechat.app.repository.GroupMemberRepository;
import io.universechat.app.repository.GroupMemberRoleRepository;
import io.universechat.app.repository.GroupRepository;
import io.universechat.app.service.GroupMemberService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class GroupMemberServiceImpl implements GroupMemberService {

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final GroupMemberRoleRepository groupMemberRoleRepository;

    @Override
    public Mono<GroupMember> add(GroupMemberDto entity) throws Exception {
        Mono<Group> group = groupRepository.findById(entity.getGroupId()).switchIfEmpty(Mono.error(new QueryNotFoundException("Group not found")));
        Mono<GroupMemberRole> groupMemberRole = groupMemberRoleRepository.findById(entity.getRoleId()).switchIfEmpty(Mono.error(new QueryNotFoundException("Role not found")));
        return Mono.zip(group, groupMemberRole).flatMap(tuple -> {
            Group groupTarget = tuple.getT1();
            GroupMemberRole roleTarget = tuple.getT2();
            GroupMember groupMember = new GroupMember(
                    entity.getNote(),
                    null,
                    groupTarget,
                    entity.getUserId(),
                    roleTarget,
                    entity.getStatus()
            );
            return groupMemberRepository.save(groupMember);
        });
    }

    @Override
    public Mono<GroupMember> update(Long id, GroupMemberDto entity) throws Exception {
        return null;
    }

    @Override
    public Mono<GroupMember> delete(Long id) throws Exception {
        return groupMemberRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group member not found")))
                .mapNotNull(target -> {
                    target.setDeleted(true);
                    return target;
                }).flatMap(groupMemberRepository::save);
    }

    @Override
    public Mono<?> getById(Long id) throws Exception {
        return groupMemberRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group member not found")));
    }

    @Override
    public Flux<GroupMember> getAll(GroupMemberQo filter) throws Exception {
        return groupMemberRepository.getAllGroupMembersByFilter(
                filter.getGroupId(),
                filter.getUserId(),
                filter.getRole(),
                filter.getStatus(),
                filter.getId(),
                filter.getDeleted(),
                filter.getPageable()
        ).flatMapMany(Flux::fromIterable);
    }
}
