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
public class GroupDto extends BaseDto {

    @NotNull(message = "can not be null or empty")
    @Size(max = 100, message = "max length is {max} characters")
    private String title;

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be a positive number")
    private Long ownerId;

    @Size(max = 500, message = "max length is {max} characters")
    private String description;
}
