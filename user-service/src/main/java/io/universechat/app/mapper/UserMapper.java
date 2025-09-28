package io.universechat.app.mapper;

import io.micronaut.context.annotation.Mapper;
import io.universechat.app.entity.User;
import io.universechat.app.model.dto.CreateUserDto;

@Mapper
public interface UserMapper {

    User toUser(CreateUserDto entity);
}
