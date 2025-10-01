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
@Entity @Table(name = "tags")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode(callSuper = true)
@DynamicInsert @DynamicUpdate
public class Tag extends BaseEntity {
    @Column(name = "tag_code", length = 50, unique = true, nullable = false)
    @NonNull
    private String code;

    @Column(name = "tag_name", length = 200, unique = true, nullable = false)
    @NonNull
    private String name;

    public Tag(String note, String createdBy, @NonNull String code, @NonNull String name) {
        super(note, createdBy);
        this.code = code;
        this.name = name;
    }
}
