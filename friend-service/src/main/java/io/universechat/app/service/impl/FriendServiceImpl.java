package io.universechat.app.service.impl;

import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.mapper.FriendMapper;
import io.universechat.app.model.dto.FriendDto;
import io.universechat.app.model.qo.FriendQo;
import io.universechat.app.repository.FriendRepository;
import io.universechat.app.service.IFriendService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class FriendServiceImpl implements IFriendService {

    private final FriendRepository friendRepository;
    private final FriendMapper friendMapper;

    @Override
    public Mono<?> add(FriendDto entity) throws Exception {
        return friendRepository.save(friendMapper.toEntity(entity));
    }

    @Override
    public Mono<?> update(Long id, FriendDto entity) throws Exception {
        return null;
    }

    @Override
    public Mono<?> delete(Long id) throws Exception {
        return friendRepository.findById(id).flatMap(f -> {
            f.setDeleted(true);
            return friendRepository.save(f);
        });
    }

    @Override
    public Mono<?> getById(Long id) throws Exception {
        return friendRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("Friend not found")));
    }

    @Override
    public Flux<?> getAll(FriendQo filter) throws Exception {
        return null;
    }
}
