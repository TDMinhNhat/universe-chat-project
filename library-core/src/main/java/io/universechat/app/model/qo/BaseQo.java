package io.universechat.app.model.qo;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Positive;

import java.time.Instant;

@Serdeable
public abstract class BaseQo {

    @Positive(message = "must be positive")
    private Long id;

    private Boolean deleted;

    private Instant createdAt;

    private Instant updatedAt;
}
