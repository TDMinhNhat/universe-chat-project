package io.universechat.app.core.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Serdeable
@Data
public abstract class BaseDto {
    @Size(max = 500, message = "max length is {max} characters")
    private String note;
}
