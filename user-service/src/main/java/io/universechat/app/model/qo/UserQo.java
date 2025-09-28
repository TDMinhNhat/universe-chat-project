package io.universechat.app.model.qo;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.qo.BaseQo;
import io.universechat.app.enums.Gender;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Serdeable
public class UserQo extends BaseQo {

    @Size(max = 50, message = "max length is {max} characters")
    private String userId;

    @Size(max = 200, message = "max length is {max} characters")
    private String fullName;

    private Gender sex;

    private LocalDate birthDate;

    @Size(max = 30, message = "max length is {max} characters")
    private String phone;

    @Size(max = 100, message = "max length is {max} characters")
    private String username;

    @Size(max = 300, message = "max length is {max} characters")
    private String email;

    private Boolean verified;
}
