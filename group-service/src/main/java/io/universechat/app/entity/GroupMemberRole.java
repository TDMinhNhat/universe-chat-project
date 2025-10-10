package io.universechat.app.entity;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Serdeable
@Entity @Table(name = "group_member_roles")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class GroupMemberRole extends BaseEntity {

    @Column(name = "role_name", length = 100, nullable = false)
    @NonNull
    private String name;

    @Column(name = "color_code", length = 50, nullable = false)
    @NonNull
    private String colorCode;

    public GroupMemberRole(String note, String createdBy, @NonNull String name, @NonNull String colorCode) {
        super(note, createdBy);
        this.name = name;
        this.colorCode = colorCode;
    }
}
