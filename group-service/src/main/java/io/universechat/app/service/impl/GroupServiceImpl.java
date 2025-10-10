package io.universechat.app.service.impl;

import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.Group;
import io.universechat.app.mapper.GroupMapper;
import io.universechat.app.model.dto.GroupDto;
import io.universechat.app.model.qo.GroupQo;
import io.universechat.app.repository.GroupRepository;
import io.universechat.app.service.GroupService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Override
    public Mono<Group> add(GroupDto entity) throws Exception {
        return groupRepository.save(groupMapper.toEntity(entity));
    }

    @Override
    public Mono<Group> update(Long id, GroupDto entity) throws Exception {
        return groupRepository.findAndUpdate(id, entity);
    }

    @Override
    public Mono<Group> delete(Long id) throws Exception {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group not found")))
                .mapNotNull(target -> {
                    target.setDeleted(true);
                    return target;
                }).flatMap(groupRepository::save);
    }

    @Override
    public Mono<Group> getById(Long id) throws Exception {
        return groupRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Group not found")));
    }

    @Override
    public Flux<Group> getAll(GroupQo filter) throws Exception {
        return groupRepository.getAllGroupsByFilter(
                filter.getTitle(),
                filter.getOwnerId(),
                filter.getId(),
                filter.getDeleted(),
                filter.getPageable()
        ).flatMapMany(Flux::fromIterable);
    }
}
