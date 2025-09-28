package io.universechat.app.entity;

import io.micronaut.data.annotation.DateCreated;
import io.micronaut.data.annotation.DateUpdated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
public abstract class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "deleted", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean deleted;

    @DateCreated
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant createdAt;

    @DateUpdated
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by", nullable = false, updatable = false, columnDefinition = "VARCHAR(50) DEFAULT 'SYSTEM'")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Version
    @Column(name = "version", nullable = false, columnDefinition = "BIGINT DEFAULT 0")
    private Long version;

    public BaseEntity(String note, String createdBy) {
        this.note = note;
        this.createdBy = createdBy;
    }
}
