package io.universechat.app.mapper;

import io.micronaut.context.annotation.Mapper;
import io.universechat.app.entity.UserRole;
import io.universechat.app.model.dto.CreateUserRoleDto;

@Mapper
public interface UserRoleMapper {

    UserRole toUserRole(CreateUserRoleDto entity);
}
