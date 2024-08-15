package bob.e2e.presentation.controller

import bob.e2e.domain.service.SampleHttpClientService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class SampleHttpClientController(
    private val sampleHttpClientService: SampleHttpClientService,
) {
    @GetMapping("/sample")
    fun test(): String {
        return "sample controller response"
    }

    @GetMapping("/sample/http-exchange")
    fun useHttpExchange() = sampleHttpClientService.useHttpExchange()

    @GetMapping("/sample/open-feign")
    fun useOpenFeign() = sampleHttpClientService.useOpenFeign()

    @GetMapping("/sample/rest-client")
    fun useRestClient() = sampleHttpClientService.useRestClient()

    @GetMapping("/sample/web-client")
    fun useWebClient() = sampleHttpClientService.useWebClientBlock()
}
