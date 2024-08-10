package bob.e2e

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class SampleController {
    @GetMapping("/sample")
    fun test(): String {
        return "sample controller response"
    }
}
