package bob.e2e.config

import bob.e2e.external.client.SampleHttpExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class HttpExchangeBeanFactory(
    val restClientBuilder: RestClient.Builder,
) {
    @Bean
    fun sampleHttpExchange(): SampleHttpExchange {
        return HttpServiceProxyFactory
            .builderFor(RestClientAdapter.create(restClientBuilder.build()))
            .build()
            .createClient(SampleHttpExchange::class.java)
    }
}
