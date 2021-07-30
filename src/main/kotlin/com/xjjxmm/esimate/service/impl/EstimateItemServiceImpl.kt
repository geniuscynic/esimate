package com.xjjxmm.esimate.service.impl

import com.alibaba.fastjson.JSON
import com.xjjxmm.esimate.repository.EstimateItemRepository
import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.esimate.service.EstimateItemService
import com.xjjxmm.esimate.service.EstimateTemplateParseHandler
import com.xjjxmm.esimate.vo.*
import javafx.scene.control.RadioButton
import org.joda.time.DateTime
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Service
import springfox.documentation.spring.web.json.Json
import utity.MappingKit.mapper
import java.lang.annotation.ElementType
import java.time.LocalDate
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

        log.debug("测试：${entity.id}")

        return  when (entity.id == null) {
            true  -> 0
            false -> entity.id!!
        }
    }

    override fun getByEstimateId(id: Long): EstimateItemVo {
        val entity = estimateItemRepository.getById(id)
        val item = entity.mapper<EstimateItemVo>().apply {

                val estmateItems = JSON.parseArray(entity.content, SelectedEstimateItem::class.java)
                val template = getTemplate(this.code)
                template.setSelectedItems(estmateItems)

                this.detail = template
        }

        return item
    }

    override fun findByPatientId(patientId: Long): List<EstimateItemVo> {
        val entity = estimateItemRepository.findByPatientId(patientId)

        return entity.mapper()
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