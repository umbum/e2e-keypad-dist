package bob.e2e.external.client

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.time.Duration

@Component
class SampleWebClient(
    webClientBuilder: WebClient.Builder,
) {
    private val webClient: WebClient = webClientBuilder
        .baseUrl("http://echo.jsontest.com")
        .build()

    fun sample(): Mono<String> {
        return webClient.get().uri("/key/value/one/two")
            .retrieve()
            .bodyToMono(String::class.java)
            .delayElement(Duration.ofSeconds(10))
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleWebClient::class.java)
    }
}
