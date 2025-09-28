package io.universechat.app.model.qo;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.PageRequestDto;
import io.universechat.app.core.model.qo.BaseQo;
import jakarta.validation.constraints.Size;

@Serdeable
public class UserRoleQo extends BaseQo {
    @Size(max = 50, message = "max length is {max} characters")
    private String code;

    @Size(max = 200, message = "max length is {max} characters")
    private String name;

    private PageRequestDto pageRequest;
}
