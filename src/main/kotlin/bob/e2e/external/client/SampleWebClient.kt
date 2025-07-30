package bob.e2e.external.client

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class SampleWebClient(
    webClientBuilder: WebClient.Builder,
) {
    private val webClient: WebClient = webClientBuilder
        .baseUrl("https://httpbin.org")
        .build()

    fun sample(): Mono<String> {
        return webClient.get().uri("/delay/10")
            .retrieve()
            .bodyToMono(String::class.java)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleWebClient::class.java)
    }
}
