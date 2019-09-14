package my.company.test.websocket.highload.controller

import my.company.test.websocket.highload.pojo.Message
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import java.util.concurrent.atomic.AtomicInteger

@Controller
class WebsocketController(
        private val messageTemplate: SimpMessagingTemplate
) {

    private var counter: AtomicInteger = AtomicInteger(0)

    @MessageMapping("/websocket/message")
    fun received(message: Message) {
        println(counter.incrementAndGet())
        println(message)
        messageTemplate.convertAndSend("/topic", message)
    }

}