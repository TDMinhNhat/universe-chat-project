package io.universechat.app.mapper;

import io.micronaut.context.annotation.Mapper;
import io.universechat.app.entity.Friend;
import io.universechat.app.model.dto.FriendDto;

@Mapper
public interface FriendMapper {

    Friend toEntity(FriendDto friendDto);
}
