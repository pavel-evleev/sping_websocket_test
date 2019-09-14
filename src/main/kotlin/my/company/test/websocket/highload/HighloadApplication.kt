package my.company.test.websocket.highload

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HighloadApplication

fun main(args: Array<String>) {
    runApplication<HighloadApplication>(*args)
}
