package com.xjjxmm.estimate.service.impl

import com.alibaba.fastjson.JSON
import com.xjjxmm.estimate.model.EstimateTemplate
import com.xjjxmm.estimate.repository.EstimateItemRepository
import com.xjjxmm.estimate.repository.EstimateTemplateRepository
import com.xjjxmm.estimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.estimate.repository.pojo.EstimateTemplateEntity
import com.xjjxmm.estimate.service.EstimateItemService
import com.xjjxmm.estimate.service.EstimateTemplateParseHandler
import com.xjjxmm.estimate.vo.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.stereotype.Service
import utity.MappingKit.mapper
import java.io.InputStream
import java.time.LocalDateTime
import javax.xml.parsers.SAXParserFactory

@Service
class EstimateItemServiceImpl : EstimateItemService {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var estimateItemRepository : EstimateItemRepository

    @Autowired
    lateinit var estimateTemplateRepository : EstimateTemplateRepository

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
                val template = getTemplate(entity?.estimateCode!!)
                template.setItems(estmateItems)

                this.detail = template
        }

        return item
    }

    override fun findByPatientId(patientId: Long): List<PatientEstimateItemListVo> {
        val entity = estimateItemRepository.findByPatientId(patientId)

        return entity.mapper()
    }

    override fun initEstimateTemplate(): List<EstimateItemListVo> {
        val pathResource = PathMatchingResourcePatternResolver().getResources("templates/*.xml")

        estimateTemplateRepository.remove(null)
        return pathResource.map {res->

            val template = parseXml(res.inputStream)


            estimateTemplateRepository.save(EstimateTemplateEntity().apply {
                code = template.code
                title = template.title
                fileName = res.filename
            })

            EstimateItemListVo().apply {
                code = template.code
                title = template.title


            }

        }
    }

    override fun listEstimate(): List<EstimateItemListVo> {
        return estimateTemplateRepository.list().map {
            EstimateItemListVo().apply {
                code = it.code!!
                title = it.title!!
            }
        }
//        val pathResource = PathMatchingResourcePatternResolver().getResources("templates/*.xml")
//        return pathResource.map {res->
//            val template = parseXml(res.inputStream)
//
//            EstimateItemListVo().apply {
//                code = template.code
//                title = template.title
//            }
//        }

    }

    override fun getTemplate(code:String) : EstimateTemplate {

        return estimateTemplateRepository.ktQuery()
            .eq(EstimateTemplateEntity::code, code).list()
            .firstOrNull()?.let {
                val resourceLoader: ResourceLoader = DefaultResourceLoader()

                val inputFile: Resource = resourceLoader.getResource("templates/${it.fileName}")

                if(!inputFile.exists()) {
                    throw Exception("$code.xml 文件不存在")
                }



                return parseXml(inputFile.inputStream)
            }?: EstimateTemplate()




    }

    private fun parseXml(inputStream : InputStream) : EstimateTemplate {
        val sAXParserFactory = SAXParserFactory.newInstance()
        val sAXParser = sAXParserFactory.newSAXParser()

        val handler = EstimateTemplateParseHandler()
        sAXParser.parse(inputStream, handler)

        return handler.estimateTemplate

    }
}