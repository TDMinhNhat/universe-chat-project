package io.universechat.app.entity;

import io.micronaut.data.annotation.*;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.time.Instant;

@Serdeable
@MappedEntity(value = "private_chats")
@Getter @Setter
@NoArgsConstructor
public class PrivateChat {

    @Id @GeneratedValue(GeneratedValue.Type.IDENTITY)
    @MappedProperty(value = "id", type = DataType.BIGDECIMAL)
    private Long id;

    @MappedProperty(value = "chat_reply_id", type = DataType.BIGDECIMAL)
    private Long chatReplyId;

    @MappedProperty(value = "friend_id", type = DataType.BIGDECIMAL)
    @NonNull
    private Long friendId;

    @MappedProperty(value = "sender_id", type = DataType.BIGDECIMAL)
    @NonNull
    private Long senderId;

    @MappedProperty(value = "is_read", type = DataType.BOOLEAN)
    private Boolean isRead;

    @MappedProperty(value = "is_recall", type = DataType.BOOLEAN)
    private Boolean isRecall;

    @MappedProperty(value = "message", type = DataType.STRING)
    @NonNull
    private String message;

    @DateCreated
    @MappedProperty(value = "created_at", type = DataType.TIMESTAMP)
    private Instant createdAt;

    @DateUpdated
    @MappedProperty(value = "updated_at", type = DataType.TIMESTAMP)
    private Instant updatedAt;

    public PrivateChat(@NonNull String message, Long chatReplyId, @NonNull Long friendId, @NonNull Long senderId) {
        this.message = message;
        this.chatReplyId = chatReplyId;
        this.friendId = friendId;
        this.senderId = senderId;
        this.isRead = this.isRecall = false;
    }
}
