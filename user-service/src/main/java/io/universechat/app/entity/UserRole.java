package io.universechat.app.entity;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Serdeable
@Entity @Table(name = "user_roles")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
@DynamicInsert @DynamicUpdate
public class UserRole extends BaseEntity {

    @Column(name = "role_code", length = 50, unique = true, nullable = false)
    @NonNull
    private String code;

    @Column(name = "role_name", length = 200, unique = true, nullable = false)
    @NonNull
    private String name;

    public UserRole(String note, String createdBy, @NonNull String code, @NonNull String name) {
        super(note, createdBy);
        this.code = code;
        this.name = name;
    }
}
