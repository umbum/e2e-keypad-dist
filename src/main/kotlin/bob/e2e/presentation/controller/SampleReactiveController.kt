package bob.e2e.presentation.controller

import bob.e2e.domain.service.SampleReactiveService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RequestMapping("/api/reactive")
@RestController
class SampleReactiveController(
    private val sampleReactiveService: SampleReactiveService,
) {
    @GetMapping("/event-loop")
    fun sampleEventLoop(): Mono<List<String>> {
        return sampleReactiveService.runOnEventLoop()
    }
}
