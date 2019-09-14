package my.company.test.websocket.highload.controller

import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent
import java.util.concurrent.atomic.AtomicLong

@Component
class Listener {

    private var counterConnect: AtomicLong = AtomicLong(0)
    private var counterSubscribe: AtomicLong = AtomicLong(0)

    @EventListener
    fun onConnection(event: SessionConnectEvent) {
        println("connect =" + counterConnect.incrementAndGet())
    }

    @EventListener
    fun onDisconnection(event: SessionDisconnectEvent) {
        println("connect =" + counterConnect.decrementAndGet())
        println("subscribe =" + counterSubscribe.decrementAndGet())
    }


    @EventListener
    fun onSubscribe(event: SessionSubscribeEvent) {
        println("subscribe =" + counterSubscribe.incrementAndGet())
    }

}