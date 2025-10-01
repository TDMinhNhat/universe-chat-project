package io.universechat.app.enums;

import io.micronaut.http.server.exceptions.NotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public enum FriendStatus {
    SENDING, ACCEPTED, REJECTED, BLOCKED, ANONYMOUSE;

    public List<FriendStatus> getNextPossibleStatuses(@Valid @NotNull(message = "can not be null or empty") FriendStatus status) {
        return switch(status) {
            case SENDING -> List.of(ACCEPTED, REJECTED, BLOCKED, ANONYMOUSE);
            case ACCEPTED -> List.of(BLOCKED);
            case ANONYMOUSE -> List.of(SENDING);
            case REJECTED, BLOCKED -> List.of(ANONYMOUSE);
        };
    }
}
