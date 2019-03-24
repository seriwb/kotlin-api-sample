package box.white.seriwb.api

import box.white.seriwb.api.jooq.public_.Tables.SAMPLE
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * 公開しているURLがハンドルする処理を記述するクラス
 */
@Component
class KotlinApiHandler {

    // URLルートにアクセスされた場合の挙動
    fun index(req: ServerRequest): Mono<ServerResponse> =
            // Fluxは複数の値を順に返していく
            ok().body(Flux.just("Hello", "World!"), String::class.java)

    // ------ DBアクセス系の挙動確認 ---------
    @Autowired
    lateinit var create: DSLContext

    companion object {
        // 本当はconst valで定数にしたいが、処理が入るとエラーになるのでできない
        // （Const 'val' initializer should be a constant value）
        val T_SAMPLE = """
            | create table if not exists sample (
            | id bigint auto_increment not null primary key,
            | key varchar2(200),
            | value varchar2(200))""".trimMargin()
    }

    /**
     * これを実行するとsampleテーブルが作成されるので、最初に実行する
     */
    @Transactional
    fun dbInit(req: ServerRequest): Mono<ServerResponse> {

        // テーブル作成（SQL実行の例）
        val result: Result<Record> = create.fetch(T_SAMPLE)

        // 単純な文字列を返す場合はsyncBodyでOK
        return ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\"result\":\"$result\"}")
    }

    /**
     * sampleテーブルにデータをInsertするサンプル
     */
    @Transactional
    fun dbInsert(req: ServerRequest): Mono<ServerResponse> {

        val result: Int = create
                .insertInto(SAMPLE)
                .set(SAMPLE.KEY, "10")
                .set(SAMPLE.VALUE, "test10")
                .execute()

        return ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\"result\":\"$result\"}")
    }

    @Transactional
    fun dbSelect(req: ServerRequest): Mono<ServerResponse> {

        val id = req.pathVariable("id").toLong()

//        val result = create
//                .select()
//                .from(SAMPLE)
//                .where(SAMPLE.ID.eq(id))
//                .fetch()
//
//        return ok()
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .syncBody("{\"result\":\"$result\"}")

        val db = KotlinApiReactiveJdbc<String>()
        return db.execute {
            create.select()
                    .from(SAMPLE)
                    .where(SAMPLE.ID.eq(id))
                    .fetch().format()
        }
    }

    @Transactional
    fun dbUpdate(req: ServerRequest): Mono<ServerResponse> {

        val id = req.pathVariable("id").toLong()

        // 更新値を設定する
        val key = req.queryParam("key")
        val value = req.queryParam("value")

        // 更新処理実施
        val s = SAMPLE
        val result = create
                .update(s)
                .set(s.KEY, key.orElse("99")) // 元の値を引っ張っていればそれをElse値にしてあげれば良さそう
                .set(s.VALUE, value.orElse("test99"))
                .where(s.ID.eq(id))
                .execute()

        return ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\"result\":\"$result\"}")
    }

    // ---- API呼び出しのサンプル -----
    @Autowired
    lateinit var client: KotlinApiClient

    fun callAnimeApi(req: ServerRequest): Mono<ServerResponse> {
        val result: String = client.sendMessage("{}")

        return ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\"result\":\"$result\"}")
    }

    // ----- コルーチンのサンプル -----
    @Autowired
    lateinit var repository: KotlinApiRepository

    fun coroutineSelect(req: ServerRequest): Mono<ServerResponse> = runBlocking {

        val id = req.pathVariable("id").toLong()

        val responseData = async {
            repository.getSimpleResponseData(id)
        }

        ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .syncBody("{\"result\":\"${responseData.await().envelope}\"}")
    }
}