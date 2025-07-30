package bob.e2e.external.client

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class SampleRestClient(
    restClientBuilder: RestClient.Builder,
) {
    private val restClient: RestClient = restClientBuilder
        .baseUrl("https://httpbin.org")
        .build()

    fun sample(): String {
        return restClient.get().uri("/delay/10")
            .retrieve()
            .body(String::class.java)!!
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleRestClient::class.java)
    }
}
