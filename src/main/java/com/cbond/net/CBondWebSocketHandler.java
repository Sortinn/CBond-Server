package com.cbond.net;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CBondWebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = Logger.getLogger(String.valueOf(CBondWebSocketHandler.class));
    private static final List<WebSocketSession> users = new ArrayList<WebSocketSession>();
    private static final List<String> usersMessage = new ArrayList<String>();

    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        log.info("connect websocket success...");
        users.add(webSocketSession);
    }

    public void handleTextMessage(WebSocketSession webSocketSession, TextMessage message) throws Exception {
        super.handleTextMessage(webSocketSession, message);
        TextMessage returnMessage = new TextMessage(message.getPayload() + " received from client");
        String content = message.getPayload();
        usersMessage.add(content);
        log.info("client's message >> " + content);
    }


    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        log.warning("handleTransportError");
        users.remove(webSocketSession);

    }

    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        log.info("websocket closed.......");
        users.remove(webSocketSession);
    }

    public boolean supportsPartialMessages() {
        return false;
    }

    public void sentToAllUsers(WebSocketMessage<?> message) throws IOException {
        for (WebSocketSession user : users) {
            user.sendMessage(message);
        }

    }
}
