package bob.e2e.presentation.controller

import bob.e2e.domain.service.SampleCoroutineService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/request-per-virtual-thread")
@RestController
class SampleRequestPerVirtualThreadController(
    private val sampleCoroutineService: SampleCoroutineService,
) {
    @GetMapping("/coroutine")
    suspend fun sampleCoroutine(): List<String> {
        return sampleCoroutineService.runOnCoroutine()
    }

    @GetMapping("/vt")
    suspend fun sampleVt(): List<String> {
        return sampleCoroutineService.runOnVirtualThread()
    }
}
