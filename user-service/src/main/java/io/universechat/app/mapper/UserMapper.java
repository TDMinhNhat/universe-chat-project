package io.universechat.app.mapper;

import io.micronaut.context.annotation.Mapper;
import io.universechat.app.entity.User;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.vo.UserVo;

@Mapper
public interface UserMapper {

    User toUser(CreateUserDto entity);

    UserVo toUserVo(User entity);
}
