package bob.e2e.domain.service

import bob.e2e.external.client.SampleWebClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SampleReactiveService(
    val sampleWebClient: SampleWebClient,
) {
    fun runOnEventLoop(): List<String> {
        logger.info("start runOnEventLoop")
        val listOfMonos = (0..9).map { i ->
            sampleWebClient.sample()
        }

        val results = Flux.fromIterable(listOfMonos)
            .flatMap { it }
            .collectList()
            .block()!!

        logger.info(results.toString())
        return results
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleReactiveService::class.java)
    }
}
