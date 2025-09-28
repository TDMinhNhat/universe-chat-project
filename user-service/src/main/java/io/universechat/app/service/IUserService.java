package io.universechat.app.service;

import io.universechat.app.core.service.IService;
import io.universechat.app.model.dto.CreateUserDto;
import io.universechat.app.model.qo.UserQo;

public interface IUserService extends IService<CreateUserDto, Long, UserQo> {
}
