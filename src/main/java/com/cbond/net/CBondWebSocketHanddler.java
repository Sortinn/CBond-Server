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

public class CBondWebSocketHanddler extends TextWebSocketHandler {
    private static final Logger log = Logger.getLogger(String.valueOf(CBondWebSocketHanddler.class));
    private static final List<WebSocketSession> users = new ArrayList<WebSocketSession>();
    private static final List<String> userMessage = new ArrayList<String>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connect client success...");
        users.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        String clientMessage = message.getPayload();
        userMessage.add(clientMessage);
        log.info(clientMessage + " Received from client");
        String response = "Hello client, I'm server";
        TextMessage responseMessage = new TextMessage(response);
        sendToAllUsers(responseMessage);
    }

    private void sendToAllUsers(WebSocketMessage message) throws IOException {
        for (WebSocketSession session : users) {
            session.sendMessage(message);
        }
    }

    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        log.warning("handleTransportError");
        users.remove(webSocketSession);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("Websocket closed...");
        users.remove(session);
    }

    public boolean supportsPartialMessages() {
        return false;
    }

}
