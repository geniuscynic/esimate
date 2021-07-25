package com.xjjxmm.esimate.service.impl

import com.xjjxmm.esimate.repository.EstimateItemRepository
import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.esimate.service.EstimateItemService
import com.xjjxmm.esimate.vo.AddEstimateItemVo
import com.xjjxmm.esimate.vo.EstimateItemVo
import org.joda.time.DateTime
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import utity.MappingKit.mapper
import java.time.LocalDate
import java.time.LocalDateTime

@Service
class EstimateItemServiceImpl : EstimateItemService {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var estimateItemRepository : EstimateItemRepository

    override fun add(estimateItem: AddEstimateItemVo) : Long {
        val entity = estimateItem.mapper<EstimateItemEntity>()
        entity.createTime = LocalDateTime.now()
            //DateTime.now().
        estimateItemRepository.save(entity)

        log.debug("测试：${entity.id}")

        return  when (entity.id == null) {
            true  -> 0
            false -> entity.id!!
        }
    }

    override fun getById(id: Long): EstimateItemVo {
        val entity = estimateItemRepository.getById(id)

        return entity.mapper()
    }

    override fun findByPatientId(patientId: Long): List<EstimateItemVo> {
        val entity = estimateItemRepository.findByPatientId(patientId)

        return entity.mapper()
    }
}