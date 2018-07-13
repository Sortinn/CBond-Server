package com.cbond.net;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;
import java.util.logging.Logger;

//握手拦截器，用来拦截和处理客户端和服务器端分别在握手前和握手后的事件，我们这里添加这个拦截器是为了清晰的知道什么时候以及是否握手成功。
public class HandShakeInterceptor extends HttpSessionHandshakeInterceptor {
    private Logger logger = Logger.getLogger(String.valueOf(HandShakeInterceptor.class));

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        logger.info("++ HandshakeInterceptor: beforeHandshake ++" + attributes);
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        logger.info("++ HandshakeInterceptor: afterHandshake ++");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
