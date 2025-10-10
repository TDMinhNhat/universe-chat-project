package io.universechat.app.mapper;

import io.micronaut.context.annotation.Mapper;
import io.universechat.app.entity.Group;
import io.universechat.app.model.dto.GroupDto;

@Mapper
public interface GroupMapper {

    Group toEntity(GroupDto dto);
}
