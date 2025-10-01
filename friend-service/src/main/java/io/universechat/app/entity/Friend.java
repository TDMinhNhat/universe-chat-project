package io.universechat.app.entity;

import io.micronaut.serde.annotation.Serdeable;
import io.universechat.app.core.entity.BaseEntity;
import io.universechat.app.enums.FriendStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Serdeable
@Entity @Table(name = "friends")
@Getter @Setter
@NoArgsConstructor @RequiredArgsConstructor @EqualsAndHashCode(callSuper = true)
@DynamicInsert
@DynamicUpdate
public class Friend extends BaseEntity {

    @Column(name = "sender_id", nullable = false)
    @NonNull
    private Long senderId;

    @Column(name = "received_id", nullable = false)
    @NonNull
    private Long receivedId;

    @Column(name = "sender_note", length = 500)
    private String senderNote;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(100) DEFAULT 'ANONYMOUSE'")
    private FriendStatus status;

    public Friend(String note, String createdBy, @NonNull Long senderId, @NonNull Long receivedId, String senderNote, FriendStatus status) {
        super(note, createdBy);
        this.senderId = senderId;
        this.receivedId = receivedId;
        this.senderNote = senderNote;
        this.status = status;
    }
}
