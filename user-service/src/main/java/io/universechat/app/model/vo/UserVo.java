package io.universechat.app.model.vo;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.vo.BaseVo;
import io.universechat.app.enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Serdeable
@Getter @Setter
public class UserVo extends BaseVo {
    private String userId;
    private String fullName;
    private Gender sex;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String avatar;
    private String username;
    private String email;
    private Boolean verified;
}
