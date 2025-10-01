package io.universechat.app.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Serdeable
@Data
public class TagDto extends BaseDto {

    @NotBlank(message = "can not be null or empty")
    @Size(max = 50, message = "max length is {max} characters")
    private String code;

    @NotBlank(message = "can not be null or empty")
    @Size(max = 200, message = "max length is {max} characters")
    private String name;
}
