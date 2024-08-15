package bob.e2e.external.client

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.time.Duration

@Component
class SampleRestClient(
    restClientBuilder: RestClient.Builder,
) {
    private val restClient: RestClient = restClientBuilder
        .baseUrl("http://echo.jsontest.com")
        .build()

    fun sample(): String {
        Thread.sleep(Duration.ofSeconds(10))
        return restClient.get().uri("/key/value/one/two")
            .retrieve()
            .body(String::class.java)!!
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleRestClient::class.java)
    }
}
