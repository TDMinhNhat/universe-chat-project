package io.universechat.app.service.impl;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpResponse;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
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

    @Override
    public Mono<HttpResponse<?>> add(CreateUserDto entity) throws Exception {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> update(Long id, CreateUserDto entity) throws Exception {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> delete(Long id) throws Exception {
        return null;
    }

    @Override
    public Mono<HttpResponse<?>> getById(Long id) throws Exception {
        return null;
    }

    @Override
    public MutableHttpResponse<Flux<?>> getAll(UserQo filter) throws Exception {
        return null;
    }
}
