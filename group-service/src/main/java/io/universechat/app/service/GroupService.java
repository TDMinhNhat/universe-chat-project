package io.universechat.app.service;

import io.universechat.app.core.service.IService;
import io.universechat.app.entity.Group;
import io.universechat.app.model.dto.GroupDto;
import io.universechat.app.model.qo.GroupQo;
import reactor.core.publisher.Mono;

public interface GroupService extends IService<GroupDto, Long, GroupQo> {
    Mono<Group> update(Long id, GroupDto entity) throws Exception;
}
