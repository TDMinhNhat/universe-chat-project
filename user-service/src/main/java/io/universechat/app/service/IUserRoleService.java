package io.universechat.app.service;

import io.universechat.app.core.service.IService;
import io.universechat.app.entity.UserRole;
import io.universechat.app.model.dto.CreateUserRoleDto;
import io.universechat.app.model.qo.UserRoleQo;

public interface IUserRoleService extends IService<CreateUserRoleDto, Long, UserRoleQo> {
}
