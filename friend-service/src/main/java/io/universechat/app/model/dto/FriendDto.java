package io.universechat.app.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Serdeable
@Getter @Setter
public class FriendDto extends BaseDto {

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be a positive number")
    private Long senderId;

    @NotNull(message = "can not be null or empty")
    @Positive(message = "must be a positive number")
    private Long receiveId;

    @NotNull(message = "can not be null or empty")
    @Size(max = 500, message = "max length is {max} characters")
    private String senderNote;
}
