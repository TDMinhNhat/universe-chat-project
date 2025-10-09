package io.universechat.app.core.model.qo;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.PageRequestDto;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Serdeable
@Data
public abstract class BaseQo extends PageRequestQo {

    @Positive(message = "must be positive")
    private Long id;

    private Boolean deleted;

    private Instant createdAt;

    private Instant updatedAt;
}
