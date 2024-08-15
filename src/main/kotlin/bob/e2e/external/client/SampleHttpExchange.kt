package bob.e2e.external.client

import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

@HttpExchange("http://echo.jsontest.com")
interface SampleHttpExchange {
    @GetExchange("/key/value/one/two")
    fun sample(): String
}
