package io.universechat.app.socket;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;

@ServerWebSocket("/ws/chat")
@RequiredArgsConstructor
public class ChatServerWebSocket {

    private final WebSocketBroadcaster broadcaster;

    @OnOpen
    public Publisher<String> onOpen(WebSocketSession session) {
        return broadcaster.broadcast("You have connected to the server by through WebSocket");
    }

    @OnMessage
    public Publisher<String> onMessage(String message, WebSocketSession session) {
        return broadcaster.broadcast("The server got your message");
    }

    @OnClose
    public Publisher<String> onClose(WebSocketSession session) {
        return broadcaster.broadcast("Someone has disconnected");
    }
}
