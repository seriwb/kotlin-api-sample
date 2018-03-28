package box.white.seriwb.api

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class KotlinApiRepository {

    @Autowired
    lateinit var dao: KotlinApiDao

    @Transactional
    fun getSimpleResponseData(id: Long): SimpleResponseData = runBlocking {
        val sample = async { dao.findSample(id) }

        SimpleResponseData(sample.await().value)
    }
}

data class SimpleResponseData(
    val envelope: String
)
