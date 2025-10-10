package io.universechat.app.service;

import io.universechat.app.core.service.IService;
import io.universechat.app.entity.GroupMember;
import io.universechat.app.model.dto.GroupMemberDto;
import io.universechat.app.model.qo.GroupMemberQo;

public interface GroupMemberService extends IService<GroupMemberDto, Long, GroupMemberQo, GroupMember> {
}
