package bob.e2e.domain.service

import bob.e2e.external.client.SampleWebClient
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactor.awaitSingle
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.concurrent.Callable
import java.util.concurrent.Executors

@Service
class SampleCoroutineService(
    val sampleWebClient: SampleWebClient,
) {
    val executor = Executors.newVirtualThreadPerTaskExecutor()

    suspend fun runOnCoroutine(): List<String> {
        logger.info("start runOnThreadPool")
        val deferredList = coroutineScope {
            (0..9).map {
                async { sampleWebClient.sample().awaitSingle() }
            }
        }

        val results = deferredList.awaitAll()
        logger.info(results.toString())
        return results
    }

    fun runOnVirtualThread(): List<String> {
        logger.info("start runOnVirtualThread")
        val futures = (0..9).map {
            executor.submit(
                Callable { sampleWebClient.sample().block()!! },
            )
        }

        val results = futures.map { it.get() }

        logger.info(results.toString())
        return results
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SampleCoroutineService::class.java)
    }
}
