package bob.e2e.external.client

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import reactor.core.publisher.Mono

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
    }

    suspend fun sampleCoroutine(): String {
        return webClient.get().uri("/key/value/one/two")
            .retrieve()
            .awaitBody<String>()
    }
}
