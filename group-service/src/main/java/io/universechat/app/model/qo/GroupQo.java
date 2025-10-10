package io.universechat.app.model.qo;

import io.universechat.app.core.model.qo.BaseQo;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupQo extends BaseQo {

    @Size(max = 100, message = "max length is {max} characters")
    private String title;

    @Positive(message = "must be a positive number")
    private Long ownerId;
}
