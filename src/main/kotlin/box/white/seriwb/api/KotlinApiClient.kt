package box.white.seriwb.api

import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

/**
 * 送信処理のサンプル
 */
@Service
class KotlinApiClient {

    companion object {
        const val API_URL = "http://api.moemoe.tokyo/anime/v1"
    }

    val client: WebClient = WebClient.create(API_URL)

    /**
     * GETリクエストで文字列を受信するサンプル
     */
    fun sendMessage(str: String): String =
            client
                .get() // GETリクエスト
                .uri("/master/cours") // アクセス先URL
                .accept(MediaType.APPLICATION_JSON_UTF8) // 送信ヘッダ
                .retrieve()             // 送信実施
                .bodyToMono<String>()   // 文字列の受信
                .block()                // 応答待ち
                .orEmpty()              // nullの場合に空文字返却
}