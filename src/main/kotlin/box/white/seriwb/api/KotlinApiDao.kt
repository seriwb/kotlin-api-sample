package box.white.seriwb.api

import box.white.seriwb.api.jooq.public_.Tables.SAMPLE
import box.white.seriwb.api.jooq.public_.tables.records.SampleRecord
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class KotlinApiDao {

    @Autowired
    lateinit var create: DSLContext

    suspend fun findSample(id: Long): SampleRecord {
        val result = create
                .selectFrom(SAMPLE)
                .where(SAMPLE.ID.eq(id))
                .fetch()
        return result.first()
    }
}