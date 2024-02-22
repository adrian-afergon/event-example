package es.leanmind.eventexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class EventExampleApplication

fun main(args: Array<String>) {
    runApplication<EventExampleApplication>(*args)
}
