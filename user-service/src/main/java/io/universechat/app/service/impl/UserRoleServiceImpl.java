package io.universechat.app.service.impl;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.entity.UserRole;
import io.universechat.app.mapper.UserRoleMapper;
import io.universechat.app.model.dto.CreateUserRoleDto;
import io.universechat.app.model.qo.UserRoleQo;
import io.universechat.app.repository.UserRoleRepository;
import io.universechat.app.service.IUserRoleService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Singleton
@RequiredArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRoleMapper userRoleMapper;

    @Override
    public Mono<UserRole> add(CreateUserRoleDto entity) throws Exception {
        return userRoleRepository.save(userRoleMapper.toUserRole(entity));
    }

    @Override
    public Mono<UserRole> update(Long id, CreateUserRoleDto entity) throws Exception {
        return userRoleRepository.findByIdAndUpdate(id, entity);
    }

    @Override
    public Mono<UserRole> delete(Long id) throws Exception {
        return userRoleRepository.findById(id)
                .switchIfEmpty(Mono.error(new QueryNotFoundException("Not found the UserRole")))
                .flatMap(item -> {
                    item.setDeleted(true);
                    return userRoleRepository.update(item);
                });
    }

    @Override
    public Mono<HttpResponse<?>> getById(Long id) throws Exception {
        return userRoleRepository.findById(id)
                .switchIfEmpty(Mono.error(new QueryNotFoundException("Not found the UserRole")))
                .map(HttpResponse::ok);
    }

    @Override
    public Flux<?> getAll(UserRoleQo filter) throws Exception {
        return userRoleRepository.findAll();
    }
}
