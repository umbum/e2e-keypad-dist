package bob.e2e

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class E2eKeypadApplication

fun main(args: Array<String>) {
    runApplication<E2eKeypadApplication>(*args)
}
