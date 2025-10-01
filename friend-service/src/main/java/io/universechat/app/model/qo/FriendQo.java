package io.universechat.app.model.qo;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.qo.BaseQo;
import io.universechat.app.enums.FriendStatus;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Serdeable
@Getter @Setter
public class FriendQo extends BaseQo {

    @Positive(message = "must be a positive number")
    private Long senderId;

    @Positive(message = "must be a positive number")
    private Long receiveId;

    private FriendStatus status;
}
