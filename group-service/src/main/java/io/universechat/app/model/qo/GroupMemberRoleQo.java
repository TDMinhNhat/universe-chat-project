package io.universechat.app.model.qo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.qo.BaseQo;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Serdeable
@Data
@Introspected
public class GroupMemberRoleQo extends BaseQo {

    @Size(max = 100, message = "max length is {max} characters")
    private String name;

    @Size(max = 50, message = "max length is {max} characters")
    private String colorCode;
}
