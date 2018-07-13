package com.cbond.net.config;


import com.cbond.net.CBondWebSocketHanddler;
import com.cbond.net.HandShakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@EnableWebMvc
public class CBondWebSocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //前台 可以使用websocket环境
        webSocketHandlerRegistry.addHandler(myhandler(), "/websocket").addInterceptors(new HandShakeInterceptor()).setAllowedOrigins("*");

        //前台 不可以使用websocket环境，则使用sockjs进行模拟连接
        webSocketHandlerRegistry.addHandler(myhandler(), "/sockjs/websocket").addInterceptors(new HandShakeInterceptor())
                .withSockJS();
    }

    @Bean
    public WebSocketHandler myhandler() {
        return new CBondWebSocketHanddler();
    }
}
