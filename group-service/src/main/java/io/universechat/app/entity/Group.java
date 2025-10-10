package io.universechat.app.entity;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.entity.BaseEntity;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Serdeable
@Entity @Table(name = "groups")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class Group extends BaseEntity {

    @Column(name = "title", length = 100, nullable = false)
    @Nonnull
    private String title;

    @Column(name = "owner_id", nullable = false)
    @Nonnull
    private Long ownerId;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "avatar", length = 500)
    private String avatar;

}
