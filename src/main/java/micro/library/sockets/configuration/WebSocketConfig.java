package micro.library.sockets.configuration;

import micro.library.sockets.service.WebSocketService;
import micro.library.sockets.service.WebSocketServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final SimpMessagingTemplate webSocket;

    private final static String ENDPOINT = "/sockets";

    public WebSocketConfig(SimpMessagingTemplate webSocket) {
        this.webSocket = webSocket;
    }

    @Bean
    public WebSocketService webSocketService() {
        return new WebSocketServiceImpl(webSocket);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(ENDPOINT)
                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.setApplicationDestinationPrefixes(ENDPOINT);
        config.enableSimpleBroker("/");
    }

}