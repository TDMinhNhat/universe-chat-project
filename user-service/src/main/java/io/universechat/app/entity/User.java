package io.universechat.app.entity;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.entity.BaseEntity;
import io.universechat.app.enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Serdeable
@Entity @Table(name = "users")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class User extends BaseEntity {

    @Column(name = "user_id", length = 50, unique = true, nullable = false)
    @NonNull
    private String userId;

    @Column(name = "full_name", length = 200, nullable = false)
    @NonNull
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(name = "sex", length = 100, nullable = false)
    @NonNull
    private Gender sex;

    @Column(name = "birth_date", nullable = false)
    @NonNull
    private LocalDate birthDate;

    @Column(name = "phone", length = 30, unique = true, nullable = false)
    @NonNull
    private String phone;

    @Column(name = "address", length = 300)
    private String address;

    @Column(name = "avatar", length = 300)
    private String avatar;

    @Column(name = "user_name", length = 100, unique = true, nullable = false)
    @NonNull
    private String username;

    @Column(name = "email", length = 300, unique = true, nullable = false)
    @NonNull
    private String email;

    @Column(name = "password", length = 300, nullable = false)
    @NonNull
    private String password;

    @Column(name = "verified", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean verified;
}
