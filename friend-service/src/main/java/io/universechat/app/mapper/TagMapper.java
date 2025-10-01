package io.universechat.app.mapper;

import io.micronaut.context.annotation.Mapper;
import io.universechat.app.entity.Tag;
import io.universechat.app.model.dto.TagDto;

@Mapper
public interface TagMapper {

    Tag toTag(TagDto entity);
}
