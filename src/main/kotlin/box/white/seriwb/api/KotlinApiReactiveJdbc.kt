package box.white.seriwb.api

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Component
class KotlinApiReactiveJdbc<in T> {

    fun execute(closure: () -> T): Mono<ServerResponse> {
        val result: Mono<T> = Mono.fromCallable(closure).subscribeOn(Schedulers.elastic())

        return result.flatMap { it ->
            ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                    .syncBody("{\"result\":\"$it\"}")
        }
    }
}