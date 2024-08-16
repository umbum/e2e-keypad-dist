package bob.e2e.domain.service

import bob.e2e.external.client.SampleWebClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SampleReactiveService(
    val sampleWebClient: SampleWebClient,
) {
    /**
     * 왜 전체 시스템에서 반환 타입이 Mono가 될 수 밖에 없는가?
     * ```
     * val listString = monoOfList.block()!!
     * ```
     */
    fun runOnEventLoop(): Mono<List<String>> {
        logger.info("start runOnEventLoop")

        val monoOfList: Mono<List<String>> = Flux.fromIterable(0..9)
            .flatMap { sampleWebClient.sample() }
            .collectList()
            .doOnSuccess { logger.info(it.toString()) }

        return monoOfList
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleReactiveService::class.java)
    }
}
