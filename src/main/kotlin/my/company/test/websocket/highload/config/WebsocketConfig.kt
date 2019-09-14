package my.company.test.websocket.highload.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebsocketConfig : WebSocketMessageBrokerConfigurer {


    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/api/websocket").setAllowedOrigins("*")
        registry.addEndpoint("/api/websocket").setAllowedOrigins("*").withSockJS()
    }

    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.setApplicationDestinationPrefixes("/api")
        registry.enableSimpleBroker("/topic")
    }

}