package bob.e2e.presentation.controller

import bob.e2e.domain.service.SampleReactiveService
import bob.e2e.domain.service.SampleThreadPoolService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/request-per-thread")
@RestController
class SampleRequestPerThreadController(
    private val sampleThreadPoolService: SampleThreadPoolService,
    private val sampleReactiveService: SampleReactiveService,
) {
    @GetMapping("/thread-pool")
    fun sampleThreadPool(): List<String> {
        return sampleThreadPoolService.runOnThreadPool()
    }

    @GetMapping("/event-loop")
    fun sampleEventLoop(): List<String> {
        return sampleReactiveService.runOnEventLoop()
    }
}
