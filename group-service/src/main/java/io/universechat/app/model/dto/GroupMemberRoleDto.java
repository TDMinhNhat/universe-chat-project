package io.universechat.app.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Serdeable
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupMemberRoleDto extends BaseDto {

    @NotNull(message = "can not be null or empty")
    @Size(max = 100, message = "max length is {max} characters")
    private String name;

    @NotNull(message = "can not be null or empty")
    @Size(max = 50, message = "max length is {max} characters")
    private String colorCode;
}
