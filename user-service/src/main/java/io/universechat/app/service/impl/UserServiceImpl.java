package io.universechat.app.service.impl;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Slice;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.mapper.UserMapper;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
import io.universechat.app.model.vo.UserVo;
import io.universechat.app.repository.UserRepository;
import io.universechat.app.service.IUserService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Mono<?> add(CreateUserDto entity) throws Exception {
        return userRepository.save(userMapper.toUser(entity)).map(userMapper::toUserVo);
    }

    @Override
    public Mono<?> update(Long id, CreateUserDto entity) throws Exception {
        return userRepository.findByIdAndUpdate(id, entity).map(userMapper::toUserVo);
    }

    @Override
    public Mono<?> delete(Long id) throws Exception {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(new QueryNotFoundException("User not found")))
                .flatMap(user -> {
                    user.setDeleted(true);
                    return userRepository.save(user).map(userMapper::toUserVo);
                });
    }

    @Override
    public Mono<?> getById(Long id) throws Exception {
        return userRepository.findById(id).switchIfEmpty(Mono.error(new QueryNotFoundException("User not found")));
    }

    @Override
    public Flux<?> getAll(UserQo filter) throws Exception {
        return userRepository.getAllUsersByFilter(filter, filter.getPageRequest().getPageable())
                .map(Slice::getContent)
                .flux();
    }
}
