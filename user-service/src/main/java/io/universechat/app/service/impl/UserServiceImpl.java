package io.universechat.app.service.impl;

import io.micronaut.data.model.Pageable;
import io.micronaut.data.model.Slice;
import io.micronaut.http.MediaType;
import io.micronaut.http.multipart.StreamingFileUpload;
import io.universechat.app.core.exception.FileContentTypeNotFoundException;
import io.universechat.app.core.exception.NotImageFileException;
import io.universechat.app.core.exception.QueryNotFoundException;
import io.universechat.app.core.util.MinIOUtil;
import io.universechat.app.core.util.ValidateImageUtil;
import io.universechat.app.entity.User;
import io.universechat.app.mapper.UserMapper;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
import io.universechat.app.repository.UserRepository;
import io.universechat.app.service.IUserService;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;

@Singleton
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final MinIOUtil minIOUtil;

    @Override
    public Mono<?> add(CreateUserDto entity) throws Exception {
        return userRepository.save(userMapper.toUser(entity)).map(userMapper::toUserVo);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Mono<?> addWithAvatar(CreateUserDto entity, StreamingFileUpload file) throws Exception {
        try(InputStream inputStream = file.asInputStream()) {
            if(ValidateImageUtil.isImageFile(file.getContentType().orElseThrow(FileContentTypeNotFoundException::new).toString())) {
                String objectName = "avatars/" + entity.getUsername() + "_avatar";
                minIOUtil.uploadFile(objectName, inputStream);
                User user = userMapper.toUser(entity);
                user.setAvatar(objectName);
                return userRepository.save(user).map(userMapper::toUserVo);
            }
            throw new NotImageFileException();
        }
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
