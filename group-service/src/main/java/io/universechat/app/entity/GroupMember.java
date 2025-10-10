package io.universechat.app.entity;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.entity.BaseEntity;
import io.universechat.app.enums.GroupMemberStatus;
import jakarta.persistence.*;
import lombok.*;

@Serdeable
@Entity @Table(name = "group_members")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor
public class GroupMember extends BaseEntity {

    @ManyToOne @JoinColumn(name = "group_id", nullable = false)
    @NonNull
    private Group group;

    @Column(name = "user_id", nullable = false)
    @NonNull
    private Long userId;

    @ManyToOne @JoinColumn(name = "group_member_role_id", nullable = false)
    @NonNull
    private GroupMemberRole role;

    @Enumerated(EnumType.STRING)
    @Column(name = "group_member_status", nullable = false)
    private GroupMemberStatus status;

    public GroupMember(String note, String createdBy, @NonNull Group group, @NonNull Long userId, @NonNull GroupMemberRole role, GroupMemberStatus status) {
        super(note, createdBy);
        this.group = group;
        this.userId = userId;
        this.role = role;
        this.status = status;
    }
}
