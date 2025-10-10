package io.universechat.app.model.qo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.qo.BaseQo;
import io.universechat.app.entity.GroupMemberRole;
import io.universechat.app.enums.GroupMemberStatus;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Serdeable
@Data
@EqualsAndHashCode(callSuper = true)
@Introspected
public class GroupMemberQo extends BaseQo {

    @Positive(message = "must be a positive number")
    private Long groupId;

    @Positive(message = "must be a positive number")
    private Long userId;

    private GroupMemberRole role;

    private GroupMemberStatus status;
}
