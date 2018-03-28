package box.white.seriwb.api

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

/**
 * ルーティングは1つのファイルにまとめるとわかりやすいので、基本1つにまとめる
 * （別ファイルになるくらいなら、アプリケーションごと分けたほうが良いかも）
 */
@Configuration
class KotlinApiRouter(private val handler: KotlinApiHandler) {

    @Bean
    fun routes() = router {
        GET("/", handler::index)
        GET("/anime", handler::callAnimeApi)
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/dbuse", handler::dbInit)
                GET("/dbuse/create", handler::dbInsert)
                GET("/dbuse/{id}", handler::dbSelect)
                GET("/dbuse/{id}/update", handler::dbUpdate)
                GET("/dbuse2/{id}", handler::coroutineSelect)
            }
        }
    }
}