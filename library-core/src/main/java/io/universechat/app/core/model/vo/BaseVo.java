package io.universechat.app.core.model.vo;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Serdeable
@Getter @Setter
public abstract class BaseVo {

    private Long id;

    private String note;

    private Boolean deleted;

    private Instant createdAt;

    private Instant updatedAt;

    private String createdBy;

    private String updatedBy;
}
