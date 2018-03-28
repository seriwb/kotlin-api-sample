package box.white.seriwb.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class KotlinApiRepository {

    @Autowired
    lateinit var dao: KotlinApiDao

    @Transactional
    fun getSimpleResponseData(id: Long): SimpleResponseData {
        val sample = dao.findSample(id)

        return SimpleResponseData(sample.value)
    }
}

data class SimpleResponseData(
    val envelope: String
)
