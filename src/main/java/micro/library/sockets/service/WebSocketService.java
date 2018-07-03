package micro.library.sockets.service;

public interface WebSocketService {

    /**
     * Send simple objects to a simple destination ;)
     *
     * @param destination Where it's going, example: /sockets
     * @param payload Serialized object. I'd suggest making use of json-micro-library.
     */
    void sendPayload(String destination, String payload);

}
