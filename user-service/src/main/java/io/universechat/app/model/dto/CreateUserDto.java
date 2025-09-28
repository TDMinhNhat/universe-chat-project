package io.universechat.app.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.model.dto.BaseDto;
import io.universechat.app.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Serdeable
@Getter @Setter
public class CreateUserDto extends BaseDto {

    @NotBlank(message = "can not be null or empty")
    @Size(max = 200, message = "max length is {max} characters")
    private String fullName;

    @NotNull(message = "can not be null or empty")
    private Gender sex;

    @NotNull(message = "can not be null or empty")
    private LocalDate birthDate;

    @NotBlank(message = "can not be null or empty")
    @Size(max = 30, message = "max length is {max} characters")
    private String phone;

    @Size(max = 300, message = "max length is {max} characters")
    private String address;

    @NotBlank(message = "can not be null or empty")
    @Size(max = 100, message = "max length is {max} characters")
    private String username;

    @NotBlank(message = "can not be null or empty")
    @Size(max = 300, message = "max length is {max} characters")
    private String email;

    @NotBlank(message = "can not be null or empty")
    @Size(max = 300, message = "max length is {max} characters")
    private String password;
}
