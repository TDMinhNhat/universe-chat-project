package io.universechat.app.service;

import io.micronaut.http.multipart.StreamingFileUpload;
import io.universechat.app.core.service.IService;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface IUserService extends IService<CreateUserDto, Long, UserQo> {
    Mono<?> addWithAvatar(@Valid CreateUserDto entity, StreamingFileUpload file) throws Exception;
}
