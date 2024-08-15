package bob.e2e.domain.service

import bob.e2e.external.client.SampleRestClient
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.Callable
import java.util.concurrent.Executors

@Service
class SampleThreadPoolService(
    val sampleRestClient: SampleRestClient,
) {
    private val threadPool = Executors.newFixedThreadPool(10)

    // TODO 9 -> 19 -> 199로 변경하고 호출
    fun runOnThreadPool(): List<String> {
        logger.info("start runOnThreadPool")
        val futures = (0..9).map { i ->
            threadPool.submit(
                Callable { sampleRestClient.sample() },
            )
        }

        val results = futures.map { it.get() }

        logger.info(results.toString())
        return results
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleThreadPoolService::class.java)
    }
}
