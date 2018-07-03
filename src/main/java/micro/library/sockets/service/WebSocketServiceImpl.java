package micro.library.sockets.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {

    private final SimpMessagingTemplate webSocket;

    public WebSocketServiceImpl(SimpMessagingTemplate webSocket) {
        this.webSocket = webSocket;
    }

    @Override
    public void sendPayload(String destination, String payload) {
        webSocket.convertAndSend(destination, payload);
    }

}
