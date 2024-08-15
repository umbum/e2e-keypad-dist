package bob.e2e.domain.service

import bob.e2e.external.client.SampleHttpExchange
import bob.e2e.external.client.SampleOpenFeign
import bob.e2e.external.client.SampleRestClient
import bob.e2e.external.client.SampleWebClient
import org.springframework.stereotype.Service

@Service
class SampleHttpClientService(
    private val sampleHttpExchange: SampleHttpExchange,
    private val sampleOpenFeign: SampleOpenFeign,
    private val sampleRestClient: SampleRestClient,
    private val sampleWebClient: SampleWebClient,
) {
    fun useHttpExchange(): String = sampleHttpExchange.sample()

    fun useOpenFeign(): String = sampleOpenFeign.sample()

    fun useRestClient(): String = sampleRestClient.sample()

    fun useWebClientBlock(): String = sampleWebClient.sample().block()!!
}
