package bob.e2e.external.client

import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class SampleRestClient(
    restClientBuilder: RestClient.Builder,
) {
    private val restClient: RestClient = restClientBuilder
        .baseUrl("http://echo.jsontest.com")
        .build()

    fun sample(): String {
        return restClient.get().uri("/key/value/one/two")
            .retrieve()
            .body(String::class.java)!!
    }
}
