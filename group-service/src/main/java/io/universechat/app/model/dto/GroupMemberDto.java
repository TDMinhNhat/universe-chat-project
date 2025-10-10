package io.universechat.app.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.BaseDto;
import io.universechat.app.enums.GroupMemberStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Serdeable
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupMemberDto extends BaseDto {

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be a positive number")
    private Long groupId;

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be a positive number")
    private Long userId;

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be a positive number")
    private Long roleId;

    @NotNull(message = "can not be null or empty")
    private GroupMemberStatus status;
}
