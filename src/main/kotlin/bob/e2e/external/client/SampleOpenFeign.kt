package bob.e2e.external.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "sampleOpenFeign", url = "http://echo.jsontest.com")
interface SampleOpenFeign {
    @GetMapping("/key/value/one/two")
    fun sample(): String
}
