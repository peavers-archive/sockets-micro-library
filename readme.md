[![](https://jitpack.io/v/peavers/sockets-micro-library.svg)](https://jitpack.io/#peavers/sockets-micro-library)
[![Maintainability](https://api.codeclimate.com/v1/badges/4e30b4c332bc8c87686a/maintainability)](https://codeclimate.com/github/peavers/sockets-micro-library/maintainability)

# Sockets micro library
A very tiny wrapper around a Spring sockets. This is almost pointless, yet here it is.

## What's a micro library? 
Just that, a very tiny standalone .jar which can be imported into a project to do a very specific thing. 

## Installation
Since we're making good use of JitPack, this is simple. 

```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
	
dependencies {
    implementation 'com.github.peavers:sockets-micro-library:-SNAPSHOT'
}	
```
Click the JitPack build badge for more examples with maven, sbt example. 

## Spring boot example

A base configuration already exists so you can just extend it and change what's needed, or leave it as is. 
```java
@Configuration
@EnableWebSocketMessageBroker
public class CustomWebSocketConfig extends WebSocketConfig {

    private final SimpMessagingTemplate webSocket;

    public CustomWebSocketConfig(SimpMessagingTemplate webSocket) {
        this.webSocket = webSocket;
    }

    @Bean
    public WebSocketService webSocketService() {
        return new WebSocketServiceImpl(webSocket);
    }
}
```

Sending a message is as simple as calling `sendPayload`
```java
public class Example {

    @Autowired
    private final WebSocketService webSocketService;
    
    private void sendMessage(String message) {
        webSocketService.sendPayload("/sockets", message);
    }
}
```