package com.xjjxmm.estimate.service.impl

import com.alibaba.fastjson.JSON
import com.xjjxmm.estimate.repository.EstimateItemRepository
import com.xjjxmm.estimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.estimate.service.EstimateItemService
import com.xjjxmm.estimate.service.EstimateTemplateParseHandler
import com.xjjxmm.estimate.vo.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import utity.MappingKit.mapper
import java.time.LocalDateTime
import javax.xml.parsers.SAXParserFactory

@Service
class EstimateItemServiceImpl : EstimateItemService {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var estimateItemRepository : EstimateItemRepository


    override fun add(estimateItem: AddEstimateItemVo) : Long {
        val entity = estimateItem.mapper<EstimateItemEntity>()

        entity.createTime = LocalDateTime.now()
        entity.createUserId = 0
        entity.content = JSON.toJSONString(estimateItem.data)
            //DateTime.now().
        estimateItemRepository.save(entity)


        return  when (entity.id == null) {
            true  -> 0
            false -> entity.id!!
        }
    }

    override fun save(estimateItem: EditEstimateItemVo): Boolean {
        val entity = estimateItem.mapper<EstimateItemEntity>()
        entity.updateTime = LocalDateTime.now()
        entity.updateUserId = 0
        entity.content = JSON.toJSONString(estimateItem.data)

        return estimateItemRepository.updateById(entity)
    }

    override fun getByEstimateId(id: Long): EstimateItemVo {
        val entity = estimateItemRepository.getById(id)
        val item = entity.mapper<EstimateItemVo>().apply {

                val estmateItems = JSON.parseArray(entity.content, SelectedEstimateItem::class.java)
                val template = getTemplate(entity?.code!!)
                template.setSelectedItems(estmateItems)

                this.detail = template
        }

        return item
    }

    override fun findByPatientId(patientId: Long): List<PatientEstimateItemListVo> {
        val entity = estimateItemRepository.findByPatientId(patientId)

        return entity.mapper()
    }

    override fun listEstimate(): List<EstimateItemListVo> {
        return listOf(
            EstimateItemListVo().apply {
                code = "abcd2"
                title = "abcd2"
            },
            EstimateItemListVo().apply {
                code = "abcd3"
                title = "abcd3"
            },
        )
    }

    override fun getTemplate(code:String) : EstimateTemplate {
        val resourceLoader: ResourceLoader = DefaultResourceLoader()

        val inputFile: Resource = resourceLoader.getResource("templates/$code.xml")

        if(!inputFile.exists()) {
            throw Exception("$code.xml 文件不存在")
        }

        val sAXParserFactory = SAXParserFactory.newInstance()
        val sAXParser = sAXParserFactory.newSAXParser()

        val handler = EstimateTemplateParseHandler()
        sAXParser.parse(inputFile.inputStream, handler)

        return handler.estimateTemplate

    }
}